package com.kirkkt.javatests.tax.forms.input;

import static org.junit.Assert.assertEquals;

import com.kirkkt.javatests.tax.FormTest;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.input.W2TaxYear2014;

public class W2TaxYear2014Test extends FormTest {

  @Override
  public Form getForm() {
    return new W2TaxYear2014();
  }

  @Override
  public String getInputFilePath() {
    return "/forms/input/w2taxyear2014.txt";
  }

  @Override
  public String getGoldFilePath() {
    return "/forms/input/w2taxyear2014gold.txt";
  }

  @Override
  public void test() {
    assertEquals("W2", getForm().getFormType());
    assertEquals(2014, getForm().getTaxYear());
    super.test();
  }
}
