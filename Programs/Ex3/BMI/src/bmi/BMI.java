/*
 * Bryce Henley
 * CSC110AB
 * 02/02/2017
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
 * This program calculates two users body mass index (BMI)
 *
 */
package bmi;

import java.util.*;

public class BMI {

    public static void main(String[] args) {
        
        Scanner cli = new Scanner(System.in);
        
        input();
        
        double user1h = cli.nextDouble();
        System.out.print("weight (in pounds)?" + " ");
        double user1w = cli.nextDouble();
        
        System.out.println();
        
        input();
        
        double user2h = cli.nextDouble();
        System.out.print("weight (in pounds)?" + " ");
        double user2w = cli.nextDouble();
        
        double BMI1 = (user1w / (user1h * user1h))*703;
        double BMI2 = (user2w / (user2h * user2h))*703;
        
        System.out.println();
        
        System.out.println("Person 1 BMI = " + BMI1);
        if(BMI1 < 18.5){
            System.out.println("underweight");
        }else if(BMI1<24.9){
            System.out.println("normal");
        }else if(BMI1<29.9){
            System.out.println("overweight");
        }else if(BMI1>30.0){
            System.out.println("obese");
        }else{
            System.out.print("ERROR");
        }
        
        System.out.println("Person 2 BMI = " + BMI2);
        if(BMI2 < 18.5){
            System.out.println("underweight");
        }else if(BMI2<24.9){
            System.out.println("normal");
        }else if(BMI2<29.9){
            System.out.println("overweight");
        }else if(BMI2>30.0){
            System.out.println("obese");
        }else{
            System.out.print("ERROR");
        }
        
        double diff = (BMI1 - BMI2);
        diff = Math.abs(diff);
        System.out.println("Diffence = " + diff);
        
    }
    public static void input(){
        System.out.println("Enter next person's information:");
        System.out.print("height (in inches)?" + " ");
    }
}
