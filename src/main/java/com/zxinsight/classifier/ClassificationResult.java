package com.zxinsight.classifier;

import java.util.Map;

public class ClassificationResult<T> implements Comparable<T> {

  Map<T, Double> belongToClassifications;

  @Override
  public int compareTo(T o) {
    // TODO Auto-generated method stub
    return 0;
  }

}
