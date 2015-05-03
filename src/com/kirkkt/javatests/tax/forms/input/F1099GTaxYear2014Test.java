package com.kirkkt.javatests.tax.forms.input;

import static org.junit.Assert.assertEquals;

import com.kirkkt.javatests.tax.FormTest;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.input.F1099GTaxYear2014;

public class F1099GTaxYear2014Test extends FormTest {

  @Override
  public Form getForm() {
    return new F1099GTaxYear2014();
  }

  @Override
  public String getInputFilePath() {
    return "/forms/input/f1099gtaxyear2014.txt";
  }

  @Override
  public String getGoldFilePath() {
    return "/forms/input/f1099gtaxyear2014gold.txt";
  }

  @Override
  public void test() {
    assertEquals("F1099G", getForm().getFormType());
    assertEquals(2014, getForm().getTaxYear());
    super.test();
  }
}
