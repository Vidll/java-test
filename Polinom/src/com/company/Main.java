package com.company;
import java.lang.Float;
public class Main {

    public static void main(String[] args) {
        try {
            float result = 0;
            float numberArray[] = new float[args.length];

            for (int i = 0; i < args.length; i++) {
                numberArray[i] = Float.parseFloat(args[i]);
                result += (1 / numberArray[i]) * 3;
            }
            System.out.print("Result: " + result);
        } catch (Exception x) {
            System.out.println("Invalid input");
        }
    }
}
