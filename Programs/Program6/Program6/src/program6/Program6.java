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
                list6.clear();
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
                System.out.printf("Average: \n %5.2f \n Min: \n %5.2f \n Max: \n %5.2f \n Range: \n %5.2f \n", Avg(list2), Min(list2), Max(list2), Range(list2));
                break;
            case 2:
                System.out.printf("Average: \n %5.2f \n Min: \n %5.2f \n Max: \n %5.2f \n Range: \n %5.2f \n", Avg(list3), Min(list3), Max(list3), Range(list3));
                break;
            case 3:
                System.out.printf("Average: \n %5.2f \n Min: \n %5.2f \n Max: \n %5.2f \n Range: \n %5.2f \n", Avg(list5), Min(list5), Max(list5), Range(list5));
                break;
        }
        
        
        subMenu(cli, list1, list2, list3, list4, list5, list6);
    }
    public static void Option5(Scanner cli, ArrayList<Double> list1, ArrayList<Double> list2, ArrayList<Double> list3, ArrayList<Double> list4, ArrayList<Double> list5, ArrayList<Double> list6) throws FileNotFoundException{
        System.out.println("Enter number to select feild");
        System.out.println("1: high temp");
        System.out.println("2: record high temp");
        System.out.println("3: relative humidity");
        
        int input = cli.nextInt();
        
        switch(input){
            case 1:
                double[] diffrence1 = Diff(list2);
                System.out.printf("diffrence: \n %5.2f \n day1: \n %3.0f \n day2: \n %3.0f \n", diffrence1[0], list1.get((int)diffrence1[1]), list1.get((int)diffrence1[2]));
                break;
            case 2:
                double[] diffrence2 = Diff(list3);
                System.out.printf("diffrence: \n %5.2f \n day1: \n %3.0f \n day2: \n %3.0f \n", diffrence2[0], diffrence2[1], diffrence2[2]);
                break;
            case 3:
                double[] diffrence3 = Diff(list5);
                System.out.printf("diffrence: \n %5.2f \n day1: \n %3.0f \n day2: \n %3.0f \n", diffrence3[0], diffrence3[1], diffrence3[2]);
                break;
        }
        
        subMenu(cli, list1, list2, list3, list4, list5, list6);
    }
    public static void Option6(Scanner cli, ArrayList<Double> list1, ArrayList<Double> list2, ArrayList<Double> list3, ArrayList<Double> list4, ArrayList<Double> list5, ArrayList<Double> list6) throws FileNotFoundException{
        //decade arraylist
        ArrayList<String> decade = new ArrayList<String>(Arrays.asList("0","10","20","30","40","50","60","70","80","90","100+","100+"));
        
        
        System.out.println("Enter number to select feild");
        System.out.println("1: high temp");
        System.out.println("2: record high temp");
        System.out.println("3: relative humidity");
        
        int input = cli.nextInt();
        
        switch(input){
            case 1:
                //return array
                int[] dec1;
                dec1 = Decade(list2).clone();
                
                
                System.out.println("Enter number to select output format");
                System.out.println("1: table");
                System.out.println("2: graph");
                int format = cli.nextInt();
                
                if(format == 1){
                    System.out.print("decade     :     count\n");
                    for(int i = 0; i + 1 < decade.size(); i++){
                        System.out.printf("%s\t%d\n", decade.get(i), dec1[i]);
                    }
                }else{
                    System.out.print("decade     :     count\n");
                    for(int i = 0; i + 1 < decade.size(); i++){
                        System.out.printf("%s\t", decade.get(i));
                        for(int t = 0; t < dec1[i]; t++){
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                }
                
                break;
            case 2:
                //return array
                int[] dec2;
                dec2 = Decade(list3).clone();
                
                
                System.out.println("Enter number to select output format");
                System.out.println("1: table");
                System.out.println("2: graph");
                int format2 = cli.nextInt();
                
                if(format2 == 1){
                    System.out.print("decade     :     count\n");
                    for(int i = 0; i + 1 < decade.size(); i++){
                        System.out.printf("%s\t%d\n", decade.get(i), dec2[i]);
                    }
                }else{
                    System.out.print("decade     :     count\n");
                    for(int i = 0; i + 1 < decade.size(); i++){
                        System.out.printf("%s\t", decade.get(i));
                        for(int t = 0; t < dec2[i]; t++){
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                }
                break;
            case 3:
                //return array
                int[] dec3;
                dec3 = Decade(list2).clone();
                
                
                System.out.println("Enter number to select output format");
                System.out.println("1: table");
                System.out.println("2: graph");
                int format3 = cli.nextInt();
                
                if(format3 == 1){
                    System.out.print("decade     :     count\n");
                    for(int i = 0; i + 1 < decade.size(); i++){
                        System.out.printf("%s\t%d\n", decade.get(i), dec3[i]);
                    }
                }else{
                    System.out.print("decade     :     count\n");
                    for(int i = 0; i + 1 < decade.size(); i++){
                        System.out.printf("%s\t", decade.get(i));
                        for(int t = 0; t < dec3[i]; t++){
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                }       
                break;
        }
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
    public static double Min(ArrayList<Double> minlist){
        double min = minlist.get(0);
        
        for(int i = 0; i + 1 < minlist.size(); i++){
            if(minlist.get(i) < min){
                min = minlist.get(i);
            }else{
                
            }
        }
        return min;
    }
    public static double Max(ArrayList<Double> maxlist){
        double max = maxlist.get(0);
        for(int i = 0; i + 1 < maxlist.size(); i++){
            if(maxlist.get(i) > max){
                max = maxlist.get(i);
            }else{
                
            }
        }
        return max;
    }
    public static double Range(ArrayList<Double> rangelist){
        double range = 0;
        double min = rangelist.get(0);
        double max = rangelist.get(0);
        
        for(int i = 0; i + 1 < rangelist.size(); i++){
            if(rangelist.get(i) > max){
                max = rangelist.get(i);
            }else{
                
            }
        }
        
        for(int i = 0; i + 1 < rangelist.size(); i++){
            if(rangelist.get(i) < min){
                min = rangelist.get(i);
            }else{
                
            }
        }
        range = Math.abs(max-min);
        return range;
    }
    public static double[] Diff(ArrayList<Double> difflist){
        double[] diff;
        //{diffrence, index1, index2}
        diff = new double[3];
        double diffmax = Math.abs(difflist.get(0) - difflist.get(1));

        for(int i = 0; i + 2 < difflist.size(); i++){
            
            if((Math.abs(difflist.get(i+1)-difflist.get(i))) > diffmax){
                diffmax = (Math.abs(difflist.get(i+1)-difflist.get(i)));
                
                diff[0] = diffmax;
                diff[1] = i;
                diff[2] = i + 1;
            }else{
                
            }
        }
        
        return diff;
    }
    public static int[] Decade(ArrayList<Double> decadelist){
        int[] decadevalue;
        decadevalue = new int[11];
        
        decadevalue[0] = 0;
        decadevalue[1] = 0;
        decadevalue[2] = 0;
        decadevalue[3] = 0;
        decadevalue[4] = 0;
        decadevalue[5] = 0;
        decadevalue[6] = 0;
        decadevalue[7] = 0;
        decadevalue[8] = 0;
        decadevalue[9] = 0;
        decadevalue[10] = 0;
        
        for(int i = 0; i + 1 < decadelist.size(); i++){
            int dl = (int)Math.round(decadelist.get(i));
            
            if (dl < 10){
                decadevalue[0]++;
            }else if (dl >= 10 && dl <20){
                decadevalue[1]++;
            }else if (dl >= 20 && dl<30){
                decadevalue[2]++;
            }else if (dl >= 30 && dl<40){
                decadevalue[3]++;
            }else if (dl >= 40 && dl<50){
                decadevalue[4]++;
            }else if (dl >= 50 && dl<60){
                decadevalue[5]++;
            }else if (dl >= 60 && dl<70){
                decadevalue[6]++;
            }else if (dl >= 70 && dl<80){
                decadevalue[7]++;
            }else if (dl >= 80 && dl<90){
                decadevalue[8]++;
            }else if (dl >= 90 && dl<100){
                decadevalue[9]++;
            }else{
                decadevalue[10]++;
            }
                
        }
        
        
        return decadevalue;
    }
}
