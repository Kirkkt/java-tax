package com.kirkkt.javatests.tax.forms.fillable.federal.worksheets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.kirkkt.javatests.tax.TestCase;
import com.kirkkt.javatests.tax.TestUtil;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.fillable.federal.worksheets.F1040QualifiedDividendAndCapitalGainTaxWorksheetTaxYear2014;

import com.google.common.collect.UnmodifiableIterator;

public class F1040QualifiedDividendAndCapitalGainTaxWorksheetTaxYear2014Test implements TestCase {

  @Override
  public Form getForm() {
    return new F1040QualifiedDividendAndCapitalGainTaxWorksheetTaxYear2014();
  }

  @Override
  public void test() {
    // F1040QualifiedDividendAndCapitalGainTaxWorksheetTaxYear2014 form =
    //     new F1040QualifiedDividendAndCapitalGainTaxWorksheetTaxYear2014();
    // assertEquals("F1040 Qualified Dividend And Capital Gain Tax Worksheet", form.getFormType());
    // assertEquals(2014, form.getTaxYear());

    // UnmodifiableIterator<String> input =
    //     TestUtil.getGold(TestUtil.TEST_DATA_FOLDER
    //         + "/forms/fillable/federal/worksheets/f1040qualifieddividendandcapitalgaintaxworksheettaxyear2014input.txt");
    // form.readFromMotherForm(
    //   Integer.parseInt(input.next()), //formB9b
    //   Integer.parseInt(input.next()), //formB13
    //   Integer.parseInt(input.next()) //formB43
    // );
    // assertFalse(input.hasNext());

    // UnmodifiableIterator<String> gold =
    //     TestUtil.getGold(TestUtil.TEST_DATA_FOLDER
    //         + "/forms/fillable/federal/worksheets/f1040qualifieddividendandcapitalgaintaxworksheettaxyear2014gold.txt");
    // assertEquals(gold.next(), String.valueOf(form.getB1()));
    // assertEquals(gold.next(), String.valueOf(form.getB2()));
    // assertEquals(gold.next(), String.valueOf(form.getB3()));
    // assertEquals(gold.next(), String.valueOf(form.getB4()));
    // assertEquals(gold.next(), String.valueOf(form.getB5()));
    // assertEquals(gold.next(), String.valueOf(form.getB6()));
    // assertEquals(gold.next(), String.valueOf(form.getB7()));
    // assertEquals(gold.next(), String.valueOf(form.getB8()));
    // assertEquals(gold.next(), String.valueOf(form.getB9()));
    // assertEquals(gold.next(), String.valueOf(form.getB10()));
    // assertEquals(gold.next(), String.valueOf(form.getB11()));
    // assertEquals(gold.next(), String.valueOf(form.getB12()));
    // assertEquals(gold.next(), String.valueOf(form.getB13()));
    // assertEquals(gold.next(), String.valueOf(form.getB14()));
    // assertEquals(gold.next(), String.valueOf(form.getB15()));
    // assertEquals(gold.next(), String.valueOf(form.getB16()));
    // assertEquals(gold.next(), String.valueOf(form.getB17()));
    // assertEquals(gold.next(), String.valueOf(form.getB18()));
    // assertEquals(gold.next(), String.valueOf(form.getB19()));
    // assertEquals(gold.next(), String.valueOf(form.getB20()));
    // assertEquals(gold.next(), String.valueOf(form.getB21()));
    // assertEquals(gold.next(), String.valueOf(form.getB22()));
    // assertEquals(gold.next(), String.valueOf(form.getB23()));
    // assertEquals(gold.next(), String.valueOf(form.getB24()));
    // assertEquals(gold.next(), String.valueOf(form.getB25()));
    // assertEquals(gold.next(), String.valueOf(form.getB26()));
    // assertEquals(gold.next(), String.valueOf(form.getB27()));
    // assertEquals(gold.next(), String.valueOf(form.getBResult()));
    // assertFalse(gold.hasNext());
  }
}
