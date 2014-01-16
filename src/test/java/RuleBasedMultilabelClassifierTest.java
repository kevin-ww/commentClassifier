import java.util.List;

import com.zxinsight.classifier.common.ProductReview;
import com.zxinsight.classifier.core.RuleBasedMultilabelClassifier;

public class RuleBasedMultilabelClassifierTest {

  public static void main(String[] args) throws Exception {

    String reviewText = "一直在你们家购买，感觉奶粉是保真的。就是发货速度稍微再快一些就好了。先谢谢了";

    ProductReview productReview = new ProductReview("nulluid", reviewText);

    List<String> labels = RuleBasedMultilabelClassifier.getInstance()
        .classifer(productReview);

    System.out.println(labels);

  }

}
