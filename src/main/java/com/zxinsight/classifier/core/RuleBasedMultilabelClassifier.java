package com.zxinsight.classifier.core;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.rules.ConfigurationException;
import javax.rules.InvalidRuleSessionException;
import javax.rules.RuleExecutionSetNotFoundException;
import javax.rules.RuleRuntime;
import javax.rules.RuleServiceProvider;
import javax.rules.RuleServiceProviderManager;
import javax.rules.RuleSessionCreateException;
import javax.rules.RuleSessionTypeUnsupportedException;
import javax.rules.StatelessRuleSession;
import javax.rules.admin.RuleAdministrator;
import javax.rules.admin.RuleExecutionSet;
import javax.rules.admin.RuleExecutionSetCreateException;
import javax.rules.admin.RuleExecutionSetRegisterException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zxinsight.classifier.Classifier;
import com.zxinsight.classifier.common.ProductReview;
import com.zxinsight.classifier.common.ProductReviewWithLabels;
import com.zxinsight.classifier.ruleengine.RuleSet;
import com.zxinsight.classifier.ruleengine.UriConstants;
import com.zxinsight.classifier.ruleengine.util.RuleEngineLog;

public class RuleBasedMultilabelClassifier implements Classifier<ProductReview> {

  private static RuleBasedMultilabelClassifier classifier;

  private static StatelessRuleSession srs;

  private static final String RULES_CONFIG_XML = "com/zxinsight/classifier/ruleengine/rule/ruleset_01.xml";

  public static synchronized RuleBasedMultilabelClassifier getInstance()
      throws Exception {

    if (classifier == null)
      classifier = new RuleBasedMultilabelClassifier();
    return classifier;

  }

  public static synchronized void releaseRuleSession()
      throws InvalidRuleSessionException, RemoteException {
    if (srs != null)
      srs.release();
  }

  private RuleBasedMultilabelClassifier() throws ClassNotFoundException,
      ConfigurationException, RuleExecutionSetCreateException, RemoteException,
      RuleExecutionSetRegisterException, RuleSessionTypeUnsupportedException,
      RuleSessionCreateException, RuleExecutionSetNotFoundException {

    // Initialization implementation goes here;

    // JCR94 compliant rule engine is able to being deployed in distributed way;

    String ruleEngineServiceUri = UriConstants.RULE_ENGINE_SERVICE_URI;

    Class.forName(UriConstants.RULE_SERVICE_PROVIDER_CLASS_NAME);

    RuleServiceProvider serviceProvider = RuleServiceProviderManager
        .getRuleServiceProvider(ruleEngineServiceUri);

    RuleAdministrator ruleAdministrator = serviceProvider
        .getRuleAdministrator();

    RuleEngineLog.debug(ruleAdministrator.toString());

    Map<?, ?> params = null;

    RuleSet ruleSet = initRuleSet();

    String bindUri = null;

    RuleExecutionSet ruleExecutionSet = ruleAdministrator
        .getLocalRuleExecutionSetProvider(params).createRuleExecutionSet(
            ruleSet, null);

    bindUri = ruleExecutionSet.getName();

    ruleAdministrator.registerRuleExecutionSet(bindUri, ruleExecutionSet, null);

    RuleEngineLog.debug(ruleExecutionSet);
    //
    RuleRuntime ruleRunTime = serviceProvider.getRuleRuntime();

    srs = (StatelessRuleSession) ruleRunTime.createRuleSession(bindUri, params,
        RuleRuntime.STATELESS_SESSION_TYPE);
  }

  /**
   * @param obj
   * @return
   * @throws InvalidRuleSessionException
   * @throws RemoteException
   *           TODO , inconsistent interface, further refactor needed ;
   */
  @Override
  public List<String> classifer(ProductReview obj)
      throws InvalidRuleSessionException, RemoteException {

    @SuppressWarnings("unchecked")
    List<ProductReviewWithLabels> prs = srs.executeRules(Arrays.asList(obj));

    return prs.get(0).getLabels();

  }

  private RuleSet initRuleSet() {

    ApplicationContext ctx = new ClassPathXmlApplicationContext(
        RULES_CONFIG_XML);

    RuleSet ruleSet = (RuleSet) ctx.getBean("testRuleSet01");

    return ruleSet;

  }

}
