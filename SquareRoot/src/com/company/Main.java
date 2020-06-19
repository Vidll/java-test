package com.company;
import java.lang.Math;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        square();
    }

    public static void square(){
        try{
            double number,result,resultPow;
            Scanner num = new Scanner(System.in);

            System.out.print("Enter number:");
            number = num.nextDouble();
            resultPow = Math.sqrt(number);
            result = ((resultPow + (number/resultPow)) * 1/2);
            System.out.print("Result:" + result + "\n");

            System.out.print("Repeat? 1(Y)/0(N):");
            if (num.nextInt() == 1) {
                square();
            }
        } catch (Exception x){
            System.out.println("Invalid input");
            System.out.println("Try again");
            square();
        }

    }

}
