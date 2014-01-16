package com.zxinsight.classifier;

import java.util.List;

/**
 * Multi-label classification
 * http://en.wikipedia.org/wiki/Multi-label_classification
 * 
 * In machine learning, multi-label classification and the strongly related
 * problem of multi-output classification are variants of the classification
 * problem where multiple target labels must be assigned to each instance.
 * Multi-label classification should not be confused with multiclass
 * classification, which is the problem of categorizing instances into more than
 * two classes. Formally, multi-label learning can be phrased as the problem of
 * finding a model that maps inputs x to vectors y, rather than scalar outputs
 * as in the ordinary classification problem. There are two main methods for
 * tackling the multi-label classification problem:[1] problem transformation
 * methods and algorithm adaptation methods. Problem transformation methods
 * transform the multi-label problem into a set of binary classification
 * problems, which can then be handled using single-class classifiers. Algorithm
 * adaptation methods adapt the algorithms to directly perform multi-label
 * classification. In other words, rather than trying to convert the problem to
 * a simpler problem, they try to address the problem in its full form.
 */
public interface Classifier<T> {

  List<String> classifer(T obj) throws Exception;

}
