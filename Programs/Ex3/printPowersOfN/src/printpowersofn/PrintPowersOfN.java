/*
 * Bryce Henley
 * CSC110AB
 * 01/31/2017
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
 * This program accepts a base and an exponent as arguments and prints each power of the base from base0 (1) up to the maximum power
 * 
 */
package printpowersofn;

import java.util.Scanner;

public class PrintPowersOfN {
    
    public static void main(String[] args) {
        
        Scanner cli = new Scanner(System.in);
        
        System.out.println("This program accepts a base and an exponent as arguments and prints each power of the base from base0 (1) up to the maximum power");
        System.out.println("Enter base:");
        int b = cli.nextInt();
        System.out.println("Enter exponent:");
        int p = cli.nextInt();

        
        printPowersOfN(b,p);
    }
    
    public static void printPowersOfN(int b, int p) {
        
        int n = b;
        
        System.out.print(1 + " ");
        
        for(int i = 1; i<p; i++){
            n = b * n;
            System.out.print(n + " ");
        }
        //ignore, makes it easier to read in netbeans build
        System.out.println();
    }
    
}
