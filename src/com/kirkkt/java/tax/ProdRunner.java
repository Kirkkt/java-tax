package com.kirkkt.java.tax;

import com.kirkkt.java.tax.forms.input.InputForm;
import com.kirkkt.java.tax.forms.fillable.federal.worksheets.ItemizedDeductionsWorksheetTaxYear2014;
import com.kirkkt.java.tax.forms.input.F1099DivTaxYear2014;
import com.kirkkt.java.tax.forms.input.F1099GTaxYear2014;
import com.kirkkt.java.tax.forms.input.F1099RTaxYear2014;
import com.kirkkt.java.tax.forms.input.W2TaxYear2014;

import com.google.common.collect.ImmutableList;

public class ProdRunner {

  public static void main(String[] args) {
    new ProdRunner();
  }

  private ProdRunner() {
    ImmutableList<InputForm> forms = ImmutableList.<InputForm>builder()
      // Add new tests here.
      .add(new F1099DivTaxYear2014())
      .add(new F1099GTaxYear2014())
      .add(new F1099RTaxYear2014())
      // .add(new W2TaxYear2014())
      .build();

    for (InputForm form : forms) {
      form.prod();
    }
  }
}
