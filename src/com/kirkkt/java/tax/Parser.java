package com.kirkkt.java.tax;

import com.kirkkt.java.tax.forms.Form;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;

/**
 * A helper class to host all static parsing logic.
 * </p> Should never be instantiated.
 */
// TODO(kirktdev): parse boolean
public final class Parser {

  private static final String GENERAL_PARSING_ERROR_MESSAGE = "Error processing line";

  private Parser() {} // COV_NF_LINE

  /**
   * Parses a line of string and round the result into int. Throws error message on error.
   *
   * @param line a line of string. This entire line will be parsed into an integer.
   */
  public static int parseAndRound(String line) {
    return parseAndRound(line, 1);
  }
  /**
   * Parses a line of string and round the result into int. Throws error message on error.
   *
   * @param line a string with components separated by {@code " "}
   * @param parts the number of components expected from this string. Only the last part, defined by
   *   the sepration of {@code " "} will be parsed and rounded.
   */
  public static int parseAndRound(String line, int parts) {
    return parseAndRound((parts == 1) ? line : line.split(" ", parts)[parts - 1], line);
  }

  /**
   * Parses a string and round the result into int. Throws error message on error.
   *
   * @param text the string to be parsed
   * @param lineContext the line containing {@param text} that can provide the context of where it
   *   is from.
   */
  public static int parseAndRound(String text, String lineContext) {
    try {
      return Math.round(Float.parseFloat(text));
    } catch (NumberFormatException e) {
      throw new NumberFormatException(
          genericParsingErrorMessage(lineContext) + "\nDetail:\n  " + e.toString());
    }
  }

  public static Map<String, Integer> parseListAndRound(String line, int parts) {
    ImmutableMap.Builder<String, Integer> builder = ImmutableMap.<String, Integer>builder();
    String toParse = line.split(" ", parts)[parts - 1];
    String[] toParseArray = toParse.split(" ");
    for (int i = 0; i < toParseArray.length; i += 2) {
      builder.put(toParseArray[i], parseAndRound(toParseArray[i + 1], line));
    }
    return builder.build();
  }

  /**
   * Parses a line of string into a boolean. Throws error message on error.
   *
   * @param line a string with components separated by {@code " "}
   * @param parts the number of components expected from this string. Only the last part, defined by
   *   the sepration of {@code " "} will be parsed.
   */
  public static boolean parseBoolean(String line, int parts) {
    return parseBoolean((parts == 1) ? line : line.split(" ", parts)[parts - 1], line);
  }

  /**
   * Parses a string into a boolean. Throws error message on error.
   *
   * @param text the string to be parsed
   * @param lineContext the line containing {@param text} that can provide the context of where it
   *   is from.
   */
  public static boolean parseBoolean(String text, String lineContext) {
    try {
      return Boolean.parseBoolean(text);
      // TODO(kirktdev): what exception are we expecting?
    } catch (NumberFormatException e) {
      throw new NumberFormatException(
          genericParsingErrorMessage(lineContext) + "\nDetail:\n  " + e.toString());
    }
  }
  /**
   * Parse a line of string into a boolean array. Throws error message on error.
   *
   * @param line a string with components separated by {@code " "}
   * @param parts the number of components expected from this string. Only the last part, defined by
   *   the sepration of {@code " "} will be parsed.
   */
  public static boolean[] parseBooleanArray(String line, int parts) {
    String toParse = (parts == 1) ? line : line.split(" ", parts)[parts - 1];
    String[] toParseArray = toParse.split(" ");
    boolean[] result = new boolean[toParseArray.length];
    try {
      for (int i = 0; i < toParseArray.length; i++) {
        result[i] = Boolean.parseBoolean(toParseArray[i]);
      }
      // TODO(kirktdev): what exception do I expect?
    } catch (NumberFormatException e) {
      throw new NumberFormatException(
          genericParsingErrorMessage(line) + "\nDetail:\n  " + e.toString());
    }
    return result;
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
