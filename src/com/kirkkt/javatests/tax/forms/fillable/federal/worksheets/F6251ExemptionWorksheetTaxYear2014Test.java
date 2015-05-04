package com.kirkkt.javatests.tax.forms.fillable.federal.worksheets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.kirkkt.javatests.tax.FormTest;
import com.kirkkt.javatests.tax.TestUtil;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.fillable.federal.worksheets.F6251ExemptionWorksheetTaxYear2014;

import com.google.common.collect.UnmodifiableIterator;

public class F6251ExemptionWorksheetTaxYear2014Test extends FormTest {

  @Override
  public Form getForm() {
    return new F6251ExemptionWorksheetTaxYear2014();
  }

  @Override
  public String getInputFilePath() {
    return "/forms/fillable/federal/worksheets/f6251exemptionworksheettaxyear2014input.txt";
  }

  @Override
  public String getGoldFilePath() {
    return "/forms/fillable/federal/worksheets/f6251exemptionworksheettaxyear2014gold.txt";
  }

  @Override
  public void test() {
    assertEquals("F6251 Exemption Worksheet",
        getForm().getFormType());
    assertEquals(2014, getForm().getTaxYear());
    super.test();
  }
}
