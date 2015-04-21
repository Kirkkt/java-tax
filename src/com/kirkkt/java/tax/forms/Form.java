package com.kirkkt.java.tax.forms;

/** A form. */
public interface Form {

  /**
   * Gets the type of this form.
   *
   * @return form type, e.g. "W2" or "F1040 Schedule A"
   */
  String getFormType();

  /**
   * Gets the tax year this form is designed for.
   *
   * @return tax year, e.g. 2014
   */
  int getTaxYear();

}
