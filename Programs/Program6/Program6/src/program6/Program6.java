/*
 * Bryce Henley
 * CSC110AB
 * 04/13/2017
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
 * 
 * A simple weather program
 * 
 */
package program6;

import java.io.*;
import java.util.*;

public class Program6 {

    

    public static void main(String[] args) throws FileNotFoundException {
        Scanner cli = new Scanner(System.in);
        //arraylist for storing weather data
        
        ArrayList<Double> list = new ArrayList<Double>(100);
        
        mainMenu(cli, list);
    }
    public static void mainMenu(Scanner cli, ArrayList<Double> list) throws FileNotFoundException {
        //first menu that prompts the user for data input.
        System.out.print("Welcome to the weather station application.\n Enter number to select option"
                + "\n (1)input a data file, or"
                + "\n (2)input data from keyboard"
                + "\n");
        int input = cli.nextInt();
        switch (input) {
            case 1:
                inputFileData(cli, list);
                break;
            case 2:
                inputKeyData(cli, list);
                break;
            default:
                mainMenu(cli, list);
                break;
        }
        
    }
    public static void subMenu(Scanner cli, ArrayList<Double> list) throws FileNotFoundException{
        System.out.print("Enter number to select option:\n"
                + "(1)  Display the input data.\n"
                + "(2)  Display the record high temperature and the year it was recorded for a given day.\n"
                + "(3)  Display the heat index for each day.\n"
                + "(4)  Display the average, the maximum, the minimum, and the range of one field.\n"
                + "(5)  Display the largest difference between two consecutive values in one field.\n"
                + "(6)  Display a chart summarizing the distribution of the values in one field.\n"
                + "(7)  Stop analyzing this collection of data.\n"
                + "\n");
        
        int input = cli.nextInt();
        switch (input) {
            case 1:
                Display(cli, list); 
                break;
            case 2:
                DayOfTheYear(cli, list);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                stopCheck(cli, list);
                break;
        }
    }
    public static void inputFileData(Scanner cli, ArrayList<Double> list) throws FileNotFoundException {
        //method to input weather data from file
        //input file
        Scanner fileInput = new Scanner(new File("genWeather-1.txt"));
        //file to arraylist
        int count = 0;
        int exit = 0;
        while(fileInput.hasNextDouble() && exit == 0){
            double input = fileInput.nextDouble();
            
            //check for 0
            if (count %5 == 0 && input == 0){
                exit = 1;
            }else{
                list.add(input);
                count++; 
            }
             
        }
        
        //toss to subMenu
        subMenu(cli, list);
    }
    public static void inputKeyData(Scanner cli, ArrayList<Double> list) throws FileNotFoundException{
        //method to input weather data from keyboard entry
        
        //input from cli into arraylist
        int i;
        for(i = 0; i == 0;){
            System.out.println("Enter day number: (0 to quit)");
            double day = cli.nextDouble();
            if(day <= 0){
                i = 1;
            }else{
                list.add(day);
                System.out.println("Enter high temp for the day:");
                double high = cli.nextDouble();
                list.add(high);
                System.out.println("Enter record high temp for the day:");
                double recordhigh = cli.nextDouble();
                list.add(recordhigh);
                System.out.println("Enter record year:");
                double recordyear = cli.nextDouble();
                list.add(recordyear);
                System.out.println("Enter relative humidity:");
                double relhum = cli.nextDouble();
                list.add(relhum);
            }
        }
        
        
        
        //toss to subMenu
        subMenu(cli, list);
    }
    public static void stopCheck(Scanner cli, ArrayList<Double> list) throws FileNotFoundException{
        System.out.println("Please select an option");
        System.out.println("1: Stop program");
        System.out.println("2: Enter new data");
        
        int input = cli.nextInt();
        
        switch (input){
            case 1:
                //quit
                break;
            case 2:
                //clear old data
                list.clear();
                //select new data
                mainMenu(cli, list);
                break;
        }
    
    }
    
    //calculation/worker methods
    public static void Display(Scanner cli, ArrayList<Double> list) throws FileNotFoundException{
        int i = 0;
        int index = 0;
        
        //headings
        System.out.printf("day\t high\t record\t year\t humidity\t \n");
        
        while(i <= 50 && (index < list.size())){
            if(i == 50){
                System.out.println("Enter any number to continue displaying results or 0 to quit");
                int input = cli.nextInt();
                if(input == 0){
                    subMenu(cli, list);
                }else{
                    i = 0;
                }
            }else{
                
            }
            
            System.out.printf("%3.0f\t%5.2f\t%5.2f\t%4.0f\t%3.1f \n", list.get(index), list.get(index + 1), list.get(index + 2), list.get(index + 3), list.get(index + 4));
            
            index = index + 5;
            i = i + 5;
            
        }
        
    }
    public static void DayOfTheYear(Scanner cli, ArrayList<Double> list) throws FileNotFoundException{
        System.out.println("Enter day:");
        double day = cli.nextDouble();
        int index;
        boolean found = false;
        
        if(list.contains(day)){
            index = list.indexOf(day);
            if(index %5 == 0){
                
            }else{
                System.out.println("Day not found");
            }
        }else{
            System.out.println("Day not found");
            subMenu(cli, list);
        }
    }
}
