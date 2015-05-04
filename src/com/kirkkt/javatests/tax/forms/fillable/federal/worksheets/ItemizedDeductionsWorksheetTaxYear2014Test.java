package com.kirkkt.javatests.tax.forms.fillable.federal.worksheets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.kirkkt.javatests.tax.FormTest;
import com.kirkkt.javatests.tax.TestUtil;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.fillable.federal.worksheets.ItemizedDeductionsWorksheetTaxYear2014;

import com.google.common.collect.UnmodifiableIterator;

public class ItemizedDeductionsWorksheetTaxYear2014Test extends FormTest {

  @Override
  public Form getForm() {
    return new ItemizedDeductionsWorksheetTaxYear2014();
  }

  @Override
  public String getInputFilePath() {
    return "/forms/fillable/federal/worksheets/itemizeddeductionsworksheettaxyear2014input.txt";
  }

  @Override
  public String getGoldFilePath() {
    return "/forms/fillable/federal/worksheets/itemizeddeductionsworksheettaxyear2014gold.txt";
  }

  @Override
  public void test() {
    assertEquals("Itemized Deductions Worksheet", getForm().getFormType());
    assertEquals(2014, getForm().getTaxYear());
    super.test();
  }
}
