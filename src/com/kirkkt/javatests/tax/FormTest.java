package com.kirkkt.javatests.tax;

import static org.junit.Assert.assertEquals;

import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.javatests.tax.TestUtil;

import java.util.Map;

public abstract class FormTest {
  /** Runs the test. */
  public void test() {
    Form form = getForm();
    form.readFromFile(TestUtil.TEST_DATA_FOLDER + getInputFilePath());

    Map<String, String> goldMap =
        TestUtil.getGoldMap(TestUtil.TEST_DATA_FOLDER + getGoldFilePath());
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

  /** Gets the form currently being tested. */
  public abstract Form getForm();

  /** Gets the path to the gold file. */
  public abstract String getGoldFilePath();

  /** Gets the path to the input file. */
  public abstract String getInputFilePath();
}
