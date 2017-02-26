/*
 * Bryce Henley
 * CSC110AB
 * 02/14/2017
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
package startmotorcycle;

import java.util.*;

public class StartMotorcycle {
    //various endings controled by state machine
    public static int engineState; //0: off //1: putters, //2: on
    public static boolean brakeState;
    public static boolean kickstandState;
    public static int mountState; //0: not mounted //1: mounted //2: precariously mounted
    public static int carbkeyState; //0 off //1:on //2:reserve
    public static boolean keyinsertState;
    public static int chokeState;
    public static boolean killswitchState;
    public static boolean enginestartState;

    public static void main(String[] args) {

        //Initialize variables


        //Initialize Scanner Object
        Scanner cli = new Scanner(System.in);

        //promt user
        System.out.println("It is cold outside and you must start a carborated motorcycle according to standard procedure");
        
        keyinsertState(cli);
        brakeState(cli);
        //System.out.println("" + brakeState);
        mountState(cli);
        kickstandState(cli);
        carbkeyState(cli);
        chokeState(cli);
        killswitchState(cli);
        enginestartState(cli);
        printResult();

    }
    public static void printResult(){
        if(killswitchState == false || carbkeyState == 0 || enginestartState == false || keyinsertState == false || chokeState == 0){
            engineState = 0;
        }else if(chokeState == 1){
            engineState = 1;
        }else{
            engineState = 2;
        }
             
        //engine start
        if(engineState == 0){
            System.out.print("The engine fails to start");
        }else if(engineState == 1){
            System.out.print("The engine slowly putters to life");
        }else{
            System.out.print("The engine roars to life");
        }
        //mounted
        if(mountState == 0){
            System.out.print(" as you stand beside the bike" + "\n");
        }else if(mountState == 1){
            System.out.print(" as you mount the bike" + "\n");
        }else{
            System.out.print(" as you precariously mount the bike" + "\n");
        }
        
        if(engineState == 1 || engineState == 2){
            System.out.println("Warning: It is now recomended that you give time for the engine to warm to normal operating temperature before stressing it");
        }else{
            
        }
    }
    
    public static boolean keyinsertState(Scanner cli){
        System.out.println("Insert key (y/n)");
        
        String key = cli.next();
        char ckey = key.charAt(0);
        
        if(ckey == 'y'){
            System.out.println("Turn key (lock, off, on)");
            String turnkey = cli.next();
            String ctkey = turnkey.toLowerCase();
            
            if(ctkey.equals("on")){
                keyinsertState = true;
            }else{
                keyinsertState = false;
            }
        }else if(ckey == 'n'){
            keyinsertState = false;
        }else{
            keyinsertState(cli);
        }
        return keyinsertState;
    }
    public static boolean brakeState(Scanner cli){
        System.out.println("pull front brake? (y/n)");
        String brake = cli.next();
        char cbrake = Character.toLowerCase(brake.charAt(0));
        
        if(cbrake == 'y'){
            brakeState = true;
        }else if(cbrake == 'n'){
            brakeState = false;
        }else{
            brakeState(cli);
        }
        
        return brakeState;
    }
    public static int mountState(Scanner cli){
        System.out.println("mount bike? (y/n)");
        
        String mount = cli.next();
        char cmount = Character.toLowerCase(mount.charAt(0));
        
        if(cmount == 'y'){
            if(brakeState == true){
                mountState = 1;
            }else{
                mountState = 2;
            }
        }else if(cmount == 'n'){
            mountState = 0;
        }else{
            mountState(cli);
        }
        return mountState;
    }
    public static boolean kickstandState(Scanner cli){
        System.out.println("flip up kickstand? (y/n)");
        String kickstand = cli.next();
        char ckickstand = Character.toLowerCase(kickstand.charAt(0));
        
        if (ckickstand == 'y'){
            kickstandState = true;
        }else if (ckickstand == 'n'){
            kickstandState = false;
        }else{
            kickstandState(cli);
        }
        return kickstandState;
    }
    public static int carbkeyState(Scanner cli){
        
        System.out.println("Turn carb key? (off, on, reserve)");
        
        String carbkey = cli.next();
        String ccarbkey = carbkey.toLowerCase();
        
        if(ccarbkey.equals("off")){
            carbkeyState = 0;
        }else if(ccarbkey.equals("on")){
            carbkeyState = 1;
        }else if(ccarbkey.equals("reserve")){
            carbkeyState = 2;
        }else{
            carbkeyState(cli);
        }
        return carbkeyState;
    }
    public static int chokeState(Scanner cli){
        
        System.out.println("Pull choke? (no, partial, full)");
        
        String choke = cli.next();
        String cchoke = choke.toLowerCase();
        
        if(cchoke.equals("full")){
            chokeState = 2;
        }else if(cchoke.equals("partial")){
            chokeState = 1;
        }else if(cchoke.equals("no")){
            chokeState = 0;
        }else{
            chokeState(cli);
        }
        return chokeState;
    }
    public static boolean killswitchState(Scanner cli){
        System.out.println("flip kill switch (y/n)");
        
        String killswitch = cli.next();
        char ckillswitch = Character.toLowerCase(killswitch.charAt(0));
        
        if(ckillswitch == 'y'){
            killswitchState = true;
        }else if(ckillswitch == 'n'){
            killswitchState = false;
        }else{
            killswitchState(cli);
        }
        return killswitchState;
    }
    public static boolean enginestartState(Scanner cli){
        System.out.println("Press engine start button? (y/n)");
        
        String enginestart = cli.next();
        char cenginestart = Character.toLowerCase(enginestart.charAt(0));
        
        if(cenginestart == 'y'){
            enginestartState = true;
        }else if(cenginestart == 'n'){
            enginestartState = false;
        }else{
            enginestartState(cli);
        }
        return enginestartState;
    }
}
