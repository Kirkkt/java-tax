package com.kirkkt.javatests.tax.forms.fillable.federal.worksheets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.kirkkt.javatests.tax.FormTest;
import com.kirkkt.javatests.tax.TestUtil;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.fillable.federal.worksheets.F1040QualifiedDividendAndCapitalGainTaxWorksheetTaxYear2014;

import com.google.common.collect.UnmodifiableIterator;

public class F1040QualifiedDividendAndCapitalGainTaxWorksheetTaxYear2014Test extends FormTest {

  @Override
  public Form getForm() {
    return new F1040QualifiedDividendAndCapitalGainTaxWorksheetTaxYear2014();
  }

  @Override
  public String getInputFilePath() {
    return
        "/forms/fillable/federal/worksheets/f1040qualifieddividendandcapitalgaintaxworksheettaxyear2014input.txt";
  }

  @Override
  public String getGoldFilePath() {
    return
        "/forms/fillable/federal/worksheets/f1040qualifieddividendandcapitalgaintaxworksheettaxyear2014gold.txt";
  }

  @Override
  public void test() {
    assertEquals("F1040 Qualified Dividend And Capital Gain Tax Worksheet",
        getForm().getFormType());
    assertEquals(2014, getForm().getTaxYear());
    super.test();
  }
}
