package com.kirkkt.javatests.tax.forms.fillable.federal.worksheets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.kirkkt.javatests.tax.FormTest;
import com.kirkkt.javatests.tax.TestUtil;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.fillable.federal.worksheets.F1040TaxComputationWorksheetTaxYear2014;

import com.google.common.collect.UnmodifiableIterator;

public class F1040TaxComputationWorksheetTaxYear2014Test2 extends FormTest {

  @Override
  public Form getForm() {
    return new F1040TaxComputationWorksheetTaxYear2014();
  }

  @Override
  public String getInputFilePath() {
    return
        "/forms/fillable/federal/worksheets/f1040taxcomputationworksheettaxyear2014input2.txt";
  }

  @Override
  public String getGoldFilePath() {
    return
        "/forms/fillable/federal/worksheets/f1040taxcomputationworksheettaxyear2014gold2.txt";
  }

  @Override
  public void test() {
   assertEquals("F1040 Tax Computation Worksheet", getForm().getFormType());
   assertEquals(2014, getForm().getTaxYear());
   super.test();
  }
}
