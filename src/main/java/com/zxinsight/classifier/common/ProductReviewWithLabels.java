package com.zxinsight.classifier.common;

import java.util.ArrayList;
import java.util.List;

public class ProductReviewWithLabels {

  private ProductReview originalProductReview;

  private List<String> labels;

  public ProductReviewWithLabels(ProductReview originalProductReview) {
    this(originalProductReview, null);
  }

  public ProductReviewWithLabels(ProductReview originalProductReview,
      List<String> labels) {
    this.setOriginalProductReview(originalProductReview);
    this.setLabels(labels);
  }

  public List<String> getLabels() {
    return labels;
  }

  public ProductReview getOriginalProductReview() {
    return originalProductReview;
  }

  public void setLabel(String label) {

    if (this.labels == null) {
      this.labels = new ArrayList<String>();
    }
    this.labels.add(label);
  }

  public void setLabels(List<String> labels) {
    this.labels = labels;
  }

  public void setOriginalProductReview(ProductReview originalProductReview) {
    this.originalProductReview = originalProductReview;
  }

  @Override
  public String toString() {
    // return "ProductReviewWithLabels [originalProductReview="
    // + originalProductReview + ", labels=" + labels + "]";

    StringBuilder s = new StringBuilder();

    s.append(this.originalProductReview.getUid()).append("|");
    s.append(this.originalProductReview.getReviewText()).append("|");
    s.append(this.getLabels());

    return s.toString();
  }

}
