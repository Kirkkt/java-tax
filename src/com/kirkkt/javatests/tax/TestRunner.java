package com.kirkkt.javatests.tax;

import com.kirkkt.javatests.tax.forms.input.W2TaxYear2014Test;

import com.google.common.collect.ImmutableList;

public class TestRunner {

  public static void main(String[] args) {
    new TestRunner();
  }

  private TestRunner() {
    ImmutableList<TestCase> testCases = ImmutableList.<TestCase>of(
      new W2TaxYear2014Test()
    );

    for (TestCase testCase : testCases) {
      try {
        testCase.test();
      } catch (Exception e) {
        // Ensure all tests are run despite some may fail
        // TODO(kirktdev): tostring() necessary?
        System.out.println(e.toString());
      }
    }
  }
}
