package Calculator;

public class RomanNumeralCalculator {
  private char placeValue;

  public RomanNumeralCalculator() {}

  /**
   * This function is the main access for the calculator. It iterates over each digit in decimalValue and adds the result
   * to romNumValue.
   *
   * @param decimalValue
   * @return the Roman Numeral conversion
   */
  public String decToRomNum(int decimalValue) {
    if (decimalValue < 0) {
      throw new IllegalArgumentException("Unable to convert negative numbers");
    }
    String romNumValue = "";
    int currValue = decimalValue;
    int furthestNum = furthestPlace(currValue);

    for (int i = 0; i < String.valueOf(decimalValue).length(); i++) {
      // if the digit is not 0
      if (placeValue != ' ') {
        romNumValue += convert(furthestNum);
      }
      currValue = removeFurthest(currValue);
      furthestNum = furthestPlace(currValue);
    }
    return romNumValue;
  }

  /**
   * Determines what calculations are needed based on the digit value.
   *
   * @param value
   * @return conversion of the digit value
   */
  private String convert(int value) {
    String conversion = "";
    if (value < 4) {
      for (int i = 0; i < value; i++) {
        conversion += placeValue;
      }
    } else if (value == 4 || value == 9) {
      conversion = subOne();
    } else if (value > 5 && value < 9) {
      conversion += placeValue;
      for (int i = 0; i < (value - 5); i++) {
        conversion += lower();
      }
    } else {
      conversion += placeValue;
    }

    return conversion;
  }

  /**
   * @return result of subtracting one from the current placeValue
   */
  private String subOne() {
    switch (placeValue) {
      case 'I':
        return "IV";
      case 'V':
        return "IX";
      case 'X':
        return "XL";
      case 'L':
        return "XC";
      case 'C':
        return "CD";
      case 'D':
        return "CM";
      default:
        return " ";
    }
  }

  /**
   * @return the letter value one below the current placeValue
   */
  private char lower() {
    switch (placeValue) {
      case 'V':
        return 'I';
      case 'X':
        return 'V';
      case 'L':
        return 'X';
      case 'C':
        return 'L';
      case 'D':
        return 'C';
      case 'M':
        return 'D';
      default:
        return ' ';
    }
  }

  /**
   * Assigns placeValue to the letter corresponding to the place of the digit furthest left of value
   *
   * @param value
   * @return the digit furthest left of the value
   */
  private int furthestPlace(int value) {
    if (value > 3999) {
      throw new IllegalArgumentException("Unable to calculate numbers larger than 3999");
    }
    if (value >= 1000) {
      placeValue = 'M';
      return value / 1000;
    } else if (value >= 500) {
      placeValue = 'D';
      return value / 100;
    } else if (value >= 100) {
      placeValue = 'C';
      return value / 100;
    } else if (value >= 50) {
      placeValue = 'L';
      return value / 10;
    } else if (value >= 10) {
      placeValue = 'X';
      return value / 10;
    } else if (value >= 5) {
      placeValue = 'V';
      return value;
    } else if (value >= 1){
      placeValue = 'I';
      return value;
    } else {
      placeValue = ' ';
      return 0;
    }
  }

  /**
   * Removes the furthest digit to the left of value
   *
   * @param value
   * @return the new value
   */
  private int removeFurthest(int value) {
    String stringValue = String.valueOf(value);
    String newStringValue = stringValue.substring(1);
    if (newStringValue.equals("")) {
      return 0;
    }
    int newValue = Integer.parseInt(newStringValue);
    return newValue;
  }
}
