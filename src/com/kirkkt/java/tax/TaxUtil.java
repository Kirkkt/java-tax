package com.kirkkt.java.tax;

import com.kirkkt.java.tax.forms.Form;

import com.google.common.base.Preconditions;

import java.io.BufferedReader;
import java.io.FileReader;

// TODO(kirktdev): singleton?
public final class TaxUtil {

  // TODO(kirktdev): relative path can?
  public static final String DATA_FOLDER =
      "/Users/kirkt/Dropbox/vim_notes/java_programs/data/com/kirkkt/java/tax";

  private String checkingAccountRoutingNumber;
  private String checkingAccountAccountNumber;
  private String checkingAccountAccountType;
  private String employerIdentificationNumber;
  private String employerAddress;
  private String employerStateIdNumber;

  public TaxUtil() {
    BufferedReader br;
    String line;
    String fileName = DATA_FOLDER + "/common.txt";
    try {
      br = new BufferedReader(new FileReader(fileName));
      while ((line = br.readLine()) != null) {
        if (line.equals("common")) {
          // heading
        } else if (line.startsWith("checking account routing number ")) {
          checkingAccountRoutingNumber = line.split(" ", 5)[4];
        } else if (line.startsWith("checking account account number ")) {
          checkingAccountAccountNumber = line.split(" ", 5)[4];
        } else if (line.startsWith("checking account account type ")) {
          checkingAccountAccountType = line.split(" ", 5)[4];
        } else if (line.startsWith("employer identification number ")) {
          employerIdentificationNumber = line.split(" ", 4)[3];
        } else if (line.startsWith("employer address ")) {
          employerAddress = line.split(" ", 3)[2];
        } else if (line.startsWith("employer state id number ")) {
          employerStateIdNumber = line.split(" ", 5)[4];
        } else {
          br.close();
          throw new IllegalArgumentException("Invalid input line: " + line);
        }
      }
      br.close();
    } catch (Exception e) {
      throw new IllegalArgumentException("Failed to read file " + fileName + " due to error " + e);
    }
  }

  public String getCheckingAccountRoutingNumber() {
    return checkingAccountRoutingNumber;
  }

  public String getCheckingAccountAccountNumber() {
    return checkingAccountAccountNumber;
  }

  public String getCheckingAccountAccountType() {
    return checkingAccountAccountType;
  }

  public String getEmployerIdentificationNumber() {
    return employerIdentificationNumber;
  }

  public String getEmployerAddress() {
    return employerAddress;
  }

  public String getEmployerStateIdNumber() {
    return employerStateIdNumber;
  }

  public static void checkInput(boolean expression, String lineHeading, String fileName) {
    Preconditions.checkArgument(expression,
        "Invalid input at line starting with " + lineHeading + " in file " + fileName);
  }

  public static String[] parseInputList(String input, String lineHeading, String fileName) {
    String[] inputList = null;
    try {
      inputList = input.split(" ");
      Preconditions.checkArgument((inputList.length & 1) == 0,
          "An input list must have even number of items.");
      for (int i = 0; i < inputList.length; i += 2) {
        Double.parseDouble(inputList[i + 1]);
      }
    } catch (Exception e) {
      throw new IllegalArgumentException(
          "Exception when parsing input list from line starting with " + lineHeading
          + " in file " + fileName
          + "\nException details:\n" + e);
    } finally {
      return inputList;
    }
  }

  public static int getSumFromInputList(String inputList, String variableName, String className) {
    return getSumFromInputList(inputList.split("\n"), variableName, className);
  }

  public static int getSumFromInputList(String[] inputList, String variableName, String className) {
    double result = 0;
    try {
      Preconditions.checkArgument((inputList.length & 1) == 0,
          "An input list must have even number of items.");
      for (int i = 0; i < inputList.length; i += 2) {
        result += Double.parseDouble(inputList[i + 1]);
      }
    } catch (Exception e) {
      throw new IllegalArgumentException(
          "Exception when summing the value of the input list " + variableName
          + " in className " + className
          + "\nException details:\n" + e);
    } finally {
      return round(result);
    }
  }

  public static int round(double a) {
    return (int)(a + .5);
  }

  public static String additionalLogicNeededString(Form form) {
    return "Additional logic needed for form "
        + form.getFormType() + " of tax year "
        + form.getTaxYear() + ".";
  }

  public static String additionalLogicNeededString(Form form, String line) {
    return "Additional logic needed for form "
        + form.getFormType() + " of tax year "
        + form.getTaxYear() + " on line "
        + line + ".";
  }
}
