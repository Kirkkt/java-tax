package com.kirkkt.javatests.tax.forms.input;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.kirkkt.javatests.tax.TestCase;
import com.kirkkt.javatests.tax.TestUtil;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.input.F1099DivTaxYear2014;

import com.google.common.collect.UnmodifiableIterator;

public class F1099DivTaxYear2014Test implements TestCase {

  @Override
  public Form getForm() {
    return new F1099DivTaxYear2014();
  }

  @Override
  public void test() {
    F1099DivTaxYear2014 form = new F1099DivTaxYear2014();
    form.readFromFile(TaxUtil.DATA_FOLDER + "/forms/input/f1099divtaxyear2014.txt");
    assertEquals("F1099DIV", form.getFormType());
    assertEquals(2014, form.getTaxYear());
    UnmodifiableIterator<String> gold =
        TestUtil.getGold(TestUtil.TEST_DATA_FOLDER + "/forms/input/f1099divtaxyear2014gold.txt");

    assertEquals(gold.next(), String.valueOf(form.getBPayerName().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB1a().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB1b().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB2a().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB2b().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB3().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB4().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB6().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB10().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB11().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB12().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB13().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB14().getValue()));
    assertFalse(gold.hasNext());
  }
}
