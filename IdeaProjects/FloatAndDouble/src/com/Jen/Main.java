package com.Jen;

import javax.xml.bind.SchemaOutputResolver;

public class Main {

    public static void main(String[] args) {

        // Java default is double

        // width of an integer = 32 (4 bytes)
        int myIntValue = 5 / 3;

        // float has 7 digits of precision after decimal
        // width of float = 32 (4 bytes)
        float myFloatValue = 5f / 3f;  // Could write like this... (float) 5.0

        // double has 16 digits of precision after decimal
        // width of double = 64 (8 bytes)
        double myDoubleValue = 5d / 3d;
        System.out.println("myIntValue = " + myIntValue);
        System.out.println("myFloatValue = " + myFloatValue);
        System.out.println("myDoubleValue = " + myDoubleValue);


        double pounds = 200d;
        double kilograms = pounds * 0.45359237d;
        System.out.println(pounds + " pounds = " + kilograms + " kilograms");
    }
}
