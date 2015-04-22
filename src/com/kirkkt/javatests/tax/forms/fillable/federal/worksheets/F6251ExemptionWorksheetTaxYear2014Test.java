package com.kirkkt.javatests.tax.forms.fillable.federal.worksheets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.kirkkt.javatests.tax.TestCase;
import com.kirkkt.javatests.tax.TestUtil;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.fillable.federal.worksheets.F6251ExemptionWorksheetTaxYear2014;

import com.google.common.collect.UnmodifiableIterator;

public class F6251ExemptionWorksheetTaxYear2014Test implements TestCase {

  @Override
  public Form getForm() {
    return new F6251ExemptionWorksheetTaxYear2014();
  }

  @Override
  public void test() {
    F6251ExemptionWorksheetTaxYear2014 form = new F6251ExemptionWorksheetTaxYear2014();
    assertEquals("F6251 Exemption Worksheet", form.getFormType());
    assertEquals(2014, form.getTaxYear());

    UnmodifiableIterator<String> input = TestUtil.getGold(TestUtil.TEST_DATA_FOLDER
        + "/forms/fillable/federal/worksheets/f6251exemptionworksheettaxyear2014input.txt");
    form.readFromMotherForm(
      Integer.parseInt(input.next()) //formB28
    );
    assertFalse(input.hasNext());

    UnmodifiableIterator<String> gold = TestUtil.getGold(TestUtil.TEST_DATA_FOLDER
        + "/forms/fillable/federal/worksheets/f6251exemptionworksheettaxyear2014gold.txt");
    assertEquals(gold.next(), String.valueOf(form.getB1()));
    assertEquals(gold.next(), String.valueOf(form.getB2()));
    assertEquals(gold.next(), String.valueOf(form.getB3()));
    assertEquals(gold.next(), String.valueOf(form.getB4()));
    assertEquals(gold.next(), String.valueOf(form.getB5()));
    assertEquals(gold.next(), String.valueOf(form.getB6()));
    assertEquals(gold.next(), String.valueOf(form.getB7()));
    assertEquals(gold.next(), String.valueOf(form.getB8()));
    assertEquals(gold.next(), String.valueOf(form.getB9()));
    assertEquals(gold.next(), String.valueOf(form.getB10()));
    assertEquals(gold.next(), String.valueOf(form.getBResult()));
    assertFalse(gold.hasNext());
  }
}
