package Lecture11.sandbox;

public class Lecture03 {

  public static void main(String[] args) {
    hello("world!");
    hello("Olga!");
    hello("user!");

    double c = 5;
    System.out.println("Area of square with sides " + c + " = " + area(c));

    double d = 4;
    double e = 6;
    System.out.println("Area of rectangle with sides " + d + " and " + e + " = " + area(d, e));
  }

  public static void hello(String a) {
    System.out.println("Hello, " + a);
  }

  public static double area(double b) {
    return b * b;
  }

  public static double area(double d, double e) {
    return d * e;
  }

}