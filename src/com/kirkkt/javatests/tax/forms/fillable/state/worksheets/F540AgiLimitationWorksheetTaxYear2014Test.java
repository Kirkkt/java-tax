package com.kirkkt.javatests.tax.forms.fillable.state.worksheets;

import static org.junit.Assert.assertEquals;

import com.kirkkt.javatests.tax.FormTest;
import com.kirkkt.javatests.tax.TestUtil;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.fillable.state.worksheets.F540AgiLimitationWorksheetTaxYear2014;

import com.google.common.collect.UnmodifiableIterator;

public class F540AgiLimitationWorksheetTaxYear2014Test extends FormTest {

  @Override
  public Form getForm() {
    return new F540AgiLimitationWorksheetTaxYear2014();
  }

  @Override
  public String getInputFilePath() {
    return "/forms/fillable/state/worksheets/f540agilimitationworksheettaxyear2014input.txt";
  }

  @Override
  public String getGoldFilePath() {
    return "/forms/fillable/state/worksheets/f540agilimitationworksheettaxyear2014gold.txt";
  }

  @Override
  public void test() {
    assertEquals("F540 Agi Limitation Worksheet",
        getForm().getFormType());
    assertEquals(2014, getForm().getTaxYear());
    super.test();
  }
}
