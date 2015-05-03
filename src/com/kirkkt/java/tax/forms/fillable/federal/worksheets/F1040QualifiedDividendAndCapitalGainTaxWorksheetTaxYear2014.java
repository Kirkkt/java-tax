package com.kirkkt.java.tax.forms.fillable.federal.worksheets;

import com.kirkkt.java.tax.forms.fillable.AttachedForm;
import com.kirkkt.java.tax.forms.Form;
// import com.kirkkt.java.tax.forms.fillable.federal.F1040TaxYear2014;
// import com.kirkkt.java.tax.forms.fillable.federal.F6251TaxYear2014;
import com.kirkkt.java.tax.TaxUtil;

import com.google.common.base.Preconditions;

public class F1040QualifiedDividendAndCapitalGainTaxWorksheetTaxYear2014 implements AttachedForm {

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
  private int b11 = 0;
  private int b12 = 0;
  private int b13 = 0;
  private int b14 = 0;
  private int b15 = 0;
  private int b16 = 0;
  private int b17 = 0;
  private int b18 = 0;
  private int b19 = 0;
  private int b20 = 0;
  private int b21 = 0;
  private int b22 = 0;
  private int b23 = 0;
  private int b24 = 0;
  private int b25 = 0;
  private int b26 = 0;
  private int b27 = 0;
  private int bResult = 0;

  @Override
  public String getFormType() {
    return "F1040 Qualified Dividend And Capital Gain Tax Worksheet";
  }

  @Override
  public int getTaxYear() {
    return 2014;
  }

  @Override
  public void readFromMotherForm(Form form) {
  // public void readFromMotherForm(F1040TaxYear2014 form) {
    // readFromF1040(
    //     form.getB9b(),
    //     form.getB13(),
    //     form.getB43()
    // );
  }

  public void readFromMotherForm(
      int formB9b,
      int formB13,
      int formB43
  ) {
    b1 = formB43;
    b2 = formB9b;
    b3 = formB13;
    b4 = b2 + b3;
    b5 = 0;
    b6 = Math.max(0, b4 - b5);
    b7 = Math.max(0, b1 - b6);
    b8 = 36250;
    b9 = Math.min(b1, b8);
    b10 = Math.min(b7, b9);
    b11 = b9 - b10;
    b12 = Math.min(b1, b6);
    b13 = b11;
    b14 = b12 - b13;
    b15 = 400000;
    b16 = Math.min(b1, b15);
    b17 = b7 + b11;
    b18 = Math.max(0, b16 - b17);
    b19 = Math.min(b14, b18);
    b20 = Math.round(.15f * b19);
    b21 = b11 + b19;
    b22 = b12 - b21;
    b23 = Math.round(.2f * b22);
    F1040TaxComputationWorksheetTaxYear2014 worksheet;
    Preconditions.checkArgument(b7 >= 100000, TaxUtil.additionalLogicNeededString(this, "24"));
    worksheet = new F1040TaxComputationWorksheetTaxYear2014();
    worksheet.readFromMotherForm(b7);
    b24 = worksheet.getBResult();
    b25 = b20 + b23 + b24;
    Preconditions.checkArgument(b1 >= 100000, TaxUtil.additionalLogicNeededString(this, "26"));
    worksheet = new F1040TaxComputationWorksheetTaxYear2014();
    worksheet.readFromMotherForm(b1);
    b26 = worksheet.getBResult();
    b27 = Math.min(b25, b26);
    bResult = b27;
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

  public int getB11() {
    return b11;
  }

  public int getB12() {
    return b12;
  }

  public int getB13() {
    return b13;
  }

  public int getB14() {
    return b14;
  }

  public int getB15() {
    return b15;
  }

  public int getB16() {
    return b16;
  }

  public int getB17() {
    return b17;
  }

  public int getB18() {
    return b18;
  }

  public int getB19() {
    return b19;
  }

  public int getB20() {
    return b20;
  }

  public int getB21() {
    return b21;
  }

  public int getB22() {
    return b22;
  }

  public int getB23() {
    return b23;
  }

  public int getB24() {
    return b24;
  }

  public int getB25() {
    return b25;
  }

  public int getB26() {
    return b26;
  }

  public int getB27() {
    return b27;
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
    result += "b11: " + getB11() + "\n";
    result += "b12: " + getB12() + "\n";
    result += "b13: " + getB13() + "\n";
    result += "b14: " + getB14() + "\n";
    result += "b15: " + getB15() + "\n";
    result += "b16: " + getB16() + "\n";
    result += "b17: " + getB17() + "\n";
    result += "b18: " + getB18() + "\n";
    result += "b19: " + getB19() + "\n";
    result += "b20: " + getB20() + "\n";
    result += "b21: " + getB21() + "\n";
    result += "b22: " + getB22() + "\n";
    result += "b23: " + getB23() + "\n";
    result += "b24: " + getB24() + "\n";
    result += "b25: " + getB25() + "\n";
    result += "b26: " + getB26() + "\n";
    result += "b27: " + getB27() + "\n";
    result += "bResult: " + getBResult() + "\n";

    result += "-----------------------\n";

    return result;
  }
}
