package com.kirkkt.javatests.tax.forms.fillable.federal;

import static org.junit.Assert.assertEquals;

import com.kirkkt.javatests.tax.FormTest;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.fillable.federal.F6251TaxYear2014;

public class F6251TaxYear2014Test extends FormTest {

  @Override
  public Form getForm() {
    return new F6251TaxYear2014();
  }

  @Override
  public String getInputFilePath() {
    return "/forms/fillable/federal/f6251taxyear2014input.txt";
  }

  @Override
  public String getGoldFilePath() {
    return "/forms/fillable/federal/f6251taxyear2014gold.txt";
  }

  @Override
  public void test() {
    assertEquals("F6251", getForm().getFormType());
    assertEquals(2014, getForm().getTaxYear());
    super.test();
  }
}
