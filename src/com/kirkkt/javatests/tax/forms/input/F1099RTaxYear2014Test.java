package com.kirkkt.javatests.tax.forms.input;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.kirkkt.javatests.tax.TestCase;
import com.kirkkt.javatests.tax.TestUtil;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.input.F1099RTaxYear2014;

import com.google.common.collect.UnmodifiableIterator;

public class F1099RTaxYear2014Test implements TestCase {

  @Override
  public Form getForm() {
    return new F1099RTaxYear2014();
  }

  @Override
  public void test() {
    F1099RTaxYear2014 form = new F1099RTaxYear2014();
    form.readFromFile(TaxUtil.DATA_FOLDER + "/forms/input/f1099rtaxyear2014.txt");
    assertEquals("F1099R", form.getFormType());
    assertEquals(2014, form.getTaxYear());
    UnmodifiableIterator<String> gold =
        TestUtil.getGold(TestUtil.TEST_DATA_FOLDER + "/forms/input/f1099rtaxyear2014gold.txt");

    assertEquals(gold.next(),
        String.valueOf(form.getBPayerFederalIdentificationNumber().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getBPayerName().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getBAccountNumber().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB1().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB2a().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB2b().getValue().get(0).getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB2b().getValue().get(1).getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB3().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB4().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB5().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB6().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB7().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB7Checkbox().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB8().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB9a().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB9b().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB10().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB11().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB12().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB13().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB14().getValue()));
    assertFalse(gold.hasNext());
  }
}
