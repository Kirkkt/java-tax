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

    assertEquals(gold.next(), String.valueOf(form.getBPayerFederalIdentificationNumber()));
    assertEquals(gold.next(), String.valueOf(form.getBPayerName()));
    assertEquals(gold.next(), String.valueOf(form.getBAccountNumber()));
    assertEquals(gold.next(), String.valueOf(form.getB1()));
    assertEquals(gold.next(), String.valueOf(form.getB2a()));
    assertEquals(gold.next(), String.valueOf(form.getB2b()[0]));
    assertEquals(gold.next(), String.valueOf(form.getB2b()[1]));
    assertEquals(gold.next(), String.valueOf(form.getB3()));
    assertEquals(gold.next(), String.valueOf(form.getB4()));
    assertEquals(gold.next(), String.valueOf(form.getB5()));
    assertEquals(gold.next(), String.valueOf(form.getB6()));
    assertEquals(gold.next(), String.valueOf(form.getB7()));
    assertEquals(gold.next(), String.valueOf(form.getB7Checkbox()));
    assertEquals(gold.next(), String.valueOf(form.getB8()));
    assertEquals(gold.next(), String.valueOf(form.getB9a()));
    assertEquals(gold.next(), String.valueOf(form.getB9b()));
    assertEquals(gold.next(), String.valueOf(form.getB10()));
    assertEquals(gold.next(), String.valueOf(form.getB11()));
    assertEquals(gold.next(), String.valueOf(form.getB12()));
    assertEquals(gold.next(), String.valueOf(form.getB13()));
    assertEquals(gold.next(), String.valueOf(form.getB14()));
    assertFalse(gold.hasNext());
  }
}
