package com.kirkkt.java.tax.forms.input;

import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.Parser;
import com.kirkkt.java.tax.forms.Form;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class F1099DivTaxYear2014 implements Form {

  private String payerName = "";
  private int b1a = 0;
  private int b1b = 0;
  private int b2a = 0;
  private int b2b = 0;
  private int b3 = 0;
  private int b4 = 0;
  private int b6 = 0;
  private int b10 = 0;
  private int b11 = 0;
  private String b12 = "";
  private String b13 = "";
  private int b14 = 0;

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
          b1a = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b1b ")) {
          b1b = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b2a ")) {
          b2a = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b2b ")) {
          b2b = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b3 ")) {
          b3 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b4 ")) {
          b4 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b6 ")) {
          b6 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b10 ")) {
          b10 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b11 ")) {
          b11 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b12 ")) {
          b12 = line.split(" ", 2)[1];
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
    } catch (IOException e) {
      throw new IllegalArgumentException("Failed to read file " + fileName + " due to error " + e);
    }
  }

  /** Payer name, i.e. Vanguard. */
  public String getPayerName() {
    return payerName;
  }

  /** Total ordinary dividends. */
  public int getB1a() {
    return b1a;
  }

  /** Qualified dividends. */
  public int getB1b() {
    return b1b;
  }

  /** Total capital gain distr. */
  public int getB2a() {
    return b2a;
  }

  /** Unrecap. Sec 1250 gain. */
  public int getB2b() {
    return b2b;
  }

  /** Nondividend distributions. */
  public int getB3() {
    return b3;
  }

  /** Fedelal income tax withheld. */
  public int getB4() {
    return b4;
  }

  /** Foreign tax paid. */
  public int getB6() {
    return b6;
  }

  /** Exempt-interest dividends. */
  public int getB10() {
    return b10;
  }

  /** Specified private activity bond interest dividends. */
  public int getB11() {
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
  public int getB14() {
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

    result += "1a Total ordinary dividends\n  " + getB1a() + "\n";
    result += "1b Qualified dividends\n  " + getB1b() + "\n";
    result += "2a Total capital gain distribution\n  " + getB2a() + "\n";
    if (getB2b() > 0) {
      result += "2b Unrecapitalized section 1250 gain\n  " + getB2b() + "\n";
    }
    if (getB3() > 0) {
      result += "3 Nondividend distributions\n  " + getB3() + "\n";
    }
    if (getB4() > 0) {
      result += "4 Federal income tax withheld\n  " + getB4() + "\n";
    }
    if (getB6() > 0) {
      result += "6 Foreign tax paid\n  " + getB6() + "\n";
    }
    if (getB10() > 0) {
      result += "10 Exempty-interest dividends\n  " + getB10() + "\n";
    }
    if (getB11() > 0) {
      result += "11 Specified private activity bond interest dividends\n " + getB11() + "\n";
    }
    if (!getB12().isEmpty()) {
      result += "12 State\n  " + getB12() + "\n";
    }
    if (!getB13().isEmpty()) {
      result += "13 State identification number\n  " + getB13() +"\n";
    }
    if (getB14() > 0) {
      result += "14 State tax withheld\n  " + getB14() + "\n";
    }
    result += "\n";

    result += "\n";

    return result;
  }

  public static void main(String[] args) {
    F1099DivTaxYear2014 form = new F1099DivTaxYear2014();
    form.readFromFile(TaxUtil.DATA_FOLDER + "/forms/input/1099divtaxyear2014.txt");
    System.out.print(form);
  }
}
