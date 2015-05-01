package com.kirkkt.java.tax.forms.input;

import com.kirkkt.java.tax.Parser;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.IntEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class F1099RTaxYear2014 implements InputForm {

  private String bPayerFederalIdentificationNumber = "";
  private String bPayerName = "";
  private IntEntry b1 = new IntEntry();
  private IntEntry b2a = new IntEntry();
  private boolean[] b2b = new boolean[2];
  private IntEntry b3 = new IntEntry();
  private IntEntry b4 = new IntEntry();
  private IntEntry b5 = new IntEntry();
  private IntEntry b6 = new IntEntry();
  private String b7 = "";
  private boolean b7Checkbox = false;
  private IntEntry b8 = new IntEntry();
  private IntEntry b9a = new IntEntry();
  private IntEntry b9b = new IntEntry();
  private IntEntry b10 = new IntEntry();
  private String bAccountNumber = "";
  private IntEntry b11 = new IntEntry();
  private IntEntry b12 = new IntEntry();
  private String b13 = "";
  private IntEntry b14 = new IntEntry();

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
          b1.readFromLine(line, "b1 ");
          b1.setDescription("Gross distribution");
        } else if (line.startsWith("b2a ")) {
          b2a.readFromLine(line, "b2a ");
          b2a.setDescription("Taxable amount");
        } else if (line.startsWith("b2b ")) {
          b2b = Parser.parseBooleanArray(line, 2);
        } else if (line.startsWith("b3 ")) {
          b3.readFromLine(line, "b3 ");
          b3.setDescription("Capital gain");
        } else if (line.startsWith("b4 ")) {
          b4.readFromLine(line, "b4 ");
          b4.setDescription("Federal income tax withheld");
        } else if (line.startsWith("b5 ")) {
          b5.readFromLine(line, "b5 ");
          b5.setDescription("Employee contribution/designated Roth contribution or insurance premiums");
        } else if (line.startsWith("b6 ")) {
          b6.readFromLine(line, "b6 ");
          b6.setDescription("Net unrealized appreciate in employer's securities");
        } else if (line.startsWith("b7 ")) {
          b7 = line.split(" ", 2)[1];
        } else if (line.startsWith("b7checkbox ")) {
          b7Checkbox = Boolean.parseBoolean(line.split(" ", 2)[1]);
        } else if (line.startsWith("b8 ")) {
          b8.readFromLine(line, "b8 ");
          b8.setDescription("Other");
        } else if (line.startsWith("b9a ")) {
          b9a.readFromLine(line, "b9a ");
          b9a.setDescription("Your percentage of total distribution");
        } else if (line.startsWith("b9b ")) {
          b9b.readFromLine(line, "b9b ");
          b9b.setDescription("Total employee contributions");
        } else if (line.startsWith("b10 ")) {
          b10.readFromLine(line, "b10 ");
          b10.setDescription("Amount allocable to IRR within 5 years");
        } else if (line.startsWith("b11 ")) {
          b11.readFromLine(line, "b11 ");
          b11.setDescription("year of designated Roth contribution");
        } else if (line.startsWith("b12 ")) {
          b12.readFromLine(line, "b12 ");
          b12.setDescription("State tax withheld");
        } else if (line.startsWith("b13 ")) {
          b13 = line.split(" ", 2)[1];
        } else if (line.startsWith("b14 ")) {
          b14.readFromLine(line, "b14 ");
          b14.setDescription("State distribution");
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

  @Override
  public void prod() {
    readFromFile(TaxUtil.DATA_FOLDER + "/forms/input/f1099rtaxyear2014.txt");
    System.out.print(this);
  }

  public String getBPayerFederalIdentificationNumber() {
    return bPayerFederalIdentificationNumber;
  }

  public String getBPayerName() {
    return bPayerName;
  }

  /** Gross distribution. */
  public IntEntry getB1() {
    return b1;
  }

  /** Taxable amount. */
  public IntEntry getB2a() {
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
  public IntEntry getB3() {
    return b3;
  }

  /** Federal income tax withheld. */
  public IntEntry getB4() {
    return b4;
  }

  /** Employee contri/desig Roth contrib or insurance premiums. */
  public IntEntry getB5() {
    return b5;
  }

  /** Net unrealized appreciation in employer
   s securities. */
  public IntEntry getB6() {
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
  public IntEntry getB8() {
    return b8;
  }

  /** Your percentage of total distribution. */
  public IntEntry getB9a() {
    return b9a;
  }

  /** Total employee contributions. */
  public IntEntry getB9b() {
    return b9b;
  }

  /** Amount allocable to IRR within 5 years. */
  public IntEntry getB10() {
    return b10;
  }

  public String getBAccountNumber() {
    return bAccountNumber;
  }

  /** 1st year of desig. Roth contrib. */
  public IntEntry getB11() {
    return b11;
  }

  /** State income withheld. */
  public IntEntry getB12() {
    return b12;
  }

  /** State/Payer's state no. */
  public String getB13() {
    return b13;
  }

  /** State distribution. */
  public IntEntry getB14() {
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

    result += getB1().print();
    result += "\n";

    result += getB2a().print();

    if (getB2b()[0]) {
      result += "2b Taxable amount not determined:\n  X" + "\n";
    }
    if (getB2b()[1]) {
      result += "2b Total distribution:\n  X" + "\n";
    }
    if (getB2b()[0] || getB2b()[1])
      result += "\n";

    result += getB3().print();
    result += getB4().print();
    // if (getB3().isDirty() || getB4().isDirty()) {
      result += "\n";
    // }

    result += getB5().print();
    result += getB6().print();
    if (getB5().isDirty() || getB6().isDirty()) {
      result += "\n";
    }

    if (!getB7().isEmpty()) {
      result += "7 Distribution code:\n  " + getB7() + "\n";
    }
    if (getB7Checkbox()) {
      result += "7 checkbox IRA/SEP/SIMPLE:\n  X" + "\n";
    }
    result += getB8().print();
    if (!getB7().isEmpty() || getB7Checkbox() || getB8().isDirty()) {
      result += "\n";
    }

    result += getB9a().print();
    result += getB9b().print();
    result += getB10().print();
    if (getB9a().isDirty() || getB9b().isDirty() || getB10().isDirty()) {
      result += "\n";
    }

    result += "Account number:\n  " + getBAccountNumber() + "\n";
    result += getB11().print();
    result += "\n";

    result += getB12().print();
    result += "13 Payer's state number:\n  " + getB13() + "\n";
    result += getB14().print();
    result += "\n";

    result += "-----------------------\n";

    return result;
  }
}
