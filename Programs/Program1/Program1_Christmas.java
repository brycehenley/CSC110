/*
* Bryce Henley
* CSC110AB
* 1/24/2017
* Program1_Christmas
* A simple program that prints the lyrics to the song "12 Days of Christmas"
*/

/*
*
*  MIT License
*
*  Copyright (c) 2017 Bryce Henley
*
*  Permission is hereby granted, free of charge, to any person obtaining a copy
*  of this software and associated documentation files (the "Software"), to deal
*  in the Software without restriction, including without limitation the rights
*  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
*  copies of the Software, and to permit persons to whom the Software is
*  furnished to do so, subject to the following conditions:
*
*  The above copyright notice and this permission notice shall be included in all
*  copies or substantial portions of the Software.
*
*  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
*  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
*  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
*  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
*  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
*  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
*  SOFTWARE.
*
*/

public class Program1_Christmas{

  public static void main(String[] args){
  System.out.println("On the first day of Christmas");
  Program1_Christmas.secl();
  System.out.println("A Partridge in a Pear Tree");
    System.out.println("");

  System.out.println("On the second day of Christmas");
  Program1_Christmas.secl();
  Program1_Christmas.secondday();

  System.out.println("On the third day of Christmas");
  Program1_Christmas.secl();
  Program1_Christmas.thirdday();

  System.out.println("On the fourth day of Christmas");
  Program1_Christmas.secl();
  Program1_Christmas.fourthday();

  System.out.println("On the fifth day of Christmas");
  Program1_Christmas.secl();
  Program1_Christmas.fifthday();

  System.out.println("On the sixth day of Christmas");
  Program1_Christmas.secl();
  Program1_Christmas.sixthday();

  System.out.println("On the seventh day of Christmas");
  Program1_Christmas.secl();
  Program1_Christmas.seventhday();

  System.out.println("On the eighth day of Christmas");
  Program1_Christmas.secl();
  Program1_Christmas.eighthday();

  System.out.println("On the nineth day of Christmas");
  Program1_Christmas.secl();
  Program1_Christmas.ninethday();

  System.out.println("On the tenth day of Christmas");
  Program1_Christmas.secl();
  Program1_Christmas.tenthday();

  System.out.println("On the eleventh day of Christmas");
  Program1_Christmas.secl();
  Program1_Christmas.eleventhday();

  System.out.println("On the twelfth day of Christmas");
  Program1_Christmas.secl();
  Program1_Christmas.twelfthday();
  }



  static void secl(){
    System.out.println("my true love sent to me:");
  }
  static void firstday(){
    System.out.println("and a Partridge in a Pear Tree");
    System.out.println("");
  }
  static void secondday(){
    System.out.println("Two Turtle Doves");
    Program1_Christmas.firstday();
  }
  static void thirdday(){
    System.out.println("Three French Hens");
    Program1_Christmas.secondday();
  }
  static void fourthday(){
    System.out.println("Four Calling Birds");
    Program1_Christmas.thirdday();
  }
  static void fifthday(){
    System.out.println("Five Golden Rings");
    Program1_Christmas.fourthday();
  }
  static void sixthday(){
    System.out.println("Six Geese a Laying");
    Program1_Christmas.fifthday();
  }
  static void seventhday(){
    System.out.println("Seven Swans a Swimming");
    Program1_Christmas.sixthday();
  }
  static void eighthday(){
    System.out.println("Eight Maids a Milking");
    Program1_Christmas.seventhday();
  }
  static void ninethday(){
    System.out.println("Nine Ladies Dancing");
    Program1_Christmas.eighthday();
  }
  static void tenthday(){
    System.out.println("Ten Lords a Leaping");
    Program1_Christmas.ninethday();
  }
  static void eleventhday(){
    System.out.println("Eleven Pipers Piping");
    Program1_Christmas.tenthday();
  }
  static void twelfthday(){
    System.out.println("12 Drummers Drumming");
    Program1_Christmas.tenthday();
  }

}
