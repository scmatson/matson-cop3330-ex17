package base;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Scott Matson
 */
/*
Exercise 17 - Blood Alcohol Calculator

Sometimes you have to perform a more complex calculation based on some provided inputs and then use that result to make a determination.

Create a program that prompts for your weight, gender, total alcohol consumed (in ounces), and the amount of time since your last drink.
Calculate your blood alcohol content (BAC) using this formula:   BAC = (A × 5.14 / W × r) − .015 × H

where
    A is total alcohol consumed, in ounces (oz).
    W is body weight in pounds.
    r is the alcohol distribution ratio:
        0.73 for men
        0.66 for women
    H is number of hours since the last drink.

Display whether or not it’s legal to drive by comparing the blood alcohol content to 0.08.

Example Output

Your BAC is 0.08
It is not legal for you to drive.

Constraint
-Prevent the user from entering non-numeric values.

Challenges
-Handle metric units.
-Look up the legal BAC limit by state and prompt for the state. Display a message that states whether or not it’s legal to drive based on the computed BAC.
-Develop this as a mobile application that makes it easy to record each drink, updating the BAC each time a drink is entered.

 */
public class App {

    static  Scanner ui = new Scanner(System.in);

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("##0.00");

        System.out.print("How much do you weigh? ");
        int weight = isInteger();
        ui.nextLine();

        System.out.print("What is your gender? Man or woman? ");
        String gender = isGender();
        double r;
        if(gender.equals("man"))
        {
            r = 0.73;
        }
        else
        {
            r = 0.66;
        }

        System.out.print("How much alcohol have you consumed in ounces? ");
        int alcohol = isInteger();

        System.out.print("How many hours have passed since your last drink? ");
        int time = isInteger();

        //BAC = (A × 5.14 / W × r) − .015 × H
        double BAC = ((alcohol * 5.14 / weight * r) - .015 * time);

        if(BAC > 0.08)
        {
            System.out.println("Your BAC is " + df.format(BAC) + "\nIt is not legal for you to drive.");
        }
        else if(BAC < 0)
        {
            System.out.println("Please recalculate, negative value.");
        }
        else
        {
            System.out.println("Your BAC is " + df.format(BAC) + "\nIt is legal for you to drive.");
        }
    }

    public static int isInteger()
    {
        while(true)
        {
            try
            {
                return ui.nextInt();
            }
            catch(InputMismatchException e)
            {
                ui.next();
                System.out.print("That's not an integer. Try again: ");
            }
        }
    }

    public static String isGender()
    {
        while(true)
        {
            String a = ui.nextLine();
            String b = a.toLowerCase();
            if(b.equals("man"))
            {
                return b;
            }
            else if(b.equals("woman"))
            {
                return b;
            }
            else
            {
                System.out.print("Please say 'man' or 'woman': ");
            }
        }
    }
}
