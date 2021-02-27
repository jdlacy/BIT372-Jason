package com.example.unitcoverter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ConverterTest {
    @Test
    public void fahrenheit_conversion_isCorrect() {assertEquals(0.0, Converter.toCelsius(32),0.01);
    }

    @Test
    public void kg_conversion_isCorrect() {
        assertEquals(45.359, Converter.toKiloG(100), 0.003);
    }

    @Test
    public void ml_conversion_isCorrect() {
        assertEquals(147.85, Converter.toML(5), .02);
    }

    @Test
    public void km_conversion_isCorrect() {
        assertEquals(19.31208, Converter.toKM(12), .02);
    }
}
