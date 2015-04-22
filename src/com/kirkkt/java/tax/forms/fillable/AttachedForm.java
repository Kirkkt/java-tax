package com.kirkkt.java.tax.forms.fillable;

import com.kirkkt.java.tax.forms.Form;

/** A form that needs to read from a file. */
public interface AttachedForm extends Form {

  /**
   * Read from mother form, the form this form is attached to.
   *
   * @param motherForm the mother form
   */
  void readFromMotherForm(Form motherForm);
}
