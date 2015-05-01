package com.kirkkt.java.tax.forms.input;

import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.Parser;
import com.kirkkt.java.tax.forms.IntEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class F1099DivTaxYear2014 implements InputForm {

  private String payerName = "";
  private IntEntry b1a = new IntEntry();
  private IntEntry b1b = new IntEntry();
  private IntEntry b2a = new IntEntry();
  private IntEntry b2b = new IntEntry();
  private IntEntry b3 = new IntEntry();
  private IntEntry b4 = new IntEntry();
  private IntEntry b6 = new IntEntry();
  private IntEntry b10 = new IntEntry();
  private IntEntry b11 = new IntEntry();
  private String b12 = "";
  private String b13 = "";
  private IntEntry b14 = new IntEntry();

  private final TaxUtil util = new TaxUtil();

  public F1099DivTaxYear2014() {}

  @Override
  public String getFormType() {
    return "F1099DIV";
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
        if (line.equals("f1099div " + getTaxYear())) {
          // heading
        } else if (line.startsWith("payer name ")) {
          payerName = line.split(" ", 3)[2];
        } else if (line.startsWith("b1a ")) {
          b1a.readFromLine(line, "b1a ");
          b1a.setDescription("Total ordinary dividends");
        } else if (line.startsWith("b1b ")) {
          b1b.readFromLine(line, "b1b ");
          b1b.setDescription("Qualified dividends");
        } else if (line.startsWith("b2a ")) {
          b2a.readFromLine(line, "b2a ");
          b2a.setDescription("Total capital gain distribution");
        } else if (line.startsWith("b2b ")) {
          b2b.readFromLine(line, "b2b ");
          b2b.setDescription("Unrecapitalized section 1250 gain");
        } else if (line.startsWith("b3 ")) {
          b3.readFromLine(line, "b3 ");
          b3.setDescription("Nondividend distributions");
        } else if (line.startsWith("b4 ")) {
          b4.readFromLine(line, "b4 ");
          b4.setDescription("Federal income tax withheld");
        } else if (line.startsWith("b6 ")) {
          b6.readFromLine(line, "b6 ");
          b6.setDescription("Foreign tax paid");
        } else if (line.startsWith("b10 ")) {
          b10.readFromLine(line, "b10 ");
          b10.setDescription("Exempty-interest dividends");
        } else if (line.startsWith("b11 ")) {
          b11.readFromLine(line, "b11 ");
          b11.setDescription("Specified private activity bond interest dividends");
        } else if (line.startsWith("b12 ")) {
          b12 = line.split(" ", 2)[1];
        } else if (line.startsWith("b13 ")) {
          b13 = line.split(" ", 2)[1];
        } else if (line.startsWith("b14 ")) {
          b14.readFromLine(line, "b14 ");
          b14.setDescription("State tax withheld");
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
    readFromFile(TaxUtil.DATA_FOLDER + "/forms/input/f1099divtaxyear2014.txt");
    System.out.print(this);
  }

  /** Payer name, i.e. Vanguard. */
  public String getPayerName() {
    return payerName;
  }

  /** Total ordinary dividends. */
  public IntEntry getB1a() {
    return b1a;
  }

  /** Qualified dividends. */
  public IntEntry getB1b() {
    return b1b;
  }

  /** Total capital gain distr. */
  public IntEntry getB2a() {
    return b2a;
  }

  /** Unrecap. Sec 1250 gain. */
  public IntEntry getB2b() {
    return b2b;
  }

  /** Nondividend distributions. */
  public IntEntry getB3() {
    return b3;
  }

  /** Fedelal income tax withheld. */
  public IntEntry getB4() {
    return b4;
  }

  /** Foreign tax paid. */
  public IntEntry getB6() {
    return b6;
  }

  /** Exempt-interest dividends. */
  public IntEntry getB10() {
    return b10;
  }

  /** Specified private activity bond interest dividends. */
  public IntEntry getB11() {
    return b11;
  }

  /** State */
  public String getB12() {
    return b12;
  }

  /** State identification no. */
  public String getB13() {
    return b13;
  }

  /** State tax withheld. */
  public IntEntry getB14() {
    return b14;
  }

  @Override
  public String toString() {
    String result = "";
    result += getFormType() + " Tax Year " + getTaxYear() + "\n";
    result += "-----------------------\n";
    result += "\n";

    result += "Payer's name\n  " + getPayerName() + "\n";
    result += "\n";

    result += getB1a().print();
    result += getB1b().print();
    result += getB2a().print();
    result += getB2b().print();
    result += getB3().print();
    result += getB4().print();
    result += getB6().print();
    result += getB10().print();
    result += getB11().print();
    if (!getB12().isEmpty()) {
      result += "12 State\n  " + getB12() + "\n";
    }
    if (!getB13().isEmpty()) {
      result += "13 State identification number\n  " + getB13() +"\n";
    }
    result += getB14().print();
    result += "\n";

    result += "-----------------------\n";

    return result;
  }
}
