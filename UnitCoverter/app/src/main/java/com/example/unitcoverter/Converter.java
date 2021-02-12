package com.example.unitcoverter;

public class Converter {
    public static float toCelcius(float fah) {
        return (fah - 32) * 5/9;
    }
    public static float toKiloG(float lbs) {return (lbs * (float)0.45359237); }
}
