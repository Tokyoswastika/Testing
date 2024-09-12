package edu.cs;

/*
  @author   DovhalKyrylo
  @project   lab1
  @class  IntegerToRoman
  @version  1.0.0
  @since 12.09.2024 - 22.00
*/

public class IntegerToRoman {
    public static String integerToRoman(int num) {
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        if (num < 1 || num > 3999) {
            return null;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(romanNumerals[i]);
            }
        }

        return result.toString();
    }
}
