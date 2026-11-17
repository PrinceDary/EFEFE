/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication5;

import java.util.Scanner;

/**
 *
 * @author MEJILLANO_CPE113
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter("[,\\s]+");

        System.out.println("Please select among the following: ");
        System.out.println("Problem 1. Find Average");
        System.out.println("Problem 2. Find number of passers using loop");
        System.out.println("Problem 3. Find number of passers using recursion");
        System.out.println("Problem 4. ");

        int choice = input.nextInt();
        switch (choice) {

            case 1:
                System.out.println("How many numbers?");
                int count = input.nextInt();

                int array[] = new int[count];
                for (int i = 0; i < count; i++) {
                    System.out.println("Enter number " + (i + 1) + ": ");
                    array[i] = input.nextInt();
                }
                int total = 0;

                for (int i = 0; i < count; i++) {
                    total = total + array[i];
                }

                System.out.println("Average: " + computeAverage(total, count));
                break;

            case 2:
                System.out.println("How many numbers? ");
                int count2 = input.nextInt();
                int grades [] = new int [count2];
                int passingMark = 75;
                
                for (int i = 0; i < count2; i++) {
                    System.out.println("Enter number " + (i + 1) + ": ");
                    grades[i] = input.nextInt();
                }
                
                System.out.println(countPassing (grades, passingMark));
                break;
                
            case 3:
                System.out.println("How many numbers? ");
                int count3 = input.nextInt();
                int grades2 [] = new int [count3];
                int passingMark2 = 75;
                
                for (int i = 0; i < count3; i++) {
                    System.out.println("Enter number " + (i + 1) + ": ");
                    grades2[i] = input.nextInt();
                }
                
                System.out.println(countPassingRecursive (grades2, passingMark2, 0));
                break;
        }
    }

    static double computeAverage(int total, int count) {
        if (count <= 0) {
            return 0.0;
        }
        return (double) total / count;
    }
    /*
QUESTIONS:
1. Why does the method need the word double (or a cast) in the return?
    Without the word double, the answer for total/count returns as an integer 
    and disregards any decimal. If the result is 5.2, the method only returns 
    the 5. If there's a "(double)", the method returns the result as a double.

2. What would go wrong without the count <= 0 guard?
    In my case where I used an array, if there is no "count <= 0" guard, the 
    method will return NaN, which means "Not a Number." In the case where the 
    method is simply called on the main, it results in an error, because any 
    number divided by zero is undefined, which in Java Language, results in an
    error.
*/
    
    // LOOP
    static int countPassing (int [] grades, int passingMark) {
        int passed = 0;
        
        for (int i = 0; i < grades.length; i++) {
            if (grades [i] >= passingMark) {
                passed += 1; 
            }
        }
        return passed;
    }
    
    //RECURSION 
    static int countPassingRecursive (int [] grades2, int passingMark, int index) {
        int passed = countPassingRecursive (grades2, passingMark, index + 1);
        if (index == grades2.length - 1) {
            return passed;
        } 
        
        if (grades2 [index] >= passingMark) {
            return grades2 [index];
        } else 
            return passed;
    }
}

