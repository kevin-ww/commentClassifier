package com.zxinsight.classifier.ruleengine;

import java.util.ArrayList;
import java.util.List;

import javax.rules.admin.RuleExecutionSet;

import com.zxinsight.classifier.common.ProductReview;
import com.zxinsight.classifier.common.ProductReviewWithLabels;
import com.zxinsight.classifier.ruleengine.rule.RegexRule;

/**
 * The Working Memory is the main Class for using the Rule Engine at runtime. It
 * holds references to all data that has been "asserted" into it (until
 * retracted) and it is the place where the interaction with your application
 * occurs. Working memories are stateful objects. They may be shortlived or
 * longlived. If you are interacting with an engine in a stateless manner, that
 * means you would use the RuleBase object to create a newWorkingMemory for each
 * session, and then discard the working memory when finished (creating a
 * working memory is a cheap operation). An alternative pattern is a working
 * memory that is kept around for a longer time (such as a conversation) - and
 * kept updated with new facts. When you wish to dispose of WorkingMemory the
 * best pactice is to use the dispose() method, so that the reference to it is
 * removed in the parent Rule Base. However, this is a weak reference, so it
 * should eventually be garbage collected anyway. The term Working Memory Action
 * is used to describe assertions, retractions and modifications with the
 * Working Memory
 * 
 * http://docs.jboss.org/drools/release/5.3.0.Final/drools-expert-docs/html/ch01
 * .html
 * 
 */
@SuppressWarnings("rawtypes")
public class SimpleWorkingMemory {

  RuleExecutionSet ruleExecutionSet;
  List<ProductReview> objects;

  SimpleWorkingMemory(RuleExecutionSet ruleExecutionSet,
      List<ProductReview> objects) {
    this.ruleExecutionSet = ruleExecutionSet;
    this.objects = objects;
  }

  /**
   * now using the simplest implementation at this point;further change needed ;
   * 
   * ,support RegexRule now only;
   */

  public List<ProductReviewWithLabels> applyRules() {

    // RETE?

    @SuppressWarnings("unchecked")
    List<RegexRule> rules = this.ruleExecutionSet.getRules();

    List<ProductReviewWithLabels> result = new ArrayList<ProductReviewWithLabels>();

    for (ProductReview productReview : objects) {
      ProductReviewWithLabels pWithLables = this.applyRules(productReview,
          rules);
      result.add(pWithLables);
    }
    return result;

  }

  /**
   * @param productReview
   * @param rules
   * @return
   */
  protected ProductReviewWithLabels applyRules(ProductReview productReview,
      List<RegexRule> rules) {

    ProductReviewWithLabels prWithLables = new ProductReviewWithLabels(
        productReview);

    for (RegexRule rule : rules) {

      @SuppressWarnings("unchecked")
      boolean isMatch = rule.eval(productReview);
      if (isMatch) {
        prWithLables.setLabel(rule.getLable());

      }
    }
    return prWithLables;
  }

}
