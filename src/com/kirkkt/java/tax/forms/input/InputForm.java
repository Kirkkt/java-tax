package com.kirkkt.java.tax.forms.input;

import com.kirkkt.java.tax.forms.Form;

/** A form that needs to read from a file. */
public interface InputForm extends Form {

  /**
   * Populate the form instance with the input from a file
   *
   * @param fileName the absolute path to the file
   */
  void readFromFile(String fileName);
}
