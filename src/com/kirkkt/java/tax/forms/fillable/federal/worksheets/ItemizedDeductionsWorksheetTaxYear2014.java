package com.kirkkt.java.tax.forms.fillable.federal.worksheets;

import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.fillable.AttachedForm;
import com.kirkkt.java.tax.forms.fillable.federal.F1040ScheduleATaxYear2014;

public class ItemizedDeductionsWorksheetTaxYear2014 implements AttachedForm {

  private int b1 = 0;
  private int b2 = 0;
  private int b3 = 0;
  private boolean b3Checkbox = false;
  private int b4 = 0;
  private int b5 = 0;
  private int b6 = 0;
  private int b7 = 0;
  private boolean b7Checkbox = false;
  private int b8 = 0;
  private int b9 = 0;
  private int b10 = 0;
  private int bResult = 0;

  @Override
  public String getFormType() {
    return "Itemized Deductions Worksheet";
  }

  @Override
  public int getTaxYear() {
    return 2014;
  }

  @Override
  public void readFromMotherForm(Form motherForm) {
    F1040ScheduleATaxYear2014 form = (F1040ScheduleATaxYear2014) motherForm;
    readFromMotherForm(
        form.getB2(),
        form.getB4(),
        form.getB9(),
        form.getB14(),
        form.getB15(),
        form.getB19(),
        form.getB20(),
        form.getB27(),
        form.getB28()
    );
  }

  public void readFromMotherForm(
      int formB2,
      int formB4,
      int formB9,
      int formB14,
      int formB15,
      int formB19,
      int formB20,
      int formB27,
      int formB28
  ) {
    b1 = formB4 + formB9 + formB15 + formB19 + formB20 + formB27 + formB28;
    b2 = formB4 + formB14 + formB20;
    b3Checkbox = b2 < b1;
    if (!b3Checkbox) {
      bResult = b1;
      return;
    }

    b3 = b1 - b2;
    b4 = Math.round(.8f * b3);
    b5 = formB2;

    b6 = 254200;
    b7Checkbox = b6 < b5;
    if (!b7Checkbox) {
      bResult = b1;
      return;
    }
    b7 = b5 - b6;
    b8 = Math.round(b7 * .03f);
    b9 = Math.min(b4, b8);
    b10 = b1 - b9;
    bResult = b10;
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

  public boolean getB3Checkbox() {
    return b3Checkbox;
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

  public boolean getB7Checkbox() {
    return b7Checkbox;
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
    result += "1\n  " + b1 + "\n";
    result += "2\n  " + b2 + "\n";
    result += "3Checkbox\n  " + b3Checkbox + "\n";
    if (!b3Checkbox) {
      result += "\n-----------------------\n";
      return result;
    }

    result += "3\n  " + b3 + "\n";
    result += "4\n  " + b4 + "\n";
    result += "5\n  " + b5 + "\n";
    result += "6\n  " + b6 + "\n";
    result += "7Checkbox\n  " + b7Checkbox + "\n";
    if (!b7Checkbox) {
      result += "\n-----------------------\n";
      return result;
    }

    result += "7\n  " + b7 + "\n";
    result += "8\n  " + b8 + "\n";
    result += "9\n  " + b9 + "\n";
    result += "10\n  " + b10 + "\n";

    result += "\n-----------------------\n";
    return result;
  }
}
