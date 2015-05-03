package com.kirkkt.javatests.tax.forms.input;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import com.kirkkt.javatests.tax.TestCase;
import com.kirkkt.javatests.tax.TestUtil;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.IntEntry;
import com.kirkkt.java.tax.forms.IntListEntry;
import com.kirkkt.java.tax.forms.BooleanEntry;
import com.kirkkt.java.tax.forms.BooleanListEntry;
import com.kirkkt.java.tax.forms.input.W2TaxYear2014;

import com.google.common.collect.UnmodifiableIterator;

import java.util.Map;

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

    Map<String, String> goldMap =
        TestUtil.getGoldMap(TestUtil.TEST_DATA_FOLDER + "/forms/input/w2taxyear2014gold.txt");
    for (String key : goldMap.keySet()) {
      TestUtil.checkContains(form.keySet(), key);
    }
    for (String key : form.keySet()) {
      TestUtil.checkContains(goldMap.keySet(), key);
    }
    for (String key : form.keySet()) {
      TestUtil.checkFormEntryEquals(form, key, goldMap.get(key));
    }
  }
}
