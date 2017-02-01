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
 * Scans console input for number n, prints n number powers of two back to console.
 *
 */
package printpowersof2;

//Scanner
import java.util.Scanner;

public class PrintPowersOf2 {
    
    public static void main(String[] args) {
        
        //Scanner declaration
        Scanner cli = new Scanner(System.in);
        
        System.out.println("Please input number of powers of two to output:"); //User prompt
        //User input
        int n = cli.nextInt();
        int power = 1;
        
        System.out.print(1 + " ");
        
        for(int i = 0; i<n; i++){
            power = (power * 2);
            System.out.print(power + " ");
        }
        //ignore, makes it easier to read in netbeans build
        System.out.println();
    }
    
}
