package com.kirkkt.java.tax.forms.input;

import com.kirkkt.java.tax.forms.Form;

/** A form that needs to read from a file. */
public abstract class InputForm extends Form {

  /**
   * Populate the form instance with the input from a file
   *
   * @param fileName the absolute path to the file
   */
  public abstract void readFromFile(String fileName);

  /**
   * Print the form in production.
   */
  public abstract void prod();
}
