package com.kirkkt.java.tax.forms.input;

import com.kirkkt.java.tax.Parser;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.Form;

import com.google.common.base.Preconditions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class F1099GTaxYear2014 implements Form {

  private String bPayerInfo = "";
  private String bPayerFEIN = "";
  private int b2 = 0;
  private int b3 = 0;

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
          bPayerInfo = line.split(" ", 3)[2];
        } else if (line.startsWith("payer's fein ")) {
          bPayerFEIN = line.split(" ", 3)[2];
        } else if (line.startsWith("b2 ")) {
          b2 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b3 ")) {
          b3 = Parser.parseAndRoundToInt(line, 2);
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

  /** Payer info, e.g. state of California. */
  public String getBPayerInfo() {
    return bPayerInfo;
  }

  /** Payer's FEIN. */
  public String getBPayerFEIN() {
    return bPayerFEIN;
  }

  /** State or local income tax refunds, credits, or offsets. */
  public int getB2() {
    return b2;
  }

  /** Tax year. */
  public int getB3() {
    return b3;
  }

  @Override
  public String toString() {
    String result = "";
    result += getFormType() + " Tax Year " + getTaxYear() + "\n";
    result += "-----------------------\n";
    result += "\n";

    result += "Payer's info:\n  " + getBPayerInfo() + "\n";
    result += "Payer's FEIN:\n  " + getBPayerFEIN() + "\n";
    result += "" + "\n";

    result += "2 State or local income tax refunds, credits, or offsets:\n  " + getB2() + "\n";
    result += "3 tax year:\n  " + getB3() + "\n";
    result += "\n";

    result += "-----------------------\n";

    return result;
  }

  public static void main(String[] args) {
    F1099GTaxYear2014 form = new F1099GTaxYear2014();
    form.readFromFile(TaxUtil.DATA_FOLDER + "/forms/input/1099gtaxyear2014.txt");
    System.out.print(form);
  }
}
