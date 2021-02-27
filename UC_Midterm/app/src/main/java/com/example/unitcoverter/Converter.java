package com.example.unitcoverter;

public class Converter {
    public static double toCelsius(double fah) {return (fah - 32) * 5/9;}
    public static double toKiloG(double lbs) {return (lbs * 0.45359237);}
    public static double toML(double oz) {return (oz * 29.57);}
    public static double toKM(double miles) {return (miles * 1.60934);}
}
