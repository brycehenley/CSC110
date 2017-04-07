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
    public static double[] point1;
    public static double[] point2;
    public static int run;
    public static double angle;
    public static double vel;
    public static double distance;
    public static double horizon_dis;
    
    public static double engineering_1;
    public static double engineering_2;
    public static double engineering_3;
    public static double[] engineering_4 = {0.0, 0.0};
       
    public static int drivingForce;
    public static double speed;
    public static int random;
    public static int setDifficulty;
    public static int rad;
    public static int charge1 = 3;
    public static int charge2 = 3;
    public static int player1_score = 0;
    public static int player2_score = 0;
    public static int hole = 1;
    public static double holedis;
    public static double hole1;
    public static double hole2;
    public static double hole3;
    public static double hole4;
    public static double hole5;
    public static double current1 = 0;
    public static double current2 = 0;
    public static int stroke1 = 0;
    public static int stroke2 = 0;
    
    public static void main(String[] args) {
        
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
            customer_service(cli);
        }else if(input == 2){
            drivingRange(cli);
            //restart
            menu(cli);
        }else if(input == 3){
            swampGolfInit(cli);
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
    
    
    
    ///////////////5.2 METHODS//////////////////////////////
    public static void drivingRange(Scanner cli){
        System.out.println("Please enter club type by number");
        System.out.println("(3) 3-iron");
        System.out.println("(5) 5-iron");
        System.out.println("(7) 7-iron");
        System.out.println("(9) 9-iron");
        
        int iron = cli.nextInt();
        
        if(iron == 3){
            angle = 20.0;
        }else if(iron == 5){
            angle = 40.0;
        }else if(iron == 7){
            angle = 60.0;
        }else if(iron == 9){
            angle = 80.0;
        }else{
            drivingRange(cli);
        }
        
        drivingForce(cli);
        drivingRangeEngineer(cli);
        
        
        
    }
    public static int drivingForce(Scanner cli){
        System.out.println("(0-100)Please enter driving force percent");
        drivingForce = cli.nextInt();
        if(drivingForce >= 0 && drivingForce <= 100){
            return drivingForce;
        }else{
            drivingForce(cli);
        }
        return drivingForce;
    }
    public static void drivingRangeEngineer(Scanner cli){
        speed = (drivingForce * 0.01)*(150.0);
        vel = speed;
        engineering_3(cli, angle, vel);
        System.out.printf("You hit the ball "+"%.2f"+" feet"+"\n", horizon_dis);
    }
    public static void swampGolfInit(Scanner cli){
        System.out.println("Welcome to Swamp Golf!");
        System.out.println("player1: Tiger Woods");
        System.out.println("player2: Phil Mickelson");
        
        //initialize game
        setDifficulty(cli);
        
        hole = 1;
        
        //generate random distances
        hole1 = Math.random()*5000+1;
        hole2 = Math.random()*5000+1;
        hole3 = Math.random()*5000+1;
        hole4 = Math.random()*5000+1;
        hole5 = Math.random()*5000+1;
        
        //System.out.println(hole1 + " " + hole3);
        
        swampGolf(cli);
    }
    public static void swampGolf(Scanner cli){
        //input method for Swamp Golf
        if(hole == 1){
            holedis = hole1;
        }else if(hole == 2){
            holedis = hole2;
        }else if(hole == 3){
            holedis = hole3;
        }else if(hole == 4){
            holedis = hole4;
        }else if(hole == 5){
            holedis = hole5;
        }else{
            
        }
        
        if(hole < 6){
            System.out.println("Player1:");
            System.out.println("(1) Use the compass/range-finder to find the angle and distance to the hole");
            System.out.println("(2) Hit the ball,");
            System.out.println("(3) Quit the hole");
            int player1_input = cli.nextInt();

            if(player1_input == 1){
                if(charge1 > 0){
                    
                        System.out.println(holedis - current1);

                    charge1--;
                }else{
                    System.out.println("battery out of charge...");
                    
                }
            }else if(player1_input == 2){
                drivingRange(cli);
                stroke1++;
                current1 = current1 + horizon_dis;
                if((current1-holedis)<rad){
                    player1_score++;
                    hole++;
                    
                }else{
                     
                }
                
            }else{
                hole++;
                current1 = 0;
                current2 = 0;
                swampGolf(cli);
            }
            //player2
            System.out.println("Player2:");
            System.out.println("(1) Use the compass/range-finder to find the angle and distance to the hole");
            System.out.println("(2) Hit the ball,");
            System.out.println("(3) Quit the hole");
            int player2_input = cli.nextInt();

            if(player2_input == 1){
                if(charge2 > 0){
                    
                        System.out.println(holedis - current1);

                    charge2--;
                }else{
                    System.out.println("battery out of charge...");
                    
                }
            }else if(player2_input == 2){
                drivingRange(cli);
                stroke2++;
                current2 = current2 + horizon_dis;
                if((current2-holedis)<rad){
                    player2_score++;
                    hole++;
                    
                }else{
                     
                }
                
            }else{
                hole++;
                current1 = 0;
                current2 = 0;
                swampGolf(cli);
            }
            //reset
            swampGolf(cli);
            
        }else{
            System.out.println("Player 1 score: " + player1_score);
            System.out.println("Player 2 score: " + player2_score + "\n");
            if(player1_score > player2_score){
                System.out.println("Player 1 WINS!");
            }else if(player2_score > player1_score){
                System.out.println("Player 2 WINS!");
            }else{
                
            }
        }
        
        System.out.println("Player2:");
        System.out.println("(1) Use the compass/range-finder to find the angle and distance to the hole");
        System.out.println("(2) Hit the ball,");
        System.out.println("(3) Quit the hole");
        int player2_input = cli.nextInt();
            
        if(player2_input == 1){
            if(charge2 > 0){
                    if(hole == 1){
                        System.out.println(hole1 - current2);
                    }
                    if(hole == 2){
                        System.out.println(hole2 - current2);
                    }
                    if(hole == 3){
                        System.out.println(hole3 - current2);
                    }
                    if(hole == 4){
                        System.out.println(hole4 - current2);
                    }
                    if(hole == 5){
                        System.out.println(hole5 - current2);
                    }
                    charge2--;
                    swampGolf(cli);
                }else{
                    System.out.println("battery out of charge...");
                    swampGolf(cli);
                }
        }else if(player2_input == 2){
            drivingRange(cli);
            current2 = current2 + horizon_dis;
            swampGolf(cli);
        }else{
            hole++;
            swampGolf(cli);
        }
    }
    public static void swampGolfEngineer(Scanner cli){
        
    }
    public static void game(Scanner cli){
        
    }
    public static void gameEngineer(Scanner cli){
        
    }
    public static int setDifficulty(Scanner cli){
        System.out.println("please enter difficulty number");
        System.out.println("(1)Low: hole radius 10ft");
        System.out.println("(2)Medium: hole radius 5ft");
        System.out.println("(3)High: hole radius 2ft");
        setDifficulty = cli.nextInt();
        if(setDifficulty == 1){
            rad = 10;
            return setDifficulty;
        }else if(setDifficulty == 2){
            rad = 5;
            return setDifficulty;
        }else if(setDifficulty == 3){
            rad = 2;
            return setDifficulty;
        }else{
            setDifficulty(cli);
        }
        return setDifficulty;
    }
    /////////////////////////////////////////////////////////
    public static void engineer(Scanner cli, int run){
        if (run == 1){
            user_input_point(cli);
            point1 = user_input_point.clone();

            user_input_point(cli);
            point2 = user_input_point.clone();
            engineering_1(cli, point1, point2);
            System.out.printf("Distance: "+"%.2f"+"\n", engineering_1);
        }else if(run == 2){
            user_input_point(cli);
            point1 = user_input_point.clone();
            
            user_input_point(cli);
            point2 = user_input_point.clone();
            engineering_2(cli, point1, point2);
            System.out.printf("Angle: "+"%.2f"+"deg"+"\n", engineering_2);
        }else if(run == 3){
            user_input_angle(cli);
            user_input_vel(cli);
            engineering_3(cli, angle, vel);
            System.out.printf("Distance: "+"%.2f"+"\n", horizon_dis);
        }else{
            user_input_point(cli);
            user_input_distance(cli);
            user_input_angle(cli);
            engineering_4(cli, point1, point2);
            System.out.printf("Point: "+"(%.2f,"+" %.2f)"+"\n", engineering_4[0], engineering_4[1]);
        }
        //restart after calc //edited for 5.2
        menu(cli);
    }
    public static double engineering_1(Scanner cli, double[] point1, double[] point2){
        
        double x1 = point1[0];
        double x2 = point2[0];
        double y1 = point1[1];
        double y2 = point2[1];

        double calc = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        
        engineering_1 = calc;
        //test
        //System.out.println(engineering_1);
        return engineering_1;
    }
    public static double engineering_2(Scanner cli, double[] point1, double[] point2){
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
        //System.out.println(engineering_2);
        return engineering_2;
    }
    public static double engineering_3(Scanner cli, double angle, double vel){        
        double angrad = angle * (Math.PI/180);
        double vi = vel *(FPM/SPH);
        horizon_dis = (vi*vi) * Math.sin(2*angrad) / GRAVITY;
        
        //test
        System.out.println(horizon_dis);
        return horizon_dis;
        
    }
    public static double[] engineering_4(Scanner cli, double[] point1, double[] point2){
        
        double angrad = angle * (Math.PI/180);
        double dx = distance * Math.cos(angrad);
        double dy = distance * Math.sin(angrad);
        
        engineering_4[0] = user_input_point[0] + dx;
        engineering_4[1] = user_input_point[1] + dy;
        
        //test
        //System.out.println("" + engineering_4[0] + " " + engineering_4[1]);
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
