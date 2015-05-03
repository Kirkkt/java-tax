package com.kirkkt.javatests.tax.forms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.kirkkt.javatests.tax.TestCase;
import com.kirkkt.javatests.tax.TestUtil;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.Form;

import com.google.common.collect.UnmodifiableIterator;

public class TaxUtilTest implements TestCase {

  public class FakeForm extends Form {
    @Override
    public String getFormType() {
      return "Tax Util";
    }

    @Override
    public int getTaxYear() {
      return 0; // useless
    }
  }

  @Override
  public Form getForm() {
    return new FakeForm();
  }

  @Override
  public void test() {
    TaxUtil util = new TaxUtil();
    UnmodifiableIterator<String> gold =
        TestUtil.getGold(TestUtil.TEST_DATA_FOLDER + "/taxutilgold.txt");
    assertEquals(gold.next(), String.valueOf(util.getCheckingAccountAccountType()));
    assertEquals(gold.next(), String.valueOf(util.getCheckingAccountRoutingNumber()));
    assertEquals(gold.next(), String.valueOf(util.getCheckingAccountAccountNumber()));
    assertFalse(gold.hasNext());
  }
}
