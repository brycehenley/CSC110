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

import java.lang.*;

public class Point {

    int x;
    int y;
    
    
    public void setLocation(int newX, int newY){
        x = newX;
        y = newY;
    }
    public void translate(int dx, int dy){
        x = x + dx;
        y = y + dy;
    }
    public double distance(Point p1, Point p2){
        //distance formula
        double distance = ((p2.x - p1.x)*(p2.x - p1.x))-((p2.y - p1.y)*(p2.y - p1.y));
        distance = Math.sqrt(distance);
        return distance;
    }
    public double distanceFromOrigin(Point p1){
        double distanceFromOrigin = Math.sqrt((p1.x - 0)*(p1.x - 0))-((p1.y - 0)*(p1.y - 0));
        return distanceFromOrigin;
    }
    
}
