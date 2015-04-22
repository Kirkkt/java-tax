package com.kirkkt.java.tax;

import com.kirkkt.java.tax.forms.Form;

import com.google.common.base.Preconditions;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * A helper class to host all static parsing logic.
 * </p> Should never be instantiated.
 */
// TODO(kirktdev): parse boolean
public final class Parser {

  public static final String GENERAL_PARSING_ERROR_MESSAGE = "Error processing line";

  private Parser() {} // COV_NF_LINE

  /**
   * Parses a line of string and round the result into int. Throws error message on error.
   *
   * @param line a string with components separated by {@code " "}
   * @param parts the number of components expected from this string. Only the last part, defined by
   *   the sepration of {@code " "} will be parsed and rounded.
   */
  public static int parseAndRoundToInt(String line, int parts) {
    return parseAndRoundToInt((parts == 1) ? line : line.split(" ", parts)[parts - 1], line);
  }

  /**
   * Parses a string and round the result into int. Throws error message on error.
   *
   * @param text the string to be parsed
   * @param lineContext the line containing {@param text} that can provide the context of where it
   *   is from.
   */
  public static int parseAndRoundToInt(String text, String lineContext) {
    try {
      return Math.round(Float.parseFloat(text));
    } catch (NumberFormatException e) {
      throw new NumberFormatException(
          genericParsingErrorMessage(lineContext) + "\nDetail:\n  " + e.toString());
    }
  }

  /**
   * Returns a string describing a parsing error message.
   *
   * @param lineContext the string being parsed
   */
  public static String genericParsingErrorMessage(String lineContext) {
    return String.format("%s: \n  %s", GENERAL_PARSING_ERROR_MESSAGE, lineContext);
  }
}
