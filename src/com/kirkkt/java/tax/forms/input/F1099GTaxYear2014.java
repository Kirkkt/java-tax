package com.kirkkt.java.tax.forms.input;

import com.google.common.base.Preconditions;

import com.kirkkt.java.tax.Parser;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.IntEntry;
import com.kirkkt.java.tax.forms.StringEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class F1099GTaxYear2014 extends InputForm {

  private StringEntry bPayerInfo = new StringEntry();
  private StringEntry bPayerFEIN = new StringEntry();
  private IntEntry b2 = new IntEntry();
  private IntEntry b3 = new IntEntry();

  private final TaxUtil util = new TaxUtil();

  public F1099GTaxYear2014() {}

  @Override
  public String getFormType() {
    return "F1099G";
  }

  @Override
  public int getTaxYear() {
    return 2014;
  }

  @Override
  public void readFromFile(String fileName) {
    BufferedReader br;
    String line;

    try {
      br = new BufferedReader(new FileReader(fileName));
      while ((line = br.readLine()) != null) {
        if (line.equals("f1099g " + getTaxYear())) {
          // heading
        } else if (line.startsWith("payer info ")) {
          bPayerInfo.readFromLine(line, "payer info ");
          bPayerInfo.setDescription("Payer's info");
        } else if (line.startsWith("payer's fein ")) {
          bPayerFEIN.readFromLine(line, "payer's fein ");
          bPayerFEIN.setDescription("Payer's FEIN");
        } else if (line.startsWith("b2 ")) {
          b2.readFromLine(line, "b2 ");
          b2.setDescription("State or local income tax refunds, credits, or offsets");
        } else if (line.startsWith("b3 ")) {
          b3.readFromLine(line, "b3 ");
          b3.setDescription("tax year");
        } else {
          br.close();
          throw new IllegalArgumentException("Invalid input line: " + line);
        }
      }
      br.close();
    } catch (IOException e) {
      throw new IllegalArgumentException("Failed to read file " + fileName + " due to error " + e);
    }
  }

  @Override
  public void prod() {
    readFromFile(TaxUtil.DATA_FOLDER + "/forms/input/f1099gtaxyear2014.txt");
    System.out.print(this);
  }

  /** Payer info, e.g. state of California. */
  public StringEntry getBPayerInfo() {
    return bPayerInfo;
  }

  /** Payer's FEIN. */
  public StringEntry getBPayerFEIN() {
    return bPayerFEIN;
  }

  /** State or local income tax refunds, credits, or offsets. */
  public IntEntry getB2() {
    return b2;
  }

  /** Tax year. */
  public IntEntry getB3() {
    return b3;
  }

  @Override
  public String toString() {
    String result = "";
    result += getFormType() + " Tax Year " + getTaxYear() + "\n";
    result += "-----------------------\n";
    result += "\n";

    result += bPayerInfo.print();
    result += bPayerFEIN.print();
    result += "" + "\n";

    result += b2.print();
    result += b3.print();
    result += "\n";

    result += "-----------------------\n";

    return result;
  }
}
