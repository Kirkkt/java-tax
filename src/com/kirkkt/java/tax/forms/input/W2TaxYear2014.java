package com.kirkkt.java.tax.forms.input;

import com.kirkkt.java.tax.Parser;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.IntEntry;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

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
  private ImmutableMap<String, Integer> b12 = null;
  private boolean[] b13 = new boolean[3];
  private ImmutableMap<String, Integer> b14 = null;
  private IntEntry b16 = new IntEntry();
  private IntEntry b17 = new IntEntry();
  private IntEntry b18 = new IntEntry();
  private IntEntry b19 = new IntEntry();
  private String b20 = "";

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
      // TODO(kirktdev): forbid from multiple reads
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
          String[] words = line.split(" ");
          // TODO(kirktdev): get rid of the second <> can?
          ImmutableMap.Builder<String, Integer> b12MapBuilder =
              ImmutableMap.<String, Integer>builder();
          for (int i = 1; i < words.length - 1; i += 2) {
            b12MapBuilder.put(words[i], Parser.parseAndRound(words[i + 1], 1));
          }
          b12 = b12MapBuilder.build();
        } else if (line.startsWith("b13 ")) {
          b13 = Parser.parseBooleanArray(line, 2);
        } else if (line.startsWith("b14 ")) {
          String[] words = line.split(" ");
          ImmutableMap.Builder<String, Integer> b14MapBuilder =
              ImmutableMap.<String, Integer>builder();
          for (int i = 1; i < words.length - 1; i += 2) {
            b14MapBuilder.put(words[1], Parser.parseAndRound(words[i + 1], 1));
          }
          b14 = b14MapBuilder.build();
        } else if (line.startsWith("b15 ")) {
          Preconditions.checkArgument("CA".equals(line.split(" ", 2)[1]),
              Parser.genericParsingErrorMessage(line) + "\nExpecting:\n  CA");
        } else if (line.startsWith("employer's state id no.")) {
          Preconditions.checkArgument(util.getEmployerStateIdNumber().equals(line.split(" ", 5)[4]),
              Parser.genericParsingErrorMessage(line)
                  + "\nExpecting:\n  "
                  + util.getEmployerStateIdNumber());
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
          b20 = line.split(" ", 2)[1];
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
  public ImmutableMap<String, Integer> getB12() {
    return b12;
  }

  /**
   * Special treatment checkboxes.
   *
   * [0] Statutory employee.
   * [1] Retirement plan.
   * [2] Thrid-party sick pay.
   */
  public boolean[] getB13() {
    return b13;
  }

  /** Other */
  public ImmutableMap<String, Integer> getB14() {
    return b14;
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
  public String getB20() {
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
    result += "13\n";
    result += String.format("  Statutory employee: [%s]\n", b13[0] ? "X" : " ");
    result += String.format("  Retirement plan: [%s]\n", b13[1] ? "X" : " ");
    result += String.format("  Third-party sick pay: [%s]\n", b13[2] ? "X" : " ");
    result += "\n";
    if (b11.isDirty() || b13[0] || b13[1] || b13[2]) {
      result += "\n";
    }

    if (b12 != null) {
      result += "12 See instrubtions for box 12\n";
      for (String key : b12.keySet()) {
        result += "  " + key + "\t" + b12.get(key) + "\n";
      }
    }
    if (b14 != null) {
      result += "14 Other\n";
      for (String key : b14.keySet()) {
        result += "  " + key + "\t" + b14.get(key) + "\n";
      }
    }
    if (b12 != null || b14 != null) {
      result += "\n";
    }

    result += "15 State:\n  CA\n";
    result += "Employer's state ID No.:\n  " + util.getEmployerStateIdNumber() + "\n";
    result += b16.print();
    result += b17.print();
    result += b18.print();
    result += b19.print();
    result += "20 Locality name:\n  " + b20 + "\n";
    result += "\n";

    result += "-----------------------\n";

    return result;
  }
}
