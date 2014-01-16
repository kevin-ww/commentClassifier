package com.zxinsight.classifier.ruleengine.rule;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zxinsight.classifier.common.ProductReview;

public class RegexRule extends ClassifierRule<ProductReview> {
  
  public RegexRule(){
    this("name_");
  }

  public RegexRule(String name) {
    super(name);
  }

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private List<String> expressions;

  protected Pattern regexPattern;

  private String lable;

//  public RegexRule(String name) {
//    super(name);
//  }
//
//  public RegexRule(String name, List<String> expressions) {
//    super(name);
//    setExpressions(expressions);
//
//  }

  /**
   * assume all the expressions in the list can be combined in one "OR" ;
   * 
   * limit of 65535 on the length of a String literal,TODO
   */
  protected void compileRegexExpressions() {

    StringBuffer combinedExpression = new StringBuffer();
    for (String expression : expressions) {
      combinedExpression.append(expression);
    }
    this.regexPattern = Pattern.compile(combinedExpression.toString());
  }

  public List<String> getExpressions() {
    return expressions;
  }

  // public abstract String getLabel();

  public boolean isMatch(String text) {
    Matcher matcher = this.regexPattern.matcher(text);
    return matcher.find();
  }

  public void setExpressions(List<String> expressions) {
    this.expressions = expressions;
    compileRegexExpressions();
  }

  @Override
  public String toString() {
    final int maxLen = 10;
    return "RegexRule [ name="
        + getName()
        + ", description="
        + getDescription()
        + ",expressions="
        + (expressions != null ? expressions.subList(0,
            Math.min(expressions.size(), maxLen)) : null) + " ]";
  }

  public String getLable() {
    return lable;
  }

  public void setLable(String lable) {
    this.lable = lable;
  }

  @Override
  public boolean eval(ProductReview input) {
    return isMatch(input.getReviewText());
  }
}
