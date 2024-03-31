package Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    RomanNumeralCalculator calculator = new RomanNumeralCalculator();
    String response;

    System.out.println("Enter a number x where 0 <= x <= 3999");
    System.out.println("Enter q to quit");

    while ((response = reader.readLine()) != null) {
      if (response.equalsIgnoreCase("q")) {
        return;
      }

      try {
        int value=Integer.parseInt(response);
        System.out.println(value + " converts to " + calculator.decToRomNum(value));
      } catch (Exception e) {
        System.out.println("Invalid response. Try again.");
      }
      System.out.println();
      System.out.println("Enter a number x where 0 <= x <= 3999");
      System.out.println("Enter q to quit");
    }
  }
}
