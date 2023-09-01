package de.tf.romanCharConverter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanCharConverterTest {
    private RomanCharConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new RomanCharConverter();
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
