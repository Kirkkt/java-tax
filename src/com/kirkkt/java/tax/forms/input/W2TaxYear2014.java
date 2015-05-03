package com.kirkkt.java.tax.forms.input;

import com.google.common.base.Preconditions;

import com.kirkkt.java.tax.Parser;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.IntEntry;
import com.kirkkt.java.tax.forms.StringEntry;
import com.kirkkt.java.tax.forms.IntListEntry;
import com.kirkkt.java.tax.forms.BooleanListEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class W2TaxYear2014 implements InputForm {
// TODO(kirktdev): use collections instead of declaring individual entries

  private IntEntry b1 = new IntEntry();
  private IntEntry b2 = new IntEntry();
  private IntEntry b3 = new IntEntry();
  private IntEntry b4 = new IntEntry();
  private IntEntry b5 = new IntEntry();
  private IntEntry b6 = new IntEntry();
  private IntEntry b7 = new IntEntry();
  private IntEntry b8 = new IntEntry();
  private IntEntry b10 = new IntEntry();
  private IntEntry b11 = new IntEntry();
  private IntListEntry b12 = new IntListEntry();
  private BooleanListEntry b13 = new BooleanListEntry();
  private IntListEntry b14 = new IntListEntry();
  private StringEntry b15 = new StringEntry();
  private StringEntry bEmployerStateIdNumber = new StringEntry();
  private IntEntry b16 = new IntEntry();
  private IntEntry b17 = new IntEntry();
  private IntEntry b18 = new IntEntry();
  private IntEntry b19 = new IntEntry();
  private StringEntry b20 = new StringEntry();

  private boolean fileImported = false;

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
    if (fileImported) {
      throw new IllegalStateException("Form " + getFormType() + " for tax year " + getTaxYear()
          + " can't read from files more than once.");
    }
    fileImported = true;

    BufferedReader br;
    String line;

    try {
      br = new BufferedReader(new FileReader(fileName));
      while ((line = br.readLine()) != null) {
        if (line.equals("w2 " + getTaxYear())) {
          // heading
        } else if (line.startsWith("b1 ")) {
          b1.readFromLine(line, "b1 ");
          b1.setDescription("Wages, tips, other compensation");
        } else if (line.startsWith("b2 ")) {
          b2.readFromLine(line, "b2 ");
          b2.setDescription("Federal income tax withheld");
        } else if (line.startsWith("b3 ")) {
          b3.readFromLine(line, "b3 ");
          b3.setDescription("Social security wages");
        } else if (line.startsWith("b4 ")) {
          b4.readFromLine(line, "b4 ");
          b4.setDescription("Secial security tax withheld");
        } else if (line.startsWith("b5 ")) {
          b5.readFromLine(line, "b5 ");
          b5.setDescription("Medicare wages and tips");
        } else if (line.startsWith("b6 ")) {
          b6.readFromLine(line, "b6 ");
          b6.setDescription("Medicare tax withheld");
        } else if (line.startsWith("b7 ")) {
          b7.readFromLine(line, "b7 ");
          b7.setDescription("Social security tips");
        } else if (line.startsWith("b8 ")) {
          b8.readFromLine(line, "b8 ");
          b8.setDescription("Allocated tips");
        } else if (line.startsWith("b10 ")) {
          b10.readFromLine(line, "b10 ");
          b10.setDescription("Dependent care benefits");
        } else if (line.startsWith("b11 ")) {
          b11.readFromLine(line, "b11 ");
          b11.setDescription("Nonqualified plans");
        } else if (line.startsWith("b12 ")) {
          b12.readFromLine(line, "b12 ");
          b12.setDescription("See instrubtions for box 12");
        } else if (line.startsWith("b13 ")) {
          b13.readFromLine(line, "b13 ");
          b13.getValue().get(0).setDescription("Statutory employee");
          b13.getValue().get(1).setDescription("Retirement plan");
          b13.getValue().get(2).setDescription("Third-party sick pay");
        } else if (line.startsWith("b14 ")) {
          b14.readFromLine(line, "b14 ");
          b14.setDescription("Others");
        } else if (line.startsWith("b15 ")) {
          b15.readFromLine(line, "b15 ");
          b15.setDescription("State");
        } else if (line.startsWith("employer state id number ")) {
          bEmployerStateIdNumber.readFromLine(line, "employer state id number ");
        } else if (line.startsWith("b16 ")) {
          b16.readFromLine(line, "b16 ");
          b16.setDescription("State wages, tipc, etc.");
        } else if (line.startsWith("b17 ")) {
          b17.readFromLine(line, "b17 ");
          b17.setDescription("State income tax");
        } else if (line.startsWith("b18 ")) {
          b18.readFromLine(line, "b18 ");
          b18.setDescription("Local wages, tips, etc.");
        } else if (line.startsWith("b19 ")) {
          b19.readFromLine(line, "b19 ");
          b19.setDescription("Local income tax");
        } else if (line.startsWith("b20 ")) {
          b20.readFromLine(line, "b20 ");
          b20.setDescription("Locality name");
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
    readFromFile(TaxUtil.DATA_FOLDER + "/forms/input/w2taxyear2014.txt");
    System.out.print(this);
  }

  /** Wages, tips, other compensation. */
  public IntEntry getB1() {
    return b1;
  }

  /** Federal income tax withheld. */
  public IntEntry getB2() {
    return b2;
  }

  /** Social security wages. */
  public IntEntry getB3() {
    return b3;
  }

  /** Social security tax withheld. */
  public IntEntry getB4() {
    return b4;
  }

  /** Medicare wages and tips. */
  public IntEntry getB5() {
    return b5;
  }

  /** Medicare tax withheld. */
  public IntEntry getB6() {
    return b6;
  }

  /** Social security tips. */
  public IntEntry getB7() {
    return b7;
  }

  /** Allocated tips. */
  public IntEntry getB8() {
    return b8;
  }

  /** Dependent care benefits. */
  public IntEntry getB10() {
    return b10;
  }

  /** Nonqualified plans. */
  public IntEntry getB11() {
    return b11;
  }

  /** Annotation codes. */
  public IntListEntry getB12() {
    return b12;
  }

  /**
   * Special treatment checkboxes.
   *
   * [0] Statutory employee.
   * [1] Retirement plan.
   * [2] Thrid-party sick pay.
   */
  public BooleanListEntry getB13() {
    return b13;
  }

  /** Other */
  public IntListEntry getB14() {
    return b14;
  }

  /** State */
  public StringEntry getB15() {
    return b15;
  }

  /** Employer state ID number */
  public StringEntry getBEmployerStateIdNumber() {
    return bEmployerStateIdNumber;
  }

  /** State wages, tips, etc. */
  public IntEntry getB16() {
    return b16;
  }

  /** State income tax. */
  public IntEntry getB17() {
    return b17;
  }

  /** Local income wages, tips, etc. */
  public IntEntry getB18() {
    return b18;
  }

  /** Local income tax. */
  public IntEntry getB19() {
    return b19;
  }

  /** Locality name. */
  public StringEntry getB20() {
    return b20;
  }

  @Override
  public String toString() {
    String result = "";
    result += getFormType() + " Tax Year " + getTaxYear() + "\n";
    result += "-----------------------\n";
    result += "\n";

    result += b1.print();
    result += b2.print();
    result += "\n";

    result += "Employer's name, address, and ZIP code:\n  " + util.getEmployerAddress() + "\n";
    result += b3.print();
    result += b4.print();
    result += b5.print();
    result += b6.print();

    result += b7.print();
    result += b8.print();
    if (b7.isDirty() || b8.isDirty()) {
      result += "\n";
    }

    result += "Employer identification number (EIN):\n  "
        + util.getEmployerIdentificationNumber() + "\n";
    result += b10.print();
    result += "\n";

    result += b11.print();
    result += b13.print();
    result += "\n";

    result += b12.print();
    result += b14.print();
    result += "\n";

    result += b15.print();
    result += bEmployerStateIdNumber.print();
    result += b16.print();
    result += b17.print();
    result += b18.print();
    result += b19.print();
    result += b20.print();
    result += "\n";

    result += "-----------------------\n";

    return result;
  }
}
