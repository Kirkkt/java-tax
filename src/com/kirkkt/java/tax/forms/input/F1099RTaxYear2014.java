package com.kirkkt.java.tax.forms.input;

import com.kirkkt.java.tax.Parser;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.BooleanEntry;
import com.kirkkt.java.tax.forms.IntEntry;
import com.kirkkt.java.tax.forms.StringEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class F1099RTaxYear2014 implements InputForm {

  private StringEntry bPayerFederalIdentificationNumber = new StringEntry();
  private StringEntry bPayerName = new StringEntry();
  private IntEntry b1 = new IntEntry();
  private IntEntry b2a = new IntEntry();
  private boolean[] b2b = new boolean[2];
  private IntEntry b3 = new IntEntry();
  private IntEntry b4 = new IntEntry();
  private IntEntry b5 = new IntEntry();
  private IntEntry b6 = new IntEntry();
  private StringEntry b7 = new StringEntry();
  private BooleanEntry b7Checkbox = new BooleanEntry();
  private IntEntry b8 = new IntEntry();
  private IntEntry b9a = new IntEntry();
  private IntEntry b9b = new IntEntry();
  private IntEntry b10 = new IntEntry();
  private StringEntry bAccountNumber = new StringEntry();
  private IntEntry b11 = new IntEntry();
  private IntEntry b12 = new IntEntry();
  private StringEntry b13 = new StringEntry();
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
          bPayerFederalIdentificationNumber.readFromLine(line,
              "payer's federal identification number ");
          bPayerFederalIdentificationNumber.setDescription("Payer's federal identification number");
        } else if (line.startsWith("payer's name ")) {
          bPayerName.readFromLine(line, "payer's name ");
          bPayerName.setDescription("Payer's name");
        } else if (line.startsWith("account number ")) {
          bAccountNumber.readFromLine(line, "account number ");
          bAccountNumber.setDescription("Account number");
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
          b7.readFromLine(line, "b7 ");
          b7.setDescription("Distribution code");
        } else if (line.startsWith("b7checkbox ")) {
          b7Checkbox.readFromLine(line, "b7checkbox ");
          b7Checkbox.setDescription("IRA/SEP/SIMPLE");
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
          b13.readFromLine(line, "b13 ");
          b13.setDescription("Payer's state number");
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

  public StringEntry getBPayerFederalIdentificationNumber() {
    return bPayerFederalIdentificationNumber;
  }

  public StringEntry getBPayerName() {
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
  public StringEntry getB7() {
    return b7;
  }

  /** IRA/SEP/SIMPLE. */
  public BooleanEntry getB7Checkbox() {
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

  public StringEntry getBAccountNumber() {
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
  public StringEntry getB13() {
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

    result += bPayerFederalIdentificationNumber.print();
    result += bPayerName.print();
    result += "\n";

    result += b1.print();
    result += "\n";

    result += b2a.print();

    if (b2b[0]) {
      result += "2b Taxable amount not determined:\n  X" + "\n";
    }
    if (b2b[1]) {
      result += "2b Total distribution:\n  X" + "\n";
    }
    if (b2b[0] || b2b[1])
      result += "\n";

    result += b3.print();
    result += b4.print();
    // if (b3.isDirty() || b4.isDirty()) {
      result += "\n";
    // }

    result += b5.print();
    result += b6.print();
    if (b5.isDirty() || b6.isDirty()) {
      result += "\n";
    }

    result += b7.print();
    result += b7Checkbox.print();
    result += b8.print();
    if (b7.isDirty() || b7Checkbox.isDirty() || b8.isDirty()) {
      result += "\n";
    }

    result += b9a.print();
    result += b9b.print();
    result += b10.print();
    if (b9a.isDirty() || b9b.isDirty() || b10.isDirty()) {
      result += "\n";
    }

    result += bAccountNumber.print();
    result += b11.print();
    result += "\n";

    result += b12.print();
    result += b13.print();
    result += b14.print();
    result += "\n";

    result += "-----------------------\n";

    return result;
  }
}
