package com.kirkkt.java.tax.forms.fillable.federal;

import com.kirkkt.java.tax.Parser;
import com.kirkkt.java.tax.TaxMath;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.BooleanEntry;
import com.kirkkt.java.tax.forms.IntEntry;
import com.kirkkt.java.tax.forms.StringEntry;
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

  private IntEntry b1 = new IntEntry();
  private IntEntry b2 = new IntEntry();
  private IntEntry b3 = new IntEntry();
  private IntEntry b4 = new IntEntry();

  private StringEntry b5Checkbox = new StringEntry();
  private IntEntry b5 = new IntEntry();
  private IntEntry b6 = new IntEntry();
  private IntEntry b7 = new IntEntry();
  private Map<String, Integer> b8List = ImmutableMap.<String, Integer>of();
  private IntEntry b8 = new IntEntry();
  private IntEntry b9 = new IntEntry();

  private IntEntry b10 = new IntEntry();
  private Map<String, Integer> b11List = ImmutableMap.<String, Integer>of();
  private IntEntry b11 = new IntEntry();
  private IntEntry b12 = new IntEntry();
  private IntEntry b13 = new IntEntry();
  private IntEntry b14 = new IntEntry();
  private IntEntry b15 = new IntEntry();

  private IntEntry b16 = new IntEntry();
  private IntEntry b17 = new IntEntry();
  private IntEntry b18 = new IntEntry();
  private IntEntry b19 = new IntEntry();

  private IntEntry b20 = new IntEntry();

  private Map<String, Integer> b21List = ImmutableMap.<String, Integer>of();
  private IntEntry b21 = new IntEntry();
  private IntEntry b22 = new IntEntry();
  private Map<String, Integer> b23List = ImmutableMap.<String, Integer>of();
  private IntEntry b23 = new IntEntry();
  private IntEntry b24 = new IntEntry();
  private IntEntry b25 = new IntEntry();
  private IntEntry b26 = new IntEntry();
  private IntEntry b27 = new IntEntry();

  private Map<String, Integer> b28List = ImmutableMap.<String, Integer>of();
  private IntEntry b28 = new IntEntry();

  private BooleanEntry b29Checkbox = new BooleanEntry();
  private IntEntry b29 = new IntEntry();
  private BooleanEntry b30 = new BooleanEntry();

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
          b1.readFromLine(line, "b1 ");
        } else if (line.startsWith("b5checkbox ")) {
          b5Checkbox.readFromLine(line , "b5checkbox ");
        } else if (line.startsWith("b6 ")) {
          b6.readFromLine(line, "b6 ");
        } else if (line.startsWith("b7 ")) {
          b7.readFromLine(line, "b7 ");
        } else if (line.startsWith("b8list ")) {
          b8List = Parser.parseListAndRound(line, 2);
        } else if (line.startsWith("b10 ")) {
          b10.readFromLine(line, "b10 ");
        } else if (line.startsWith("b11list ")) {
          b11List = Parser.parseListAndRound(line, 2);
        } else if (line.startsWith("b12 ")) {
          b12.readFromLine(line, "b12 ");
        } else if (line.startsWith("b13 ")) {
          b13.readFromLine(line, "b13 ");
        } else if (line.startsWith("b14 ")) {
          b14.readFromLine(line, "b14 ");
        } else if (line.startsWith("b16 ")) {
          b16.readFromLine(line, "b16 ");
        } else if (line.startsWith("b17 ")) {
          b17.readFromLine(line, "b17 ");
        } else if (line.startsWith("b18 ")) {
          b18.readFromLine(line, "b18 ");
        } else if (line.startsWith("b20 ")) {
          b20.readFromLine(line, "b20 ");
        } else if (line.startsWith("b21list ")) {
          b21List = Parser.parseListAndRound(line, 2);
        } else if (line.startsWith("b22 ")) {
          b22.readFromLine(line, "b22 ");
        } else if (line.startsWith("b23list ")) {
          b23List = Parser.parseListAndRound(line, 2);
        } else if (line.startsWith("b28list ")) {
          b28List = Parser.parseListAndRound(line, 2);
        } else if (line.startsWith("b30 ")) {
          b30.readFromLine(line, "b30 ");
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
    b2.setValue(formB38);
    b25.setValue(formB38);
    b29Checkbox.setValue(formB38 > 152525);
    doMath();
  }

  public void readFromW2(W2TaxYear2014 form) {
    readFromW2(form.getB17().getValue());
  }

  public void readFromW2(int formB17) {
    w2Imported = true;
    b5.setValue(formB17);
  }

  /** medical and dental expenses */
  public IntEntry getB1() {
    return b1;
  }

  /** Form 1040 line 38 */
  public IntEntry getB2() {
    return b2;
  }

  /** 10% of line 2 */
  public IntEntry getB3() {
    return b3;
  }

  /** 3 -1 */
  public IntEntry getB4() {
    return b4;
  }

  /** State and local tax paid */
  public IntEntry getB5() {
    return b5;
  }

  /** A value between "Income taxes" and "General sales taxes" */
  public StringEntry getB5Checkbox() {
    return b5Checkbox;
  }

  /** real estate taxes */
  public IntEntry getB6() {
    return b6;
  }

  /** personal property taxes */
  public IntEntry getB7() {
    return b7;
  }

  /** other taxes list */
  public Map<String, Integer> getB8List() {
    return b8List;
  }

  /** other taxes amount */
  public IntEntry getB8() {
    return b8;
  }

  /** 5+...+9 */
  public IntEntry getB9() {
    return b9;
  }

  /** home morgage interest and points */
  public IntEntry getB10() {
    return b10;
  }

  /** unreported home morgage interest payee info */
  public Map<String, Integer> getB11List() {
    return b11List;
  }

  /** unreported home morgage interest payee amount */
  public IntEntry getB11() {
    return b11;
  }

  /** unreported home morgage points */
  public IntEntry getB12() {
    return b12;
  }

  /** morgage insurance premiums */
  public IntEntry getB13() {
    return b13;
  }

  /* investment interest */
  public IntEntry getB14() {
    return b14;
  }

  /** 10+...+14 */
  public IntEntry getB15() {
    return b15;
  }

  /** gifts to charity by cash or check */
  public IntEntry getB16() {
    return b16;
  }

  /** gifts to charity other than by cash or check */
  public IntEntry getB17() {
    return b17;
  }

  /** gifts to charity carryover from prior year */
  public IntEntry getB18() {
    return b18;
  }

  /** 16+..+18 */
  public IntEntry getB19() {
    return b19;
  }

  /** casualty or theft loss */
  public IntEntry getB20() {
    return b20;
  }

  /** unreimbursed employee expenses list */
  public Map<String, Integer> getB21List() {
    return b21List;
  }

  /** unreimbursed employee expenses amount */
  public IntEntry getB21() {
    return b21;
  }

  /** tax preparation fees */
  public IntEntry getB22() {
    return b22;
  }

  /** other expenses list */
  public Map<String, Integer> getB23List() {
  return b23List;
  }

  /** other expenses amount */
  public IntEntry getB23() {
    return b23;
  }

  /** 21+...+23 */
  public IntEntry getB24() {
    return b24;
  }

  /** form 1040 line 38 */
  public IntEntry getB25() {
    return b25;
  }

  /** 2% of 25 */
  public IntEntry getB26() {
    return b26;
  }

  /** 26-24 */
  public IntEntry getB27() {
    return b27;
  }

  /** other list */
  public Map<String, Integer> getB28List() {
    return b28List;
  }

  /** other amount */
  public IntEntry getB28() {
    return b28;
  }

  /** form 1040 line 28 > 152535? */
  public BooleanEntry getB29Checkbox() {
    return b29Checkbox;
  }

  /** total itemized deductions */
  public IntEntry getB29() {
    return b29;
  }

  /** force itemized deductions */
  public BooleanEntry getB30() {
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

    result += b1.print();
    result += b2.print();
    result += b3.print();
    result += b4.print();
    result += "\n";

    result += b5Checkbox.print();
    result += b5.print();
    result += b6.print();
    result += b7.print();
    if (!getB8List().isEmpty()) {
      // result += "b8: list\n  " + Printer.print(getB8List()) + "\n";
    }
    result += b8.print();
    result += "b9:\n  " + getB9() + "\n";
    result += "\n";

    result += b10.print();
    if (!getB11List().isEmpty()) {
      // result += "b11 list:\n" + Printer.print(getB11List()) + "\n";
    }
    result += b11.print();
    result += b12.print();
    result += b13.print();
    result += b14.print();
    result += b15.print();
    result += "\n";

    result += b16.print();
    result += b17.print();
    result += b18.print();
    result += b19.print();
    result += "\n";

    result += b20.print();
    result += "\n";

    if (!getB21List().isEmpty()) {
      // result += "b21 list:\n  " + Printer.print(getB21List()) + "\n";
    }
    result += b21.print();
    result += b22.print();
    if (!getB23List().isEmpty()) {
      // result += "b23 list:\n  " + Printer.print(getB23List()) + "\n";
    }
    result += b23.print();
    result += b24.print();
    result += b25.print();
    result += b26.print();
    result += b27.print();
    result += "\n";

    if (!getB28List().isEmpty()) {
      // result += "b28 list:\n  " + Printer.print(getB28List()) + "\n";
    }
    result += b28.print();
    result += "\n";

    result += b29Checkbox.print();
    result += "b29:\n  " + getB29() + "\n";
    result += b30.print();

    result += "-----------------------\n";
    return result;
  }

  private void doMath() {
    if (b2.getValue() > 0) {
      b3.setValue(Math.round(.1f * b2.getValue()));
    }
    if (b1.getValue() != b3.getValue()) {
      b4.setValue(Math.max(0, b1.getValue() - b3.getValue()));
    }

    if (TaxMath.getSum(b8List) > 0) {
      b8.setValue(TaxMath.getSum(b8List));
    }
    b9.setValue(b5.getValue() + b6.getValue() + b7.getValue() + b8.getValue());

    if (TaxMath.getSum(b11List) > 0) {
      b11.setValue(TaxMath.getSum(b11List));
    }
    b15.setValue(b10.getValue() + b11.getValue() + b12.getValue() + b13.getValue()
        + b14.getValue());

    b19.setValue(b16.getValue() + b17.getValue() + b18.getValue());

    if (TaxMath.getSum(b21List) > 0) {
      b21.setValue(TaxMath.getSum(b21List));
    }
    if (TaxMath.getSum(b23List) > 0) {
      b23.setValue(TaxMath.getSum(b23List));
    }
    b24.setValue(b21.getValue() + b22.getValue() + b23.getValue());
    if (b25.getValue() > 0) {
      b26.setValue(Math.round(.02f * b25.getValue()));
    }
    b27.setValue(Math.max(b24.getValue() - b26.getValue(), 0));
    if (TaxMath.getSum(b28List) > 0) {
      b28.setValue(TaxMath.getSum(b28List));
    }

    if (!b29Checkbox.getValue()) {
      b29.setValue(b4.getValue() + b9.getValue() + b15.getValue() + b19.getValue()
          + b20.getValue() + b27.getValue() + b28.getValue());
    } else {
      ItemizedDeductionsWorksheetTaxYear2014 worksheet =
          new ItemizedDeductionsWorksheetTaxYear2014();
      worksheet.readFromMotherForm(this);
      b29.setValue(worksheet.getBResult());
    }
  }

}
