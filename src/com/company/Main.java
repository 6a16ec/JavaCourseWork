package com.company;

import java.io.Serial;

public class Main {

    public static void main(String[] args) {
        Complex num1 = new Complex(1, +50);
//        Complex num1 = new Complex();
        Complex num2 = new Complex(1, -50);
//        num1.multiplication(num2);
//        System.out.println(num1);

        Complex heh = Complex.subtraction(num1, num2);
        System.out.println(heh);
        num1.subtraction(num2);
        System.out.println(num1);
    }
}
