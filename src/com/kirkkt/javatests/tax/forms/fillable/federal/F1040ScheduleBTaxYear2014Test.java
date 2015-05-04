package com.kirkkt.javatests.tax.forms.fillable.federal;

import static org.junit.Assert.assertEquals;

import com.kirkkt.javatests.tax.FormTest;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.fillable.federal.F1040ScheduleBTaxYear2014;

public class F1040ScheduleBTaxYear2014Test extends FormTest {

  @Override
  public Form getForm() {
    return new F1040ScheduleBTaxYear2014();
  }

  @Override
  public String getInputFilePath() {
    return "/forms/fillable/federal/f1040schedulebtaxyear2014input.txt";
  }

  @Override
  public String getGoldFilePath() {
    return "/forms/fillable/federal/f1040schedulebtaxyear2014gold.txt";
  }

  @Override
  public void test() {
    assertEquals("F1040 Schedule B", getForm().getFormType());
    assertEquals(2014, getForm().getTaxYear());
    super.test();
  }
}

