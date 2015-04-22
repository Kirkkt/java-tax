package com.kirkkt.java.tax.forms.fillable.federal.worksheets;

import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.fillable.AttachedForm;
// import com.kirkkt.java.tax.forms.fillable.federal.F1040TaxYear2014;
// import com.kirkkt.java.tax.forms.fillable.federal.F6251TaxYear2014;
import com.kirkkt.java.tax.TaxUtil;

import com.google.common.base.Preconditions;

public class F1040TaxComputationWorksheetTaxYear2014 implements AttachedForm {

  private int bResult = 0;

  @Override
  public String getFormType() {
    return "F1040 Tax Computation Worksheet";
  }

  @Override
  public int getTaxYear() {
    return 2014;
  }

  @Override
  public void readFromMotherForm(Form motherForm) {
    // readFromF1040(form.getB43());
  }

  public void readFromMotherForm(int formB43) {
    Preconditions.checkArgument(formB43 >= 100000, TaxUtil.additionalLogicNeededString(this));
    Preconditions.checkArgument(formB43 <= 405100, TaxUtil.additionalLogicNeededString(this));

    if (formB43 <= 186350) {
      bResult = Math.round(formB43 * .28f - 6824.25f);
    } else if (formB43 <= 405100) {
      bResult = Math.round(formB43 * .33f - 16141.75f);
    }
  }

  public int getBResult() {
    return bResult;
  }

  @Override
  public String toString() {
    String result = "";

    result += getFormType() + " Tax Year " + getTaxYear() + "\n";
    result += "-----------------------\n";
    result += "\n";

    result += "bResult: " + getBResult() + "\n";

    result += "\n-----------------------\n";

    return result;
  }
}
