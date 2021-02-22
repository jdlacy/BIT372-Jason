package com.example.unitcoverter;

public class Converter {
    public static float toCelsius(float fah) {
        return (fah - 32) * 5/9;
    }
    public static float toKiloG(float lbs) {return (lbs * (float)0.45359237); }
    public static float toML(float oz) {return (oz * (float)29.57); }
    public static float toKM(float miles) {return (miles * (float)1.60934);}
}
