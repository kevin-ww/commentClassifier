package com.zxinsight.classifier.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.zxinsight.classifier.common.ProductReview;

/**
 * HEADER : cid,shop,品牌,标题,内容,评分,评级,标签,标签个数,日期
 * 
 * SAMPLE LINE: 51888ba681856da1e622b728,TMALL,可瑞康,,儿子一直在这里买这个奶粉
 * ，喝着不上火挺好的，就是平时活动太少了，运费也上涨了,5,好评,品牌口碑/产品口味/价格,3,2013-05-01 00:03:01,
 * 
 */
public class ProductReviewFieldSetMapper implements
    FieldSetMapper<ProductReview> {

  @Override
  public ProductReview mapFieldSet(FieldSet fieldSet) throws BindException {

    if (fieldSet == null) {
      return null;
    }

    String uid = fieldSet.readString(0);

    String reviewText = fieldSet.readString(4);

    ProductReview review = new ProductReview(uid, reviewText);

    return review;

  }

}
