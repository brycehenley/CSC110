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
        
        ArrayList<Double> list1 = new ArrayList<Double>(100);
        ArrayList<Double> list2 = new ArrayList<Double>(100);
        ArrayList<Double> list3 = new ArrayList<Double>(100);
        ArrayList<Double> list4 = new ArrayList<Double>(100);
        ArrayList<Double> list5 = new ArrayList<Double>(100);
        ArrayList<Double> list6 = new ArrayList<Double>(100);
        
        mainMenu(cli, list1, list2, list3, list4, list5, list6);
    }
    public static void mainMenu(Scanner cli, ArrayList<Double> list1, ArrayList<Double> list2, ArrayList<Double> list3, ArrayList<Double> list4, ArrayList<Double> list5, ArrayList<Double> list6) throws FileNotFoundException {
        //first menu that prompts the user for data input.
        System.out.print("Welcome to the weather station application.\n Enter number to select option"
                + "\n (1)input a data file, or"
                + "\n (2)input data from keyboard"
                + "\n");
        int input = cli.nextInt();
        switch (input) {
            case 1:
                inputFileData(cli, list1, list2, list3, list4, list5, list6);
                break;
            case 2:
                inputKeyData(cli, list1, list2, list3, list4, list5, list6);
                break;
            default:
                mainMenu(cli, list1, list2, list3, list4, list5, list6);
                break;
        }
        
    }
    public static void subMenu(Scanner cli, ArrayList<Double> list1, ArrayList<Double> list2, ArrayList<Double> list3, ArrayList<Double> list4, ArrayList<Double> list5, ArrayList<Double> list6) throws FileNotFoundException{
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
                Display(cli, list1, list2, list3, list4, list5, list6); 
                break;
            case 2:
                DayOfTheYear(cli, list1, list2, list3, list4, list5, list6);
                break;
            case 3:
                HeatIndex(cli, list1, list2, list3, list4, list5, list6);
                break;
            case 4:
                Option4(cli, list1, list2, list3, list4, list5, list6);
                break;
            case 5:
                Option5(cli, list1, list2, list3, list4, list5, list6);
                break;
            case 6:
                Option6(cli, list1, list2, list3, list4, list5, list6);
                break;
            case 7:
                stopCheck(cli, list1, list2, list3, list4, list5, list6);
                break;
        }
        
    }
    public static void inputFileData(Scanner cli, ArrayList<Double> list1, ArrayList<Double> list2, ArrayList<Double> list3, ArrayList<Double> list4, ArrayList<Double> list5, ArrayList<Double> list6) throws FileNotFoundException {
        //method to input weather data from file
        //input file
        Scanner fileInput = new Scanner(new File("genWeather-1.txt"));
        //file to arraylist
        int count = 1;
        int exit = 0;
        while(fileInput.hasNextDouble() && exit == 0){
            double input = fileInput.nextDouble();
            
            if(count %5 == 0 && input == 0){
                //exit
                exit = 1;
            }else{
                switch (count) {
                    case 1:
                        list1.add(input);
                        break;
                    case 2:
                        list2.add(input);
                        break;
                    case 3:
                        list3.add(input);
                        break;
                    case 4:
                        list4.add(input);
                        break;
                    case 5:
                        list5.add(input);
                        break;
                }
                
            }
            count ++;
            if(count == 6){
                count = 1;
            }else{}
        }
        
        //toss to subMenu
        subMenu(cli, list1, list2, list3, list4, list5, list6);
    }
    public static void inputKeyData(Scanner cli, ArrayList<Double> list1, ArrayList<Double> list2, ArrayList<Double> list3, ArrayList<Double> list4, ArrayList<Double> list5, ArrayList<Double> list6) throws FileNotFoundException{
        //method to input weather data from keyboard entry
        
        //input from cli into arraylist
        int i;
        for(i = 0; i == 0;){
            System.out.println("Enter day number: (0 to quit)");
            double day = cli.nextDouble();
            if(day <= 0){
                i = 1;
            }else{
                list1.add(day);
                System.out.println("Enter high temp for the day:");
                double high = cli.nextDouble();
                list2.add(high);
                System.out.println("Enter record high temp for the day:");
                double recordhigh = cli.nextDouble();
                list3.add(recordhigh);
                System.out.println("Enter record year:");
                double recordyear = cli.nextDouble();
                list4.add(recordyear);
                System.out.println("Enter relative humidity:");
                double relhum = cli.nextDouble();
                list5.add(relhum);
            }
        }
        
        
        
        //toss to subMenu
        subMenu(cli, list1, list2, list3, list4, list5, list6);
    }
    public static void stopCheck(Scanner cli, ArrayList<Double> list1, ArrayList<Double> list2, ArrayList<Double> list3, ArrayList<Double> list4, ArrayList<Double> list5, ArrayList<Double> list6) throws FileNotFoundException{
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
                list1.clear();
                list2.clear();
                list3.clear();
                list4.clear();
                list5.clear();
                //select new data
                mainMenu(cli, list1, list2, list3, list4, list5, list6);
                break;
        }
    
    }
    
    //calculation/worker methods
    public static void Display(Scanner cli, ArrayList<Double> list1, ArrayList<Double> list2, ArrayList<Double> list3, ArrayList<Double> list4, ArrayList<Double> list5, ArrayList<Double> list6) throws FileNotFoundException{
        int i = 0;
        int index = 0;
        
        //headings
        System.out.printf("day\t high\t record\t year\t humidity\t \n");
        
        while(i <= 10 && (index + 1 < list1.size())){
            if(i == 10){
                System.out.println("Enter any number to continue displaying results or 0 to quit");
                int input = cli.nextInt();
                if(input == 0){
                    subMenu(cli, list1, list2, list3, list4, list5, list6);
                }else{
                    i = 0;
                }
            }else{
                
            }
            
            System.out.printf("%3.0f\t%5.2f\t%5.2f\t%4.0f\t%3.1f \n", list1.get(index), list2.get(index), list3.get(index), list4.get(index), list5.get(index));
            
            index++;
            i++;
            
        }
        subMenu(cli, list1, list2, list3, list4, list5, list6);
    }
    public static void DayOfTheYear(Scanner cli, ArrayList<Double> list1, ArrayList<Double> list2, ArrayList<Double> list3, ArrayList<Double> list4, ArrayList<Double> list5, ArrayList<Double> list6) throws FileNotFoundException{
        System.out.println("Enter day:");
        double day = cli.nextDouble();
        int index;
        
        if(list1.contains(day)){
            index = list1.indexOf(day);
           
                System.out.printf("record hight temperature: %3.2f, record year: %4.0f\n", list3.get(index), list4.get(index));
        }else{
            System.out.println("Day not found");
            subMenu(cli, list1, list2, list3, list4, list5, list6);
        }
        subMenu(cli, list1, list2, list3, list4, list5, list6);
    }
    public static void HeatIndex(Scanner cli, ArrayList<Double> list1, ArrayList<Double> list2, ArrayList<Double> list3, ArrayList<Double> list4, ArrayList<Double> list5, ArrayList<Double> list6) throws FileNotFoundException{
        //HI calc
        int cycle = 0;
        while(cycle + 1 < list1.size()){
            double HI;
            HI = (-42.379 + 2.04901523*list2.get(cycle) + 10.14333127 * list5.get(cycle) - 0.22475541*list2.get(cycle)*list5.get(cycle) - 0.00683783*list2.get(cycle)*list2.get(cycle) - 0.05481717*list5.get(cycle)*list5.get(cycle) + 0.00122874*list2.get(cycle)*list2.get(cycle)*list5.get(cycle) + 0.00085282*list2.get(cycle)*list5.get(cycle)*list5.get(cycle) - 0.00000199*list2.get(cycle)*list2.get(cycle)*list5.get(cycle)*list5.get(cycle)); 
            
            //adjustement
            if(list5.get(cycle) < 13.0 && list2.get(cycle) > 80.0 && list2.get(cycle) < 112.0){
                HI = HI - (((13-list5.get(cycle))/4)*Math.sqrt((17-Math.abs(list2.get(cycle)-95.0))/17));
            }else if(list5.get(cycle) > 85.0 && list2.get(cycle) > 80.0 && list2.get(cycle) < 87.0){
                HI = HI + ((list5.get(cycle)-85)/10) * ((87-list2.get(cycle))/5);
            }else{
                
            }
            list6.add(HI);
            cycle++;
        }
        
        
        
        //Display
        int i = 0;
        int index = 0;
        
        //headings
        System.out.printf("day\t high\t humidity\t heat_index\n");
        
        while(i <= 10 && (index + 1 < list1.size())){
            if(i == 10){
                System.out.println("Enter any number to continue displaying results or 0 to quit");
                int input = cli.nextInt();
                if(input == 0){
                    subMenu(cli, list1, list2, list3, list4, list5, list6);
                }else{
                    i = 0;
                }
            }else{
                
            }
            //day high hum HI
            System.out.printf("%3.0f\t%5.2f\t%3.1f\t%6.3f \n", list1.get(index), list2.get(index), list5.get(index), list6.get(index));
            
            index++;
            i++;
            
        }
        
        subMenu(cli, list1, list2, list3, list4, list5, list6);
    }
    public static void Option4(Scanner cli, ArrayList<Double> list1, ArrayList<Double> list2, ArrayList<Double> list3, ArrayList<Double> list4, ArrayList<Double> list5, ArrayList<Double> list6) throws FileNotFoundException{
        //for the selected field, compute and display four results: the average value, the minimum value, the maximum value, and the range (the difference between the minimum and maximum).
        System.out.println("Enter number to select feild");
        System.out.println("1: high temp");
        System.out.println("2: record high temp");
        System.out.println("3: relative humidity");
        
        int input = cli.nextInt();
        
        switch(input){
            case 1:
                Avg(list2);
                break;
            case 2:
                Avg(list3);
                break;
            case 3:
                Avg(list5);
                break;
        }
        
        
        subMenu(cli, list1, list2, list3, list4, list5, list6);
    }
    public static void Option5(Scanner cli, ArrayList<Double> list1, ArrayList<Double> list2, ArrayList<Double> list3, ArrayList<Double> list4, ArrayList<Double> list5, ArrayList<Double> list6) throws FileNotFoundException{
        
        subMenu(cli, list1, list2, list3, list4, list5, list6);
    }
    public static void Option6(Scanner cli, ArrayList<Double> list1, ArrayList<Double> list2, ArrayList<Double> list3, ArrayList<Double> list4, ArrayList<Double> list5, ArrayList<Double> list6) throws FileNotFoundException{
        
        subMenu(cli, list1, list2, list3, list4, list5, list6);
    }
    public static double Avg(ArrayList<Double> avglist){
        double avg = 0;
        for(int i = 0; i + 1 < avglist.size(); i++){
            avg = avg + avglist.get(i);
        }
        avg = avg / avglist.size();
        
        return avg;
    }
}
