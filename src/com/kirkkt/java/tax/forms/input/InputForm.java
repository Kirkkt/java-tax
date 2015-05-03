package com.kirkkt.java.tax.forms.input;

import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.Form;

// TODO(kirktdev): remove?
/** A form that needs to read from a file. */
public abstract class InputForm extends Form {

  /**
   * Print the form in production.
   */
  public void prod() {
    readFromFile(TaxUtil.DATA_FOLDER + getInputFilePath());
    System.out.print(this);
  }

  /** Gets the path to the input file. */
  public abstract String getInputFilePath();
}
