package de.tf.romanCharConverter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanCharConverterTest {
    private RomanCharConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new RomanCharConverter();
    }

    @ParameterizedTest(name = "romanString = {0}, result = {1}")
    @CsvSource({
            "I, 1",
            "V, 5",
            "X, 10",
            "L, 50",
            "C, 100",
            "D, 500",
            "M, 1000",
            "A, 5000"})
    public void testConvertOneSingleRomanNumber(String romanString, int result) {
        assertEquals(result, converter.convert(romanString));
    }

    @ParameterizedTest(name = "romanString = {0}, result = {1}")
    @CsvSource({
            "II, 2",
            "XX, 20",
            "CC, 200",
            "MM, 2000",
            "AA, 10000"})
    public void testConvertMultipleRomanNumber(String romanString, int result) {
        assertEquals(result, converter.convert(romanString));
    }

    @ParameterizedTest(name = "romanString = {0}, result = {1}")
    @CsvSource({
            "III, 3",
            "XXX, 30",
            "CCC, 300",
            "MMM, 3000",
            "MD, 1500"})
    public void testConvertMultipleRomanNumberSameChar(String romanString, int result) {
        assertEquals(result, converter.convert(romanString));
    }

    @ParameterizedTest(name = "romanString = {0}, result = {1}")
    @CsvSource({
            "IV, 4",
            "IX, 9",
            "XL, 40",
            "XC, 90",
            "CD, 400",
            "CM, 900",
            "XIV, 14"})
    public void testConvertMultipleRomanNumberSubtractChar(String romanString, int result) {
        assertEquals(result, converter.convert(romanString));
    }

    @Test
    public void givenSingleRomanChar_whenConvert_thenArabic(){
        assertEquals(10, converter.convert("X"));
        assertEquals(50, converter.convert("L"));
        assertEquals(100, converter.convert("C"));
        assertEquals(500, converter.convert("D"));
        assertEquals(1000, converter.convert("M"));
        assertEquals(5000, converter.convert("A"));
    }

    @Test
    public void givenMultipleRomanChar_whenConvert_thenArabic(){
        assertEquals(2, converter.convert("II"));
        assertEquals(20, converter.convert("XX"));
        assertEquals(200, converter.convert("CC"));
        assertEquals(2000, converter.convert("MM"));
        assertEquals(10000, converter.convert("AA"));

        assertEquals(3, converter.convert("III"));
        assertEquals(30, converter.convert("XXX"));
        assertEquals(300, converter.convert("CCC"));
        assertEquals(3000, converter.convert("MMM"));
        assertEquals(1500, converter.convert("MD"));
    }

    @Test
    public void givenMultipleRomanSubtractChar_whenConvert_thenArabic(){
        assertEquals(4, converter.convert("IV"));
        assertEquals(9, converter.convert("IX"));
        assertEquals(40, converter.convert("XL"));
        assertEquals(90, converter.convert("XC"));
        assertEquals(400, converter.convert("CD"));
        assertEquals(900, converter.convert("CM"));
        assertEquals(14, converter.convert("XIV"));
    }
}
