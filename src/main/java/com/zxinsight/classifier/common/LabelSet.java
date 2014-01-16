package com.zxinsight.classifier.common;

import java.util.List;

public class LabelSet {

  private List<String> lableSet;

  public LabelSet(List<String> lableSet) {
    super();
    this.lableSet = lableSet;
  }

  public List<String> getLableSet() {
    return lableSet;
  }

  public void setLableSet(List<String> lableSet) {
    this.lableSet = lableSet;
  }

  @Override
  public String toString() {
    return "LabelSet [lableSet=" + lableSet + "]";
  }

}
