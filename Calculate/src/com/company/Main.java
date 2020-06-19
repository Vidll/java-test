package com.company;
import java.util.Scanner;
import java.lang.String;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        Calculate();
    }
    public static void Calculate(){

        float numberA,numberB;
        double result;
        String mathAction;
        try{

            Scanner scanNumber = new Scanner (System.in);
            Scanner scanAction = new Scanner (System.in);

            System.out.print("Enter first number:");
            numberA = scanNumber.nextFloat();
            System.out.print("Enter math action:");
            mathAction = scanAction.next();
            System.out.print("Enter second number:");
            numberB = scanNumber.nextFloat();

            if(mathAction.equals("+")){
                result = numberA + numberB;
                System.out.print(numberA + " " + mathAction + " " + numberB + " = " + result + "\n");
            }
            else if(mathAction.equals("-")){
                result = numberA - numberB;
                System.out.print(numberA + " " + mathAction + " " + numberB + " = " + result + "\n");
            }
            else if(mathAction.equals("*")){
                result = numberA * numberB;
                System.out.print(numberA + " " + mathAction + " " + numberB + " = " + result + "\n");
            }
            else if(mathAction.equals("/")){
                result = numberA / numberB;
                System.out.print(numberA + " " + mathAction + " " + numberB + " = " + result + "\n");
            }
            else if(mathAction.equals("^")){
                result = Math.pow(numberA,numberB);
                System.out.print(numberA + " " + mathAction + " " + numberB + " = " + result + "\n");
            }
            else{
                System.out.println("Incorrect math action");
                System.out.print("Repeat? 1(Y)/0(N)");
                if(scanNumber.nextInt() == 1) Calculate();
            }

            System.out.print("Repeat? 1(Y)/0(N)");
            if(scanNumber.nextInt() == 1) Calculate();

        }catch (Exception e) {
            System.out.println("Invalid input");
            System.out.println("Try again");
            Calculate();
        }

    }

}
