package com.kirkkt.javatests.tax.forms.input;

import static org.junit.Assert.assertEquals;

import com.kirkkt.javatests.tax.FormTest;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.input.F1099RTaxYear2014;

import com.google.common.collect.UnmodifiableIterator;

public class F1099RTaxYear2014Test extends FormTest {

  @Override
  public Form getForm() {
    return new F1099RTaxYear2014();
  }

  @Override
  public String getInputFilePath() {
    return "/forms/input/f1099rtaxyear2014.txt";
  }

  @Override
  public String getGoldFilePath() {
    return "/forms/input/f1099rtaxyear2014gold.txt";
  }

  @Override
  public void test() {
    assertEquals("F1099R", getForm().getFormType());
    assertEquals(2014, getForm().getTaxYear());
    super.test();
  }
}
