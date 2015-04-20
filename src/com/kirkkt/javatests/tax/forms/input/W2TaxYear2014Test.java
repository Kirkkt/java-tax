package com.kirkkt.javatests.tax.forms.input;

import static org.junit.Assert.assertEquals;

import com.kirkkt.javatests.tax.TestCase;
import com.kirkkt.javatests.tax.TestUtil;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.input.W2TaxYear2014;

import com.google.common.collect.UnmodifiableIterator;

public class W2TaxYear2014Test implements TestCase {

  @Override
  public Form getForm() {
    return new W2TaxYear2014();
  }

  @Override
  public void test() {
    W2TaxYear2014 form = new W2TaxYear2014();
    form.readFromFile(TaxUtil.DATA_FOLDER + "/forms/input/w2taxyear2014.txt");
    assertEquals("W2", form.getFormType());
    assertEquals(2014, form.getTaxYear());
    UnmodifiableIterator<String> gold =
        TestUtil.getGold(TestUtil.TEST_DATA_FOLDER + "/forms/input/w2taxyear2014gold.txt");
    assertEquals(gold.next(), String.valueOf(form.getB1()));
    assertEquals(gold.next(), String.valueOf(form.getB2()));
    assertEquals(gold.next(), String.valueOf(form.getB3()));
    assertEquals(gold.next(), String.valueOf(form.getB4()));
    assertEquals(gold.next(), String.valueOf(form.getB5()));
    assertEquals(gold.next(), String.valueOf(form.getB6()));
    assertEquals(gold.next(), String.valueOf(form.getB7()));
    assertEquals(gold.next(), String.valueOf(form.getB8()));
    assertEquals(gold.next(), String.valueOf(form.getB10()));
    assertEquals(gold.next(), String.valueOf(form.getB11()));
    for (String value : form.getB12()) {
      assertEquals(gold.next(), String.valueOf(value));
    }
    for (boolean value : form.getB13()) {
      assertEquals(gold.next(), String.valueOf(value));
    }
    for (String value : form.getB14()) {
      assertEquals(gold.next(), String.valueOf(value));
    }
    assertEquals(gold.next(), String.valueOf(form.getB16()));
    assertEquals(gold.next(), String.valueOf(form.getB17()));
    assertEquals(gold.next(), String.valueOf(form.getB18()));
    assertEquals(gold.next(), String.valueOf(form.getB19()));
    assertEquals(gold.next(), String.valueOf(form.getB20()));
  }
}
