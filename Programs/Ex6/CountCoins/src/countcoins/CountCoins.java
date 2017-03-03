/*
 * Bryce Henley
 * CSC110AB
 * 03/02/2017
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
package countcoins;

import java.io.*;
import java.util.*;

public class CountCoins {

    public static void main(String[] args) 
            throws FileNotFoundException{
        //Scanner input = new Scanner(new File("/home/bryce/CSC110/Programs/Ex6/CountCoins/src/countcoins/input.txt"));
        Scanner input = new Scanner(new File("input.txt"));
        
        countCoins(input);
        
    }
    
    public static void countCoins(Scanner input){
        int sum = 0;
        int next = 0;
        
        String nextString = "";
        while(input.hasNext() ){
            if(input.hasNextInt()){
                next = input.nextInt();
            }
            if(input.hasNext()){
                nextString = input.next();
            }
            sum = sum + next * coinMultiplier(nextString);
        }//while
        System.out.printf("Total money: $%5.2f\n", sum /100.0);
        
    }
    public static int coinMultiplier(String coin){
        if(coin.equalsIgnoreCase("pennies"))
            return 1;
        else if(coin.equalsIgnoreCase("nickels"))
            return 5;
        else if(coin.equalsIgnoreCase("dimes"))
            return 10;
        else
            return 25;
    }
}
