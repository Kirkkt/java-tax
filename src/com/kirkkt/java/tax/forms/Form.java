package com.kirkkt.java.tax.forms;

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

  /**
   * Populate the form instance with the input from a file
   *
   * @param fileName the absolute path to the file
   */
  // TODO(kirktdev): this should go to a subinterface called InputForm
  void readFromFile(String fileName);

}
