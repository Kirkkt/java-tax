package com.kirkkt.javatests.tax.forms.input;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.kirkkt.javatests.tax.TestCase;
import com.kirkkt.javatests.tax.TestUtil;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.IntEntry;
import com.kirkkt.java.tax.forms.BooleanEntry;
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
    assertEquals(gold.next(), String.valueOf(form.getB1().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB2().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB3().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB4().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB5().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB6().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB7().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB8().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB10().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB11().getValue()));
    for (IntEntry entry : form.getB12().getValue()) {
      assertEquals(gold.next(), entry.getDescription());
      assertEquals(gold.next(), String.valueOf(entry.getValue()));
    }
    for (BooleanEntry entry : form.getB13().getValue()) {
      assertEquals(gold.next(), String.valueOf(entry.getValue()));
    }
    for (IntEntry entry : form.getB14().getValue()) {
      assertEquals(gold.next(), entry.getDescription());
      assertEquals(gold.next(), String.valueOf(entry.getValue()));
    }
    assertEquals(gold.next(), String.valueOf(form.getB16().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB17().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB18().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB19().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB20()));
    assertFalse(gold.hasNext());
  }
}
