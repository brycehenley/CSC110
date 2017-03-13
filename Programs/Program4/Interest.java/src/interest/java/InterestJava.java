/*
 * Bryce Henley
 * CSC110AB
 * 03/07/2017
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
 */
package interest.java;

import java.util.Scanner;

public class InterestJava {
    
    //init variables
    public static double balance_old;
    public static double balance_current;
    public static double intrest;
    public static double charge;
    public static double threshold;
    
    
    
    
            
    public static void main(String[] args) {
        Scanner cli = new Scanner(System.in);
        
        System.out.println("enter anual processing charge:");
        charge = cli.nextDouble();
        System.out.println("enter threshold:");
        charge = cli.nextDouble();
        
        optionA(cli);
    }
    public static void optionA(Scanner cli){
        
        System.out.println("enter initial balance");
        
        balance_current = cli.nextDouble();
        
        
    }
    public static void optionB(Scanner cli){
        
    }
}
