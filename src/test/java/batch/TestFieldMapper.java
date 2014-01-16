package batch;

import java.math.BigDecimal;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class TestFieldMapper implements FieldSetMapper<CustomerCredit> {

  @Override
  public CustomerCredit mapFieldSet(FieldSet fieldSet) throws BindException {
    // TODO Auto-generated method stub
    // return null;
    BigDecimal credit = new BigDecimal(999.00);
    System.out.println(Thread.currentThread().getName()
        + " now working on fieldset");
    return new CustomerCredit(1, "name0", credit);
  }

}
