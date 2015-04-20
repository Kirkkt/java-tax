package com.kirkkt.javatests.tax;

import com.kirkkt.java.tax.forms.Form;

public interface TestCase {
  /** Runs the test. */
  void test();

  /** Gets the form currently being tested. */
  Form getForm();
}
