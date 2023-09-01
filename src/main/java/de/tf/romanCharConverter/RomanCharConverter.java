package de.tf.romanCharConverter;

import java.util.HashMap;

public class RomanCharConverter {

    private final HashMap<String, Integer> romanToArabic = new HashMap<String, Integer>();
    public RomanCharConverter() {
        this.romanToArabic.put("I", 1);
        this.romanToArabic.put("V", 5);
        this.romanToArabic.put("X", 10);
        this.romanToArabic.put("L", 50);
        this.romanToArabic.put("C", 100);
        this.romanToArabic.put("D", 500);
        this.romanToArabic.put("M", 1000);
        this.romanToArabic.put("A", 5000);
    }

    public int convert(String romanString) {
        int result = 0;
        for (int i = 0; i < romanString.length(); i++) {
            String romanChar = String.valueOf(romanString.charAt(i));

            if(i < romanString.length() - 1) {
                String nextRomanChar = String.valueOf(romanString.charAt(i + 1));
                if(this.romanToArabic.get(romanChar) < this.romanToArabic.get(nextRomanChar)) {
                    result -= this.romanToArabic.get(romanChar);
                    continue;
                }
            }


            result += this.romanToArabic.get(romanChar);

        }
        return result;
    }
}
