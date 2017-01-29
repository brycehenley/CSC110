/*
 * Bryce Henley
 * CSC110AB
 * 01/28/2017
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
package program2_staircase;

public class Program2_Staircase {
    
    public static final int STAIRS = 5;
    
    public static void main(String[] args) {
        for (int stair = 1; stair <= STAIRS; stair++) {
           
            for(int spaces = STAIRS; spaces > stair; spaces--){
                spaces();
            }
            
            System.out.print("  o  ******");
            
            //adds spaces between stair and wall
            for(int spaces = 2; spaces<=stair; spaces++){
                spaces();
            }

            endofline();
            //newline
            System.out.println("");
            
            for(int spaces = STAIRS; spaces > stair; spaces--){
                spaces();
            }
            
            System.out.print(" /|\\ *     ");
            
            //adds spaces between stair and wall
            for(int spaces = 2; spaces<=stair; spaces++){
                spaces();
            }
            endofline();
            System.out.println("");
            
            for(int spaces = STAIRS; spaces > stair; spaces--){
                spaces();
            }
            
            System.out.print(" / \\ *     ");
            
            //adds spaces between stair and wall
            for(int spaces = 2; spaces<=stair; spaces++){
                spaces();
            }
            endofline();
            System.out.println("");
        }
    System.out.print("******");
        //floor
        for(int spaces = 2; spaces<=STAIRS+1; spaces++){
            floor();
        }
        endofline();
    }
    
    static void spaces(){
        System.out.print("     ");
    }
    static void endofline(){
        //MCP: end of line...
        System.out.print("*");
    }
    static void floor(){
        System.out.print("*****");
    }
    
}