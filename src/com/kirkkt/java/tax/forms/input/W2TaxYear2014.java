package com.kirkkt.java.tax.forms.input;

import com.kirkkt.java.tax.Parser;
import com.kirkkt.java.tax.TaxUtil;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class W2TaxYear2014 implements InputForm {

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
  private ImmutableMap<String, Integer> b12 = null;
  private boolean[] b13 = new boolean[3];
  private ImmutableMap<String, Integer> b14 = null;
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
      // TODO(kirktdev): forbid from multiple reads
      br = new BufferedReader(new FileReader(fileName));
      while ((line = br.readLine()) != null) {
        if (line.equals("w2 " + getTaxYear())) {
          // heading
        } else if (line.startsWith("b1 ")) {
          b1 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b2 ")) {
          b2 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b3 ")) {
          b3 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b4 ")) {
          b4 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b5 ")) {
          b5 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b6 ")) {
          b6 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b7 ")) {
          b7 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b8 ")) {
          b8 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b10 ")) {
          b10 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b11 ")) {
          b11 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b12 ")) {
          String[] words = line.split(" ");
          // TODO(kirktdev): get rid of the second <> can?
          ImmutableMap.Builder<String, Integer> b12MapBuilder =
              ImmutableMap.<String, Integer>builder();
          for (int i = 1; i < words.length - 1; i += 2) {
            b12MapBuilder.put(words[i], Parser.parseAndRoundToInt(words[i + 1], 1));
          }
          b12 = b12MapBuilder.build();
        } else if (line.startsWith("b13 ")) {
          String[] words = line.split(" ");
          // TODO(kirktdev): ImmutableList + Function can?
          // TODO(kirktdev): parseToBoolean
          b13[0] = Boolean.parseBoolean(words[1]);
          b13[1] = Boolean.parseBoolean(words[2]);
          b13[2] = Boolean.parseBoolean(words[3]);
        } else if (line.startsWith("b14 ")) {
          String[] words = line.split(" ");
          ImmutableMap.Builder<String, Integer> b14MapBuilder =
              ImmutableMap.<String, Integer>builder();
          for (int i = 1; i < words.length - 1; i += 2) {
            b14MapBuilder.put(words[1], Parser.parseAndRoundToInt(words[i + 1], 1));
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
          b16 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b17 ")) {
          b17 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b18 ")) {
          b18 = Parser.parseAndRoundToInt(line, 2);
        } else if (line.startsWith("b19 ")) {
          b19 = Parser.parseAndRoundToInt(line, 2);
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
  public int getB1() {
    return b1;
  }

  /** Federal income tax withheld. */
  public int getB2() {
    return b2;
  }

  /** Social security wages. */
  public int getB3() {
    return b3;
  }

  /** Social security tax withheld. */
  public int getB4() {
    return b4;
  }

  /** Medicare wages and tips. */
  public int getB5() {
    return b5;
  }

  /** Medicare tax withheld. */
  public int getB6() {
    return b6;
  }

  /** Social security tips. */
  public int getB7() {
    return b7;
  }

  /** Allocated tips. */
  public int getB8() {
    return b8;
  }

  /** Dependent care benefits. */
  public int getB10() {
    return b10;
  }

  /** Nonqualified plans. */
  public int getB11() {
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
  public int getB16() {
    return b16;
  }

  /** State income tax. */
  public int getB17() {
    return b17;
  }

  /** Local income wages, tips, etc. */
  public int getB18() {
    return b18;
  }

  /** Local income tax. */
  public int getB19() {
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

    result += "1 Wages, tips, other compensation:\n  " + getB1() + "\n";
    result += "2 Federal income tax withheld:\n  " + getB2() + "\n";
    result += "\n";

    result += "Employer's name, address, and ZIP code:\n  " + util.getEmployerAddress() + "\n";
    result += "3 Social security wages:\n  " + getB3() + "\n";
    result += "4 Secial security tax withheld:\n  " + getB4() + "\n";
    result += "5 Medicare wages and tips:\n  " + getB5() + "\n";
    result += "6 Medicare tax withheld:\n  " + getB6() + "\n";
    if (getB7() > 0) {
      result += "7 Social security tips:\n  " + getB7() + "\n";
    }
    if (getB8() > 0) {
      result += "8 Allocated tips:\n  " + getB8() + "\n";
    }
    if (getB7() > 0 || getB8() > 0) {
      result += "\n";
    }

    result += "Employer identification number (EIN):\n  "
        + util.getEmployerIdentificationNumber() + "\n";
    if (getB10() > 0) {
      result += "10 Dependent care benefits:\n  " + getB10() + "\n";
    }
    result += "\n";

    if (getB11() > 0) {
      result += "11 Nonqualified plans:\n  " + getB11() + "\n";
    }
    result += "13\n";
    result += String.format("  Statutory employee: [%s]\n", getB13()[0] ? "X" : " ");
    result += String.format("  Retirement plan: [%s]\n", getB13()[1] ? "X" : " ");
    result += String.format("  Third-party sick pay: [%s]\n", getB13()[2] ? "X" : " ");
    result += "\n";
    if (getB11() > 0 || getB13()[0] || getB13()[1] || getB13()[2]) {
      result += "\n";
    }

    if (getB12() != null) {
      result += "12 See instrubtions for box 12\n";
      for (String key : b12.keySet()) {
        result += "  " + key + "\t" + b12.get(key) + "\n";
      }
    }
    if (getB14() != null) {
      result += "14 Other\n";
      for (String key : b14.keySet()) {
        result += "  " + key + "\t" + b14.get(key) + "\n";
      }
    }
    if (getB12() != null || getB14() != null) {
      result += "\n";
    }

    result += "15 State:\n  CA\n";
    result += "Employer's state ID No.:\n  " + util.getEmployerStateIdNumber() + "\n";
    result += "16 State wages, tipc, etc.:\n  " + getB16() + "\n";
    result += "17 State income tax:\n  " + getB17() + "\n";
    if (getB18() > 0) {
      result += "18 Local wages, tips, etc.:\n  " + getB18() + "\n";
    }
    if (getB19() > 0) {
      result += "19 Local income tax:\n  " + getB19() + "\n";
    }
    if (!getB20().isEmpty()) {
      result += "20 Locality name:\n  " + getB20() + "\n";
    }
    result += "\n";

    result += "-----------------------\n";

    return result;
  }
}
