package com.kirkkt.java.tax.forms.fillable.federal;

import com.kirkkt.java.tax.Parser;
import com.kirkkt.java.tax.TaxMath;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.fillable.AttachedForm;
import com.kirkkt.java.tax.forms.fillable.federal.worksheets.ItemizedDeductionsWorksheetTaxYear2014;
import com.kirkkt.java.tax.forms.input.InputForm;
import com.kirkkt.java.tax.forms.input.W2TaxYear2014;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

// TODO(kirktdev): write tests
// TODO(kirktdev): separate prod input txt and test input txt
public class F1040ScheduleATaxYear2014 implements AttachedForm, InputForm {

  private int b1 = 0;
  private int b2 = 0;
  private int b3 = 0;
  private int b4 = 0;

  private String b5Checkbox = "";
  private int b5 = 0;
  private int b6 = 0;
  private int b7 = 0;
  private Map<String, Integer> b8List = ImmutableMap.<String, Integer>of();
  private int b8 = 0;
  private int b9 = 0;

  private int b10 = 0;
  private Map<String, Integer> b11List = ImmutableMap.<String, Integer>of();
  private int b11 = 0;
  private int b12 = 0;
  private int b13 = 0;
  private int b14 = 0;
  private int b15 = 0;

  private int b16 = 0;
  private int b17 = 0;
  private int b18 = 0;
  private int b19 = 0;

  private int b20 = 0;

  private Map<String, Integer> b21List = ImmutableMap.<String, Integer>of();
  private int b21 = 0;
  private int b22 = 0;
  private Map<String, Integer> b23List = ImmutableMap.<String, Integer>of();
  private int b23 = 0;
  private int b24 = 0;
  private int b25 = 0;
  private int b26 = 0;
  private int b27 = 0;

  private Map<String, Integer> b28List = ImmutableMap.<String, Integer>of();
  private int b28 = 0;

  private boolean b29Checkbox = false;
  private int b29 = 0;
  private boolean b30 = false;

  private boolean w2Imported = false;
  private boolean fileImported = false;

  @Override
  public String getFormType() {
    return "F1040 Schedule A";
  }

  @Override
  public int getTaxYear() {
    return 2014;
  }

  @Override
  public void readFromMotherForm(Form motherForm) {
    // readFromF1040(((F1040TaxYear2014) motherForm).getB38());
  }

  @Override
  public void readFromFile(String fileName) {
    if (fileImported) {
      throw new IllegalStateException("Form " + getFormType() + " for tax year " + getTaxYear() + " can't read from multiple files.");
    }
    fileImported = true;

    BufferedReader br;
    String line;

    try {
      br = new BufferedReader(new FileReader(fileName));
      while ((line = br.readLine()) != null) {
        if (line.equals("f1040 schedule a " + getTaxYear())) {
          // heading
        } else if (line.startsWith("b1 ")) {
          b4 = Parser.parseAndRound(line, 2);
        } else if (line.startsWith("b5checkbox ")) {
          b5Checkbox = line.split(" ", 2)[1];
        } else if (line.startsWith("b6 ")) {
          b6 = Parser.parseAndRound(line, 2);
        } else if (line.startsWith("b7 ")) {
          b7 = Parser.parseAndRound(line, 2);
        } else if (line.startsWith("b8list ")) {
          b8List = Parser.parseListAndRound(line, 2);
        } else if (line.startsWith("b10 ")) {
          b10 = Parser.parseAndRound(line, 2);
        } else if (line.startsWith("b11list ")) {
          b11List = Parser.parseListAndRound(line, 2);
        } else if (line.startsWith("b12 ")) {
          b12 = Parser.parseAndRound(line, 2);
        } else if (line.startsWith("b13 ")) {
          b13 = Parser.parseAndRound(line, 2);
        } else if (line.startsWith("b14 ")) {
          b14 = Parser.parseAndRound(line, 2);
        } else if (line.startsWith("b16 ")) {
          b16 = Parser.parseAndRound(line, 2);
        } else if (line.startsWith("b17 ")) {
          b17 = Parser.parseAndRound(line, 2);
        } else if (line.startsWith("b18 ")) {
          b18 = Parser.parseAndRound(line, 2);
        } else if (line.startsWith("b20 ")) {
          b20 = Parser.parseAndRound(line, 2);
        } else if (line.startsWith("b21list ")) {
          b21List = Parser.parseListAndRound(line, 2);
        } else if (line.startsWith("b22 ")) {
          b22 = Parser.parseAndRound(line, 2);
        } else if (line.startsWith("b23list ")) {
          b23List = Parser.parseListAndRound(line, 2);
        } else if (line.startsWith("b28list ")) {
          b28List = Parser.parseListAndRound(line, 2);
        } else if (line.startsWith("b30 ")) {
          b30 = Parser.parseBoolean(line, 2);
        } else {
          br.close();
          throw new IllegalArgumentException("Invalid input line: " + line);
        }
      }
      br.close();
    } catch (IOException e) {
      throw new IllegalArgumentException("Failed to read file " + fileName + " due to error " + e);
    }

    doMath();
  }

  public void readFromF1040(int formB38) {
    b2 = formB38;
    b25 = formB38;
    b29Checkbox = formB38 > 152525;
    doMath();
  }

  public void readFromW2(W2TaxYear2014 form) {
    readFromW2(form.getB17().getValue());
  }

  public void readFromW2(int formB17) {
    w2Imported = true;
    b5 = formB17;
  }

  /** medical and dental expenses */
  public int getB1() {
    return b1;
  }

  /** Form 1040 line 38 */
  public int getB2() {
    return b2;
  }

  /** 10% of line 2 */
  public int getB3() {
    return b3;
  }

  /** 3 -1 */
  public int getB4() {
    return b4;
  }

  /** State and local tax paid */
  public int getB5() {
    return b5;
  }

  /** A value between "Income taxes" and "General sales taxes" */
  public String getB5Checkbox() {
    return b5Checkbox;
  }

  /** real estate taxes */
  public int getB6() {
    return b6;
  }

  /** personal property taxes */
  public int getB7() {
    return b7;
  }

  /** other taxes list */
  public Map<String, Integer> getB8List() {
    return b8List;
  }

  /** other taxes amount */
  public int getB8() {
    return b8;
  }

  /** 5+...+9 */
  public int getB9() {
    return b9;
  }

  /** home morgage interest and points */
  public int getB10() {
    return b10;
  }

  /** unreported home morgage interest payee info */
  public Map<String, Integer> getB11List() {
    return b11List;
  }

  /** unreported home morgage interest payee amount */
  public int getB11() {
    return b11;
  }

  /** unreported home morgage points */
  public int getB12() {
    return b12;
  }

  /** morgage insurance premiums */
  public int getB13() {
    return b13;
  }

  /* investment interest */
  public int getB14() {
    return b14;
  }

  /** 10+...+14 */
  public int getB15() {
    return b15;
  }

  /** gifts to charity by cash or check */
  public int getB16() {
    return b16;
  }

  /** gifts to charity other than by cash or check */
  public int getB17() {
    return b17;
  }

  /** gifts to charity carryover from prior year */
  public int getB18() {
    return b18;
  }

  /** 16+..+18 */
  public int getB19() {
    return b19;
  }

  /** casualty or theft loss */
  public int getB20() {
    return b20;
  }

  /** unreimbursed employee expenses list */
  public Map<String, Integer> getB21List() {
    return b21List;
  }

  /** unreimbursed employee expenses amount */
  public int getB21() {
    return b21;
  }

  /** tax preparation fees */
  public int getB22() {
    return b22;
  }

  /** other expenses list */
  public Map<String, Integer> getB23List() {
  return b23List;
  }

  /** other expenses amount */
  public int getB23() {
    return b23;
  }

  /** 21+...+23 */
  public int getB24() {
    return b24;
  }

  /** form 1040 line 38 */
  public int getB25() {
    return b25;
  }

  /** 2% of 25 */
  public int getB26() {
    return b26;
  }

  /** 26-24 */
  public int getB27() {
    return b27;
  }

  /** other list */
  public Map<String, Integer> getB28List() {
    return b28List;
  }

  /** other amount */
  public int getB28() {
    return b28;
  }

  /** form 1040 line 28 > 152535? */
  public boolean getB29Checkbox() {
    return b29Checkbox;
  }

  /** total itemized deductions */
  public int getB29() {
    return b29;
  }

  /** force itemized deductions */
  public boolean getB30() {
    return b30;
  }

  @Override
  public void prod() {
    F1040ScheduleATaxYear2014 form = new F1040ScheduleATaxYear2014();
    // TODO(kirktdev): init
    System.out.println(form);
  }

  @Override
  public String toString() {
    String result = "";

    result += getFormType() + " Tax Year " + getTaxYear() + "\n";
    result += "-----------------------\n";
    result += "\n";

    if (getB1() > 0) {
      result += "b1:\n  " + getB1() + "\n";
    }
    if (getB2() > 0) {
      result += "b2:\n  " + getB2() + "\n";
    }
    if (getB3() > 0) {
      result += "b3:\n  " + getB3() + "\n";
    }
    if (getB4() > 0) {
      result += "b4:\n  " + getB4() + "\n";
    }
    result += "\n";

    result += "b5 checkbox:\n  " + getB5Checkbox() + "\n";
    result += "b5:\n  " + getB5() + "\n";
    if (getB6() > 0) {
      result += "b6:\n  " + getB6() + "\n";
    }
    if (getB7() > 0) {
      result += "b7:\n  " + getB7() + "\n";
    }
    if (!getB8List().isEmpty()) {
      // result += "b8: list\n  " + Printer.print(getB8List()) + "\n";
    }
    if (getB8() > 0) {
      result += "b8:\n  " + getB8() + "\n";
    }
    result += "b9:\n  " + getB9() + "\n";
    result += "\n";

    if (getB10() > 0) {
      result += "b10:\n  " + getB10() + "\n";
    }
    if (!getB11List().isEmpty()) {
      // result += "b11 list:\n" + Printer.print(getB11List()) + "\n";
    }
    if (getB11() > 0) {
      result += "b11:\n  " + getB11() + "\n";
    }
    if (getB12() > 0) {
      result += "b12:\n  " + getB12() + "\n";
    }
    if (getB13() > 0) {
      result += "b13:\n  " + getB13() + "\n";
    }
    if (getB14() > 0) {
      result += "b14:\n  " + getB14() + "\n";
    }
    if (getB15() > 0) {
      result += "b15:\n  " + getB15() + "\n";
    }
    result += "\n";

    if (getB16() > 0) {
      result += "b16:\n  " + getB16() + "\n";
    }
    if (getB17() > 0) {
      result += "b17:\n  " + getB17() + "\n";
    }
    if (getB18() > 0) {
      result += "b18:\n  " + getB18() + "\n";
    }
    if (getB19() > 0) {
      result += "b19:\n  " + getB19() + "\n";
    }
    result += "\n";

    if (getB20() > 0) {
      result += "b20:\n  " + getB20() + "\n";
    }
    result += "\n";

    if (!getB21List().isEmpty()) {
      // result += "b21 list:\n  " + Printer.print(getB21List()) + "\n";
    }
    if (getB21() > 0) {
      result += "b21:\n  " + getB21() + "\n";
    }
    if (getB22() > 0) {
      result += "b22:\n  " + getB22() + "\n";
    }
    if (!getB23List().isEmpty()) {
      // result += "b23 list:\n  " + Printer.print(getB23List()) + "\n";
    }
    if (getB23() > 0) {
      result += "b23:\n  " + getB23() + "\n";
    }
    if (getB24() > 0) {
      result += "b24:\n  " + getB24() + "\n";
    }
    if (getB25() > 0) {
      result += "b25:\n  " + getB25() + "\n";
    }
    if (getB26() > 0) {
      result += "b26:\n  " + getB26() + "\n";
    }
    if (getB27() > 0) {
      result += "b27:\n  " + getB27() + "\n";
    }
    result += "\n";

    if (!getB28List().isEmpty()) {
      // result += "b28 list:\n  " + Printer.print(getB28List()) + "\n";
    }
    if (getB28() > 0) {
      result += "b28:\n  " + getB28() + "\n";
    }
    result += "\n";

    result += "b29 checkbox:\n  " + getB29Checkbox() + "\n";
    result += "b29:\n  " + getB29() + "\n";
    if (getB30()) {
      result += "b30:\n  X\n";
    }

    result += "-----------------------\n";
    return result;
  }

  private void doMath() {
    b3 = Math.round(.1f * b2);
    b4 = Math.max(0, b1 - b3);

    b8 = TaxMath.getSum(b8List);
    b9 = b5 + b6 + b7 + b8;

    b11 = TaxMath.getSum(b11List);
    b15 = b10 + b11 + b12 + b13 + b14;

    b19 = b16 + b17 + b18;

    b21 = TaxMath.getSum(b21List);
    b23 = TaxMath.getSum(b23List);
    b24 = b21 + b22 + b23;
    b26 = Math.round(.02f * b25);
    b27 = Math.max(b24 - b26, 0);
    b28 = TaxMath.getSum(b28List);

    if (!b29Checkbox) {
      b29 = b4 + b9 + b15 + b19 + b20 + b27 + b28;
    } else {
      ItemizedDeductionsWorksheetTaxYear2014 worksheet =
          new ItemizedDeductionsWorksheetTaxYear2014();
      worksheet.readFromMotherForm(this);
      b29 = worksheet.getBResult();
    }
  }

}
