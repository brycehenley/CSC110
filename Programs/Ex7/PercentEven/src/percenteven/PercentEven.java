/*
 * Bryce Henley
 * CSC110AB
 * 03/28/2017
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
package percenteven;

public class PercentEven {
    
    //param
    public static int[] ary = {2, 2, 3};
    public static int percentEven;
    
    public static void main(String[] args) {
        
        percentEven(ary);
        System.out.println(percentEven + "%");
    }
    public static int percentEven(int[] ary){
        
        int total = ary.length;
        double even = 0;
        
        for (int i = 0; i <= ary.length-1; i++){
            if (ary[i]%2 == 0){
                even++;
            }else{
                
            }
        }
        
        percentEven = (int)((even/total)*100);
        
        return percentEven;
    }
    
}
