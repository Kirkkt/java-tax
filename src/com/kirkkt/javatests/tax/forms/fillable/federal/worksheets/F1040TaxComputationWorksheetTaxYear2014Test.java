package com.kirkkt.javatests.tax.forms.fillable.federal.worksheets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.kirkkt.javatests.tax.TestCase;
import com.kirkkt.javatests.tax.TestUtil;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.fillable.federal.worksheets.F1040TaxComputationWorksheetTaxYear2014;

import com.google.common.collect.UnmodifiableIterator;

public class F1040TaxComputationWorksheetTaxYear2014Test implements TestCase {

  @Override
  public Form getForm() {
    return new F1040TaxComputationWorksheetTaxYear2014();
  }

  @Override
  public void test() {
    F1040TaxComputationWorksheetTaxYear2014 form = new F1040TaxComputationWorksheetTaxYear2014();
    assertEquals("F1040 Tax Computation Worksheet", form.getFormType());
    assertEquals(2014, form.getTaxYear());

    UnmodifiableIterator<String> input = TestUtil.getGold(TestUtil.TEST_DATA_FOLDER
        + "/forms/fillable/federal/worksheets/f1040taxcomputationworksheettaxyear2014input.txt");
    form.readFromMotherForm(
      Integer.parseInt(input.next()) //formB43
    );
    assertFalse(input.hasNext());

    UnmodifiableIterator<String> gold = TestUtil.getGold(TestUtil.TEST_DATA_FOLDER
        + "/forms/fillable/federal/worksheets/f1040taxcomputationworksheettaxyear2014gold.txt");
    assertEquals(gold.next(), String.valueOf(form.getBResult()));
    assertFalse(gold.hasNext());

    // round 2
    input = TestUtil.getGold(TestUtil.TEST_DATA_FOLDER
        + "/forms/fillable/federal/worksheets/f1040taxcomputationworksheettaxyear2014input2.txt");
    form.readFromMotherForm(
      Integer.parseInt(input.next()) //formB43
    );
    assertFalse(input.hasNext());

    gold = TestUtil.getGold(TestUtil.TEST_DATA_FOLDER
        + "/forms/fillable/federal/worksheets/f1040taxcomputationworksheettaxyear2014gold2.txt");
    assertEquals(gold.next(), String.valueOf(form.getBResult()));
    assertFalse(gold.hasNext());
  }
}
