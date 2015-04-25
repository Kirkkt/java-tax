package com.kirkkt.java.tax.forms.fillable.federal.worksheets;

import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.fillable.AttachedForm;
// import com.kirkkt.java.tax.forms.fillable.federal.F6251TaxYear2014;

import com.google.common.base.Preconditions;

public class F6251ExemptionWorksheetTaxYear2014 implements AttachedForm {

  private int b1 = 0;
  private int b2 = 0;
  private int b3 = 0;
  private int b4 = 0;
  private int b5 = 0;
  private int b6 = 0;
  private int b7 = 0;
  private int b8 = 0;
  private int b9 = 0;
  private int b10 = 0;
  private int bResult = 0;

  @Override
  public String getFormType() {
    return "F6251 Exemption Worksheet";
  }

  @Override
  public int getTaxYear() {
    return 2014;
  }

  @Override
  public void readFromMotherForm(Form form) {
    // readFromF6251(form.getB28());
  }

  public void readFromMotherForm(int formB28) {
    if (formB28 >= 328500) {
      bResult = formB28;
      return;
    }

    b1 = 52800;
    b2 = formB28;
    b3 = 117300;
    b4 = Math.max(0, b2 - b3);
    b5 = Math.round(.25f * b4);
    b6 = Math.max(0, b1 - b5);
    bResult = b6;
  }

  public int getB1() {
    return b1;
  }

  public int getB2() {
    return b2;
  }

  public int getB3() {
    return b3;
  }

  public int getB4() {
    return b4;
  }

  public int getB5() {
    return b5;
  }

  public int getB6() {
    return b6;
  }

  public int getB7() {
    return b7;
  }

  public int getB8() {
    return b8;
  }

  public int getB9() {
    return b9;
  }

  public int getB10() {
    return b10;
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

    result += "b1: " + getB1() + "\n";
    result += "b2: " + getB2() + "\n";
    result += "b3: " + getB3() + "\n";
    result += "b4: " + getB4() + "\n";
    result += "b5: " + getB5() + "\n";
    result += "b6: " + getB6() + "\n";
    result += "b7: " + getB7() + "\n";
    result += "b8: " + getB8() + "\n";
    result += "b9: " + getB9() + "\n";
    result += "b10: " + getB10() + "\n";
    result += "bResult: " + getBResult() + "\n";

    result += "-----------------------\n";

    return result;
  }
}
