package com.kirkkt.java.tax.forms.fillable;

import com.kirkkt.java.tax.forms.Form;

/** A form that needs to read from a file. */
public abstract class AttachedForm extends Form {

  /**
   * Read from mother form, the form this form is attached to.
   *
   * @param motherForm the mother form
   */
  public abstract void readFromMotherForm(Form motherForm);
}
