/*
 * Bryce Henley
 * CSC110AB
 * 04/04/2017
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
package point;

public class Point {

    int x;
    int y;
    
    public int distance;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Point p1 = new Point();
        Point p2 = new Point();
        
        p1.setLocation(0, 0);
        p2.setLocation(1, 4);
        
    }
    public void setLocation(int newX, int newY){
        x = newX;
        y = newY;
    }
    public void translate(int dx, int dy){
        x = x + dx;
        y = y + dy;
    }
    public int distance(Point p1, Point p2){
        //distance formula
        distance = ((p2.x - p1.x)*(p2.x - p1.x))-((p2.y - p1.y)*(p2.y - p1.y));
        return distance;
    }
    
}
