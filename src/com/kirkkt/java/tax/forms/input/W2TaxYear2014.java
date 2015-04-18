package com.kirkkt.java.tax.forms.input;

import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.Form;

import java.io.BufferedReader;
import java.io.FileReader;

public class W2TaxYear2014 implements Form {

  private int b1 = 0;
  private int b2 = 0;
  private int b3 = 0;
  private int b4 = 0;
  private int b5 = 0;
  private int b6 = 0;
  private int b7 = 0;
  private int b8 = 0;
  private int b10 = 0;
  private int b11 = 0;
  private String[] b12 = null;
  private boolean[] b13 = new boolean[3];
  private String[] b14 = null;
  private int b16 = 0;
  private int b17 = 0;
  private int b18 = 0;
  private int b19 = 0;
  private String b20 = "";

  private final TaxUtil util = new TaxUtil();

  public W2TaxYear2014() {}

  @Override
  public String getFormType() {
    return "W2";
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
        if (line.equals("w2 " + getTaxYear())) {
          // heading
        } else if (line.startsWith("b1 ")) {
          b1 = TaxUtil.round(Double.parseDouble(line.split(" ", 2)[1]));
        } else if (line.startsWith("b2 ")) {
          b2 = TaxUtil.round(Double.parseDouble(line.split(" ", 2)[1]));
        } else if (line.startsWith("b3 ")) {
          b3 = TaxUtil.round(Double.parseDouble(line.split(" ", 2)[1]));
        } else if (line.startsWith("b4 ")) {
          b4 = TaxUtil.round(Double.parseDouble(line.split(" ", 2)[1]));
        } else if (line.startsWith("b5 ")) {
          b5 = TaxUtil.round(Double.parseDouble(line.split(" ", 2)[1]));
        } else if (line.startsWith("b6 ")) {
          b6 = TaxUtil.round(Double.parseDouble(line.split(" ", 2)[1]));
        } else if (line.startsWith("b7 ")) {
          b7 = TaxUtil.round(Double.parseDouble(line.split(" ", 2)[1]));
        } else if (line.startsWith("b8 ")) {
          b8 = TaxUtil.round(Double.parseDouble(line.split(" ", 2)[1]));
        } else if (line.startsWith("b10 ")) {
          b10 = TaxUtil.round(Double.parseDouble(line.split(" ", 2)[1]));
        } else if (line.startsWith("b11 ")) {
          b11 = TaxUtil.round(Double.parseDouble(line.split(" ", 2)[1]));
        } else if (line.startsWith("b12 ")) {
          String[] words = line.split(" ");
          b12 = new String[words.length-1];
          for (int i = 1; i < words.length; i++) {
            b12[i-1] = words[i];
          }
        } else if (line.startsWith("b13 ")) {
          String[] words = line.split(" ");
          b13[0] = Boolean.parseBoolean(words[1]);
          b13[1] = Boolean.parseBoolean(words[2]);
          b13[2] = Boolean.parseBoolean(words[3]);
        } else if (line.startsWith("b14 ")) {
          String[] words = line.split(" ");
          b14 = new String[words.length-1];
          for (int i = 1; i < words.length; i++) {
            b14[i-1] = words[i];
          }
        } else if (line.startsWith("b16 ")) {
          b16 = TaxUtil.round(Double.parseDouble(line.split(" ", 2)[1]));
        } else if (line.startsWith("b17 ")) {
          b17 = TaxUtil.round(Double.parseDouble(line.split(" ", 2)[1]));
        } else if (line.startsWith("b18 ")) {
          b18 = TaxUtil.round(Double.parseDouble(line.split(" ", 2)[1]));
        } else if (line.startsWith("b19 ")) {
          b19 = TaxUtil.round(Double.parseDouble(line.split(" ", 2)[1]));
        } else if (line.startsWith("b20 ")) {
          b20 = line.split(" ", 2)[1];
        } else {
          br.close();
          throw new IllegalArgumentException("Invalid input line: " + line);
        }
      }
      br.close();
    } catch (Exception e) {
      throw new IllegalArgumentException("Failed to read file " + fileName + " due to error " + e);
    }
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

  public int getB10() {
    return b10;
  }

  public int getB11() {
    return b11;
  }

  public String[] getB12() {
    return b12;
  }

  public boolean[] getB13() {
    return b13;
  }

  public String[] getB14() {
    return b14;
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

  public String getB20() {
    return b20;
  }

  @Override
  public String toString() {
    String result = "";
    result += getFormType() + " Tax Year " + getTaxYear() + "\n";
    result += "-----------------------\n";
    result += "\n";

    result += "1 Wages, tips, other compensation: " + getB1() + "\n";
    result += "2 Federal income tax withheld: " + getB2() + "\n";
    result += "\n";

    result += "Employer's name, address, and ZIP code: " + util.getEmployerAddress() + "\n";
    result += "3 Social security wages: " + getB3() + "\n";
    result += "4 Secial security tax withheld: " + getB4() + "\n";
    result += "\n";

    result += "5 Medicare wages and tips: " + getB5() + "\n";
    result += "6 Medicare tax withheld: " + getB6() + "\n";
    result += "\n";

    if (getB7() > 0) {
      result += "7 Social security tips: " + getB7() + "\n";
    }
    if (getB8() > 0) {
      result += "8 Allocated tips: " + getB8() + "\n";
    }
    if (getB7() > 0 || getB8() > 0) {
      result += "\n";
    }

    result += "Employer identification number (EIN): " + util.getEmployerIdentificationNumber()
        + "\n";
    if (getB10() > 0) {
      result += "19 Dependent care benefits: " + getB10() + "\n";
    }
    result += "\n";

    if (getB11() > 0) {
      result += "11 Nonqualified plans: " + getB11() + "\n";
    }
    if (getB13()[0]) {
      result += "13 Statutory employee: X\n";
    }
    if (getB13()[1]) {
      result += "13 Retirement plan: X\n";
    }
    if (getB13()[2]) {
      result += "13 Third-party sick pay: X\n";
    }
    if (getB11() > 0 || getB13()[0] || getB13()[1] || getB13()[2]) {
      result += "\n";
    }

    if (getB12() != null) {
      result += "12 See instrubtions for box 12\n";
      for (int i = 0; i < getB12().length; i += 2) {
        result += "  " + getB12()[i] + "\t" + getB12()[i + 1] + "\n";
      }
    }
    if (getB14() != null) {
      result += "14 Other\n";
      for (int i = 0; i < getB14().length; i += 2) {
        result += ("  " + getB14()[i] + "\t" + getB14()[i + 1]) + "\n";
      }
    }
    if (getB12() != null || getB14() != null) {
      result += "\n";
    }

    result += "15 State: CA\n";
    result += "Employer's state ID No.: " + util.getEmployerStateIdNumber() + "\n";
    result += "16 State wages, tipc, etc.: " + getB16() + "\n";
    result += "17 State income tax: " + getB17() + "\n";
    if (getB18() > 0) {
      result += "18 Local wages, tips, etc.: " + getB18() + "\n";
    }
    if (getB19() > 0) {
      result += "19 Local income tax: " + getB19() + "\n";
    }
    if (!getB20().isEmpty()) {
      result += "20 Locality name: " + getB20() + "\n";
    }
    result += "\n";

    result += "-----------------------\n";

    return result;
  }

  public static void main(String[] args) {
    W2TaxYear2014 form = new W2TaxYear2014();
    form.readFromFile(TaxUtil.DATA_FOLDER + "/forms/input/w2taxyear2014.txt");
    System.out.print(form);
  }
}
