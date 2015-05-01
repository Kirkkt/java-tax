package com.kirkkt.javatests.tax.forms.input;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.kirkkt.javatests.tax.TestCase;
import com.kirkkt.javatests.tax.TestUtil;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.input.F1099GTaxYear2014;

import com.google.common.collect.UnmodifiableIterator;

public class F1099GTaxYear2014Test implements TestCase {

  @Override
  public Form getForm() {
    return new F1099GTaxYear2014();
  }

  @Override
  public void test() {
    F1099GTaxYear2014 form = new F1099GTaxYear2014();
    form.readFromFile(TaxUtil.DATA_FOLDER + "/forms/input/f1099gtaxyear2014.txt");
    assertEquals("F1099G", form.getFormType());
    assertEquals(2014, form.getTaxYear());
    UnmodifiableIterator<String> gold =
        TestUtil.getGold(TestUtil.TEST_DATA_FOLDER + "/forms/input/f1099gtaxyear2014gold.txt");

    assertEquals(gold.next(), String.valueOf(form.getBPayerInfo()));
    assertEquals(gold.next(), String.valueOf(form.getBPayerFEIN()));
    assertEquals(gold.next(), String.valueOf(form.getB2().getValue()));
    assertEquals(gold.next(), String.valueOf(form.getB3().getValue()));
    assertFalse(gold.hasNext());
  }
}
