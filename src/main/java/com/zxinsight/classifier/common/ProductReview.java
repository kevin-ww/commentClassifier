package com.zxinsight.classifier.common;

import java.util.Date;

public class ProductReview {

  public enum ECommercePLATFORM {
    TMALL, AMAZON_CN
  }

  /**
   * HEADER : cid,shop,品牌,标题,内容,评分,评级,标签,标签个数,日期
   * 
   * SAMPLE LINE: 51888ba681856da1e622b728,TMALL,可瑞康,,儿子一直在这里买这个奶粉
   * ，喝着不上火挺好的，就是平时活动太少了，运费也上涨了,5,好评,品牌口碑/产品口味/价格,3,2013-05-01 00:03:01,
   * 
   */

  public final String PRODUCT_REVIEW_HEADER = "cid,shop,品牌,标题,内容,评分,评级,标签,标签个数,日期";

  private String uid;

  private ECommercePLATFORM platform;

  private String reviewText;

  private Date createDate;

  public ProductReview(String uid, ECommercePLATFORM platform,
      String reviewText, Date createDate) {
    this.setUid(uid);
    this.setPlatform(platform);
    this.setReviewText(reviewText);
    this.setCreateDate(createDate);
  }

  public ProductReview(String uid, String reviewText) {
    this(uid, null, reviewText, null);
  }

  public Date getCreateDate() {
    return createDate;
  }

  public ECommercePLATFORM getPlatform() {
    return platform;
  }

  public String getReviewText() {
    return reviewText;
  }

  public String getUid() {
    return uid;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public void setPlatform(ECommercePLATFORM platform) {
    this.platform = platform;
  }

  public void setReviewText(String reviewText) {
    this.reviewText = reviewText;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  @Override
  public String toString() {
    return "ProductReview [uid=" + uid + ", platform=" + platform
        + ", reviewText=" + reviewText + ", createDate=" + createDate + "]";
  }

}
