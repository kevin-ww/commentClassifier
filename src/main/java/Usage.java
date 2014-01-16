import java.rmi.RemoteException;
import java.util.List;

import javax.rules.ConfigurationException;
import javax.rules.InvalidRuleSessionException;
import javax.rules.RuleExecutionSetNotFoundException;
import javax.rules.RuleSessionCreateException;
import javax.rules.RuleSessionTypeUnsupportedException;
import javax.rules.admin.RuleExecutionSetCreateException;
import javax.rules.admin.RuleExecutionSetRegisterException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zxinsight.classifier.common.ProductReview;
import com.zxinsight.classifier.core.EmbededRuleBasedMultilabelClassifier;
import com.zxinsight.classifier.ruleengine.RuleSet;

public class Usage {

  public static void main(String[] args)
      throws RuleExecutionSetCreateException,
      RuleExecutionSetRegisterException, RuleSessionTypeUnsupportedException,
      RuleSessionCreateException, RuleExecutionSetNotFoundException,
      ConfigurationException, RemoteException, ClassNotFoundException,
      InvalidRuleSessionException {

    final String RULES_CONFIG_XML = "com/zxinsight/classifier/ruleengine/rule/ruleset_01.xml";

    ApplicationContext ctx = new ClassPathXmlApplicationContext(
        RULES_CONFIG_XML);

    RuleSet ruleSet = (RuleSet) ctx.getBean("testRuleSet01");
    
    //

    String reviewText = "一直在你们家购买，感觉奶粉是保真的。就是发货速度稍微再快一些就好了。先谢谢了";

    ProductReview productReview = new ProductReview("nulluid", reviewText);

    //

    EmbededRuleBasedMultilabelClassifier classifier = new EmbededRuleBasedMultilabelClassifier(
        ruleSet);

    List<String> labels = classifier.classifer(productReview);

    System.out.println(labels);
    
    classifier.releaseRuleSession();

  }
}
