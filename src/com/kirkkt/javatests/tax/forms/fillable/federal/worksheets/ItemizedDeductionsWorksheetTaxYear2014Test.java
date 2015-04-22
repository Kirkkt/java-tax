package com.kirkkt.javatests.tax.forms.fillable.federal.worksheets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.kirkkt.javatests.tax.TestCase;
import com.kirkkt.javatests.tax.TestUtil;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.fillable.federal.worksheets.ItemizedDeductionsWorksheetTaxYear2014;

import com.google.common.collect.UnmodifiableIterator;

public class ItemizedDeductionsWorksheetTaxYear2014Test implements TestCase {

  @Override
  public Form getForm() {
    return new ItemizedDeductionsWorksheetTaxYear2014();
  }

  @Override
  public void test() {
    ItemizedDeductionsWorksheetTaxYear2014 form = new ItemizedDeductionsWorksheetTaxYear2014();
    assertEquals("Itemized Deductions Worksheet", form.getFormType());
    assertEquals(2014, form.getTaxYear());

    UnmodifiableIterator<String> input =
        TestUtil.getGold(TestUtil.TEST_DATA_FOLDER
            + "/forms/fillable/federal/worksheets/itemizeddeductionsworksheettaxyear2014input.txt");
    form.readFromMotherForm(
      Integer.parseInt(input.next()), //formB2
      Integer.parseInt(input.next()), //formB4
      Integer.parseInt(input.next()), //formB9
      Integer.parseInt(input.next()), //formB14
      Integer.parseInt(input.next()), //formB15
      Integer.parseInt(input.next()), //formB19
      Integer.parseInt(input.next()), //formB20
      Integer.parseInt(input.next()), //formB27
      Integer.parseInt(input.next()) //formB28
    );
    assertFalse(input.hasNext());

    UnmodifiableIterator<String> gold =
        TestUtil.getGold(TestUtil.TEST_DATA_FOLDER
            + "/forms/fillable/federal/worksheets/itemizeddeductionsworksheettaxyear2014gold.txt");
    assertEquals(gold.next(), String.valueOf(form.getB1()));
    assertEquals(gold.next(), String.valueOf(form.getB2()));
    assertEquals(gold.next(), String.valueOf(form.getB3()));
    assertEquals(gold.next(), String.valueOf(form.getB3Checkbox()));
    assertEquals(gold.next(), String.valueOf(form.getB4()));
    assertEquals(gold.next(), String.valueOf(form.getB5()));
    assertEquals(gold.next(), String.valueOf(form.getB6()));
    assertEquals(gold.next(), String.valueOf(form.getB7()));
    assertEquals(gold.next(), String.valueOf(form.getB7Checkbox()));
    assertEquals(gold.next(), String.valueOf(form.getB8()));
    assertEquals(gold.next(), String.valueOf(form.getB9()));
    assertEquals(gold.next(), String.valueOf(form.getB10()));
    assertEquals(gold.next(), String.valueOf(form.getBResult()));
    assertFalse(gold.hasNext());
  }
}
