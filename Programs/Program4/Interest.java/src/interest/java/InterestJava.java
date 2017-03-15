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
 *
 * INTREST PROGRAM
 * This program is designed to calculate compounding intrest based on use input
 *
 */
package interest.java;

import java.util.*;

public class InterestJava {
    
    //init variables
    public static double balanceOld;
    public static double balanceCur;
    public static double intrest;
    public static double charge;
    public static double threshold;
    public static double initBalance;
    public static double aIRate;
    public static int period;
    public static String readperiod;
    public static int periodIn;
    public static boolean option;
    public static int run = 1;
    public static int prompt;
    public static double intrestcalc;
            
    public static void main(String[] args) {
        Scanner cli = new Scanner(System.in);
        
        run(cli);
    }
    public static int run(Scanner cli){
        charge(cli);
        threshold(cli);
        initBalance(cli);
        aIRate(cli);
        period(cli);
        option(cli);
        
        run++;
        
        //run selected option
        if (option){
            optionA(cli);
        }else{
            optionB(cli);
        }
        
        return run;
    }
    public static boolean option(Scanner cli){
        System.out.println("Option A, specify the length of the investment (in the same units as specified for the compounding \n" +
            "period), and have the program compute the final account balance.");
        System.out.println("");
        System.out.println("Option B, specify a goal for the account balance, and have the program calculate how long (in the same \n" +
            "units as the compounding period) it will take to achieve that amount.");
        System.out.println("Select option:");
        
        String op2;
        op2 = cli.next();
        
        if (op2.toLowerCase().equals("a")){
            return option = true;
        }else if (op2.toLowerCase().equals("b")){
            return option  = false;
        }else{
            System.out.println("You entered an incorrect value, Please try again:");
            option(cli);
        }
        return option;
    }
    public static void optionA(Scanner cli){
        //calc
        if (period == 1){
            System.out.println("enter number of days");
            readperiod = "days ";
        }else if (period == 2){
            System.out.println("enter number of months");
            readperiod = "months ";
        }else{
            System.out.println("enter nubmer of years");
            readperiod = "years ";
        }
        periodIn = cli.nextInt();
        
        balanceOld = initBalance;
        
        for (int i = 1; i <= periodIn; i++){
            intrestcalc = (balanceOld*aIRate);
            balanceCur = balanceOld + intrestcalc;
            balanceOld = balanceCur;
        }
        //display result
        System.out.printf("$%.2f %n",balanceCur);
        System.out.println("");
        
        //prompt user
        prompt(cli);
        
        if(prompt == 1){
            run(cli);
        }else if(prompt == 2){
            intrestcalc = 0.0;
            balanceOld = initBalance;
          
            System.out.printf("%s %10s  %n", readperiod, "Balance");
            for (int i = 1; i <= periodIn; i++){
            intrestcalc = (balanceOld*aIRate);
            balanceCur = balanceOld + intrestcalc;
            balanceOld = balanceCur;
            
//            System.out.printf("%15d + " " $%10.2f \n", i, balanceCur);
            System.out.printf("%100.2f %n", balanceCur);
            }
        }else{
            
        }
        
        
        
        
        
    }
    public static void optionB(Scanner cli){
        
    }
    public static int period(Scanner cli){
        System.out.println("Please enter compounding intrest period (day,month,year):");
            String op;
            op = cli.next();
            
            if (op.toLowerCase().equals("day")){
                return period = 1;
            }else if (op.toLowerCase().equals("month")){
                return period = 2;
            }else if (op.toLowerCase().equals("year")){
                return period = 3;
            }else{
                System.out.println("You entered an incorrect value, Please try again:");
                period(cli);
                
            } 
        return period;
    }
    public static double charge(Scanner cli){
        System.out.println("Please enter anual processing charge:");
        charge = cli.nextDouble();
        return charge;
    }
    public static double threshold(Scanner cli){
        System.out.println("Please enter threshold:");
        threshold = cli.nextDouble();
        return threshold;
    }
    public static double initBalance(Scanner cli){
        System.out.println("Please enter inital ballance:");
        initBalance = cli.nextDouble();
        return initBalance;
    }
    public static double aIRate(Scanner cli){
        System.out.println("Please enter anual intrest rate:");
        aIRate = cli.nextDouble();
        return aIRate;
    }
    public static int prompt(Scanner cli){
        System.out.println("enter \"table\" to display results");
        System.out.println("enter \"q\" to quit");
        System.out.println("enter \"run\" to run the program again");
        
        String promptinput;
        promptinput = cli.next();
        
        if(promptinput.toLowerCase().equals("table")){
            prompt = 2;
        }else if(promptinput.toLowerCase().equals("q")){
            prompt = 3;
        }else if(promptinput.toLowerCase().equals("run")){
            prompt = 1;
        }else{
            System.out.println("invalid input:");
            prompt(cli);
        }
        
        return prompt;
    }
}
