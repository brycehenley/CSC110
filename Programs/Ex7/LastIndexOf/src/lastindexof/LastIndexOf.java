/*
 * Bryce Henley
 * CSC110AB
 * 03/21/2017
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
package lastindexof;

import java.util.*;

public class LastIndexOf {
    
public static int lastIndexOf;

    public static void main(String[] args) {
        
        Scanner cli = new Scanner(System.in);
        
        System.out.println("enter aray length:");
        int length = cli.nextInt();
        
        int[] ary = new int[length];
        for(int i = 0; i <= length - 1; i++){
            System.out.println("enter index[" + i + "]");
            ary[i] = cli.nextInt();
        }

        
        
        System.out.println("enter target:");
        
        int target = cli.nextInt();
        
        lastIndexOf(target, ary);
        
        System.out.println("the last index of the value is: " + lastIndexOf);
    }
    public static int lastIndexOf(int target, int[] ary){
        lastIndexOf = -1;
        for(int i = ary.length-1; i>=0; i--){
            if(ary[i] == target){
                lastIndexOf = i;
                return lastIndexOf; 
            }
        }
        return lastIndexOf;
    }
    
}
