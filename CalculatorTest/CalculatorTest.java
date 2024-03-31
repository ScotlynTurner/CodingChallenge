package CalculatorTest;

import Calculator.RomanNumeralCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
  RomanNumeralCalculator calculator = new RomanNumeralCalculator();

  @Test
  public void basicValues() {
    Assertions.assertEquals("I", calculator.decToRomNum(1));
    Assertions.assertEquals("V", calculator.decToRomNum(5));
    Assertions.assertEquals("C", calculator.decToRomNum(100));
    Assertions.assertEquals("M", calculator.decToRomNum(1000));
  }

  @Test
  public void addedValues() {
    Assertions.assertEquals("III", calculator.decToRomNum(3));
    Assertions.assertEquals("XXII", calculator.decToRomNum(22));
    Assertions.assertEquals("MMMI", calculator.decToRomNum(3001));
    Assertions.assertEquals("DCCCLXVII", calculator.decToRomNum(867));
  }

  @Test
  public void subValues() {
    Assertions.assertEquals("IX", calculator.decToRomNum(9));
    Assertions.assertEquals("XIV", calculator.decToRomNum(14));
    Assertions.assertEquals("CCLXIV", calculator.decToRomNum(264));
    Assertions.assertEquals("CDXCIV", calculator.decToRomNum(494));
  }

  @Test
  public void edgeCases() {
    // Valid Cases
    Assertions.assertEquals("", calculator.decToRomNum(0));
    Assertions.assertEquals("MMMCMXCIX", calculator.decToRomNum(3999));

    // Invalid Cases
    Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.decToRomNum(-1));
    Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.decToRomNum(4000));
  }
}
