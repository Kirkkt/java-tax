package com.kirkkt.java.tax.forms.input;

import com.kirkkt.java.tax.Parser;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.Form;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class F1099RTaxYear2014 implements Form {

  private String bPayerFederalIdentificationNumber = "";
  private String bPayerName = "";
  private int b1 = 0;
  private int b2a = 0;
  private boolean[] b2b = new boolean[2];
  private int b3 = 0;
  private int b4 = 0;
  private int b5 = 0;
  private int b6 = 0;
  private String b7 = "";
  private boolean b7Checkbox = false;
  private int b8 = 0;
  private int b9a = 0;
  private int b9b = 0;
  private int b10 = 0;
  private String bAccountNumber = "";
  private int b11 = 0;
  private int b12 = 0;
  private String b13 = "";
  private int b14 = 0;

  public F1099RTaxYear2014() {}

  @Override
  public String getFormType() {
    return "F1099R";
  }

  @Override
  public int getTaxYear() {
    return 2014;
  }

  @Override
  public void readFromFile(String fileName) {
    String line;
    BufferedReader br;

    try {
      br = new BufferedReader(new FileReader(fileName));
      while ((line = br.readLine()) != null) {
        if (line.equals("f1099r " + getTaxYear())) {
          // heading
        } else if (line.startsWith("payer's federal identification number ")) {
          bPayerFederalIdentificationNumber = line.split(" ", 5)[4];
        } else if (line.startsWith("payer's name")) {
          bPayerName = line.split(" ", 3)[2];
        } else if (line.startsWith("account number ")) {
          bAccountNumber = line.split(" ", 3)[2];
        } else if (line.startsWith("b1 ")) {
          b1 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b2a ")) {
          b2a = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b2b ")) {
          // TODO(kirktdev): taxutill.parseboolean
          b2b[0] = Boolean.parseBoolean(line.split(" ", 3)[1]);
          b2b[1] = Boolean.parseBoolean(line.split(" ", 3)[2]);
        } else if (line.startsWith("b3 ")) {
          b3 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b4 ")) {
          b4 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b5 ")) {
          b5 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b6 ")) {
          b6 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b7 ")) {
          b7 = line.split(" ", 2)[1];
        } else if (line.startsWith("b7checkbox ")) {
          b7Checkbox = Boolean.parseBoolean(line.split(" ", 2)[1]);
        } else if (line.startsWith("b8 ")) {
          b8 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b9a ")) {
          b9a = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b9b ")) {
          b9b = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b10 ")) {
          b10 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b11 ")) {
          b11 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b12 ")) {
          b12 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b13 ")) {
          b13 = line.split(" ", 2)[1];
        } else if (line.startsWith("b14 ")) {
          b14 = Parser.parseAndRoundToInt(line, 2);
        } else {
          br.close();
          throw new IllegalArgumentException("Invalid input line: " + line);
        }
      }
      br.close();
    } catch(Exception e) {
      throw new IllegalArgumentException("Failed to read file " + fileName + " due to error " + e);
    }
  }

  public String getBPayerFederalIdentificationNumber() {
    return bPayerFederalIdentificationNumber;
  }

  public String getBPayerName() {
    return bPayerName;
  }

  /** Gross distribution. */
  public int getB1() {
    return b1;
  }

  /** Taxable amount. */
  public int getB2a() {
    return b2a;
  }

  /**
   * [0] Taxablea mount not determined.
   * [1] Total distribution.
   */
  public boolean[] getB2b() {
    return b2b;
  }

  /** Capital gain. */
  public int getB3() {
    return b3;
  }

  /** Federal income tax withheld. */
  public int getB4() {
    return b4;
  }

  /** Employee contri/desig Roth contrib or insurance premiums. */
  public int getB5() {
    return b5;
  }

  /** Net unrealized appreciation in employer
   s securities. */
  public int getB6() {
    return b6;
  }

  /** Distribution code(s). */
  public String getB7() {
    return b7;
  }

  /** IRA/SEP/SIMPLE. */
  public boolean getB7Checkbox() {
    return b7Checkbox;
  }

  /** Other. */
  public int getB8() {
    return b8;
  }

  /** Your percentage of total distribution. */
  public int getB9a() {
    return b9a;
  }

  /** Total employee contributions. */
  public int getB9b() {
    return b9b;
  }

  /** Amount allocable to IRR within 5 years. */
  public int getB10() {
    return b10;
  }

  public String getBAccountNumber() {
    return bAccountNumber;
  }

  /** 1st year of desig. Roth contrib. */
  public int getB11() {
    return b11;
  }

  /** State income withheld. */
  public int getB12() {
    return b12;
  }

  /** State/Payer's state no. */
  public String getB13() {
    return b13;
  }

  /** State distribution. */
  public int getB14() {
    return b14;
  }

  @Override
  public String toString() {
    String result = "";

    result += getFormType() + " Tax Year " + getTaxYear() + "\n";
    result += "-----------------------\n";
    result += "\n";

    result += "Payer's federal identification number:\n  "
        + getBPayerFederalIdentificationNumber() + "\n";
    result += "Payer's name:\n  " + getBPayerName() + "\n";
    result += "\n";

    result += "1 Gross distribution:\n  " + getB1() + "\n";
    result += "\n";

    if (getB2a() > 0) {
      result += "2a Taxable amount:\n  " + getB2a() + "\n";
    }

    if (getB2b()[0]) {
      result += "2b Taxable amount not determined:\n  X" + "\n";
    }
    if (getB2b()[1]) {
      result += "2b Total distribution:\n  X" + "\n";
    }
    if (getB2b()[0] || getB2b()[1])
      result += "\n";

    if (getB3() > 0) {
      result += "3 Capital gain:\n  " + getB3() + "\n";
    }
    if (getB4() > 0) {
      result += "4 Federal income tax withheld:\n  " + getB4() + "\n";
    }
    if (getB3() > 0 || getB4() > 0) {
      result += "\n";
    }

    if (getB5() > 0) {
      result += "5 Employee contribution/designated Roth contribution or insurance premiums:\n  "
          + getB5() + "\n";
    }
    if (getB6() > 0) {
      result += "6 Net unrealized appreciate in employer's securities:\n  " + getB6() + "\n";
    }
    if (getB5() > 0 || getB6() > 0) {
      result += "\n";
    }

    if (!getB7().isEmpty()) {
      result += "7 Distribution code:\n  " + getB7() + "\n";
    }
    if (getB7Checkbox()) {
      result += "7 checkbox IRA/SEP/SIMPLE:\n  X" + "\n";
    }
    if (getB8() > 0) {
      result += "8 Other:\n  " + getB8() + "\n";
    }
    if (!getB7().isEmpty() || getB7Checkbox() || getB8() > 0) {
      result += "\n";
    }

    if (getB9a() > 0) {
      result += "9a Your percentage of total distribution:\n  " + getB9a() + "\n";
    }
    if (getB9b() > 0) {
      result += "9b Total employee contributions:\n  " + getB9b() + "\n";
    }
    if (getB10() > 0) {
      result += "10 Amount allocable to IRR within 5 years:\n  " + getB10() + "\n";
    }
    if (getB9a() > 0 || getB9b() > 0 || getB10() > 0) {
      result += "\n";
    }

    result += "Account number:\n  " + getBAccountNumber() + "\n";
    result += "1st year of designated Roth contribution:\n  " + getB11() + "\n";
    result += "\n";

    if (getB12() > 0) {
      result += "12 State tax withheld:\n  " + getB12() + "\n";
    }
    result += "13 Payer's state number:\n  " + getB13() + "\n";
    if (getB14() > 0) {
      result += "14 State distribution:\n  " + getB14() + "\n";
    }
    result += "\n";

    result += "-----------------------\n";

    return result;
  }

  public static void main(String[] args) {
    F1099RTaxYear2014 form = new F1099RTaxYear2014();
    form.readFromFile(TaxUtil.DATA_FOLDER + "/forms/input/1099rtaxyear2014.txt");
    System.out.print(form);
  }
}
