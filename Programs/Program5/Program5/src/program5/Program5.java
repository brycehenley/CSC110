/*
 * Bryce Henley
 * CSC110AB
 * 04/05/2017
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
package program5;

import java.util.*;

public class Program5 {
    public static final double GRAVITY = 32.172;
    public static final double FPM = 5280;
    public static final double SPH = 3600;
            
    public static double[] user_input_point = {0.0,0.0};
    public static int run;
    public static double angle;
    public static double vel;
    public static double distance;
    public static double horizon_dis;
    
    public static double engineering_1;
     public static double engineering_2;
      public static double engineering_3;
       public static double[] engineering_4 = {0.0, 0.0};
       
       
    public static void main(String[] args) {
        //use printf for outputs
        
        Scanner cli = new Scanner(System.in);
        menu(cli);
    }
    public static void menu(Scanner cli){
        System.out.println("Enter number to select option.");
        
        System.out.println("(1) Basic Calculations");
        System.out.println("(2) Driving Range");
        System.out.println("(3) Swamp Golf");
        System.out.println("(4) Your Game");
        System.out.println("(5) Quit");
        
        int input = cli.nextInt();
        
        if(input == 1){
            bcalc(cli);
        }else if(input == 2){
            drivingRange(cli);
        }else if(input == 3){
            swampGolf(cli);
        }else if(input == 4){
            game(cli);
        }else if(input == 5){
            //quit
        }else{
            menu(cli);
        }
    }
    public static void customer_service(Scanner cli){
        options();
        String optionselect = cli.next();
        if (optionselect.equals("1")){
            run = 1;
            engineer(cli, run);
        }else if(optionselect.equals("2")){
            run = 2;
            engineer(cli, run);
        }else if(optionselect.equals("3")){
            run = 3;
            engineer(cli, run);
        }else if(optionselect.equals("4")){
            run = 4;
            engineer(cli, run);
        }else if(optionselect.equals("q")){
            //end of line
        }else{
            customer_service(cli);
        }
    }
    public static void engineer(Scanner cli, int run){
        if (run == 1){
            engineering_1(cli);
        }else if(run == 2){
            engineering_2(cli);
        }else if(run == 3){
            engineering_3(cli);
        }else{
            engineering_4(cli);
        }
        //restart after calc
        customer_service(cli);
    }
    public static double engineering_1(Scanner cli){
        
        user_input_point(cli);
        double[] point1 = user_input_point.clone();

        user_input_point(cli);
        double[] point2 = user_input_point.clone();
        
        double x1 = point1[0];
        double x2 = point2[0];
        double y1 = point1[1];
        double y2 = point2[1];

        double calc = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        
        engineering_1 = calc;
        //test
        System.out.println(engineering_1);
        return engineering_1;
    }
    public static double engineering_2(Scanner cli){
        user_input_point(cli);
        double[] point1 = user_input_point.clone();
        
        user_input_point(cli);
        double[] point2 = user_input_point.clone();
        double dx = (point1[0] - point2[0]);
        double dy = (point1[1] - point2[1]);
        double ang = 0.0;
        
        if(dx > 0){
            ang = Math.atan(dy/dx);
        }else if(dx < 0){
            ang = Math.atan(dy/dx) + Math.PI;
        }else if(dx == 0 && dy >= 0){
            ang = Math.PI/2;
        }else if(dx == 0 && dy < 0){
            ang = -(Math.PI)/2;
        }else{}
        
        engineering_2 = ang;
        //test
        System.out.println(engineering_2);
        return engineering_2;
    }
    public static double engineering_3(Scanner cli){
        user_input_angle(cli);
        user_input_vel(cli);
        
        double angrad = angle * (Math.PI/180);
        double vi = vel *(FPM/SPH);
        horizon_dis = (vi*vi) * Math.sin(2*angrad) / GRAVITY;
        
        //test
        System.out.println(horizon_dis);
        return horizon_dis;
        
    }
    public static double[] engineering_4(Scanner cli){
        user_input_point(cli);
        user_input_distance(cli);
        user_input_angle(cli);
        
        double angrad = angle * (Math.PI/180);
        double dx = distance * Math.cos(angrad);
        double dy = distance * Math.sin(angrad);
        
        engineering_4[0] = user_input_point[0] + dx;
        engineering_4[1] = user_input_point[1] + dy;
        
        //test
        System.out.println("" + engineering_4[0] + " " + engineering_4[1]);
        return engineering_4;
    }
    public static void options(){
        System.out.println("please select an option by entering number");
        System.out.println("(1)  Given two points, compute the distance between the two points.");
        System.out.println("(2)  Given two points, compute the horizontal angle from the first point to the second.");
        System.out.println("(3)  Given the elevation angle and velocity, compute the (horizontal) distance an object travels.");
        System.out.println("(4)  Given a starting point, a distance, and a horizontal angle, compute the destination point.");
        System.out.println("(q)  To quit.");
    }
    public static double[] user_input_point(Scanner cli){
        double[] point = {0.0,0.0};
        
        System.out.println("Enter point x value(feet):");
        point[0] = cli.nextDouble();
        System.out.println("Enter point y value(feet):");
        point[1] = cli.nextDouble();
        
        user_input_point[0] = point[0];
        user_input_point[1] = point[1];
        
        return user_input_point;
    }
    public static double user_input_angle(Scanner cli){
        
        System.out.println("Enter angle of elevation(deg):");
        angle = cli.nextDouble();
        
        return angle;
    }
    public static double user_input_vel(Scanner cli){
        
        System.out.println("Enter velocity(miles/hr):");
        vel = cli.nextDouble();
        
        return vel;
    }
    public static double user_input_distance(Scanner cli){
        
        System.out.println("Enter distance(ft):");
        distance = cli.nextDouble();
        
        return vel;
    }
}
