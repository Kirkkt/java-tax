package com.kirkkt.javatests.tax.forms.fillable.state;

import static org.junit.Assert.assertEquals;

import com.kirkkt.javatests.tax.FormTest;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.fillable.state.F540TaxYear2014;

public class F540TaxYear2014Test extends FormTest {

  @Override
  public Form getForm() {
    return new F540TaxYear2014();
  }

  @Override
  public String getInputFilePath() {
    return "/forms/fillable/state/f540taxyear2014input.txt";
  }

  @Override
  public String getGoldFilePath() {
    return "/forms/fillable/state/f540taxyear2014gold.txt";
  }

  @Override
  public void test() {
    assertEquals("F540", getForm().getFormType());
    assertEquals(2014, getForm().getTaxYear());
    super.test();
  }
}

