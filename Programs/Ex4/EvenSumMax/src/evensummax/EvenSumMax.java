/*
 * Bryce Henley
 * CSC110AB
 * 02/09/2017
 * 
 * The MIT License
 *
 * Copyright 2017 Bryce Henley.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * This program prompts the user for a number of integers
 * Then propts the user to input integer number of times
 * main method should return the sum of all even integers, and the largest even integers entered
 * 
 */
package evensummax;

import java.util.Scanner;

public class EvenSumMax {
    
    public static int sum = 0;
    public static int largest = 0;
    
    public static void main(String[] args) {
        Scanner cli = new Scanner(System.in);
        evenSumMax(cli);
        
        System.out.print("EvenSum = " + sum + "\n");
        System.out.print("LargestEven = " + largest + "\n");
    }
    public static void evenSumMax(Scanner cli){
        System.out.println("Please input the number of integers you wish to enter:");
        int numint = cli.nextInt(); //numer of integers
        
        for(int i=0; i<numint; i++){
            int input = cli.nextInt();
            
            if (input%2 == 0){
                sum = sum + input;
                
                if(input > largest){
                    largest = input;
                }else{
                    
                }
            }else{
                
            }
        }
    
    }
}
