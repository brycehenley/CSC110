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
        mainMenu(cli);
    }
    public static void mainMenu(Scanner cli) throws FileNotFoundException {
        //first menu that prompts the user for data input.
        System.out.print("Welcome to the weather station application.\n Enter number to select option"
                + "\n (1)input a data file, or"
                + "\n (2)input data from keyboard"
                + "\n");
        int input = cli.nextInt();
        switch (input) {
            case 1:
                inputFileData(cli);
                break;
            case 2:
                inputKeyData(cli);
                break;
            default:
                mainMenu(cli);
                break;
        }
        
    }
    public static void subMenu(Scanner cli){
        System.out.print("Enter number to select option:\n"
                + "(1)  Display the input data.\n"
                + "(2)  Display the record high temperature and the year it was recorded for a given day.\n"
                + "(3)  Display the heat index for each day.\n"
                + "(4)  Display the average, the maximum, the minimum, and the range of one field.\n"
                + "(5)  Display the largest difference between two consecutive values in one field.\n"
                + "(6)  Display a chart summarizing the distribution of the values in one field.\n"
                + "(7)  Stop analyzing this collection of data.\n"
                + "\n");
    }
    public static void inputFileData(Scanner cli) throws FileNotFoundException {
        //method to input weather data from file
        //input file
        Scanner fileInput = new Scanner(new File("genWeather-1.txt"));
        //file to arraylist
        
        
        //toss to subMenu
        subMenu(cli);
    }
    public static void inputKeyData(Scanner cli){
        //method to input weather data from keyboard entry
        
        //input from cli into arraylist
        //toss to subMenu
        subMenu(cli);
    }

    //calculations
}
