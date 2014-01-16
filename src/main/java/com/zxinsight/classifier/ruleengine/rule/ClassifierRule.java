package com.zxinsight.classifier.ruleengine.rule;

import javax.rules.admin.Rule;

public abstract class ClassifierRule<T> implements Rule {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  public ClassifierRule(String name) {
    this(name, null);
  }

  private ClassifierRule(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public abstract boolean eval(T input);

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Object getProperty(Object paramObject) {
    // TODO Auto-generated method stub
    return null;
  }

  //

  @Override
  public void setProperty(Object paramObject1, Object paramObject2) {
    // TODO Auto-generated method stub

  }

  @Override
  public String toString() {
    return "ClassifierRule [name=" + name + ", description=" + description
        + "]";
  }

}
