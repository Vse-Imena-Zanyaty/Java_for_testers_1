package Lecture11.sandbox;

public class Lecture03 {

  public static void main(String[] args) {
    hello("world!");
    hello("Olga!");
    hello("user!");

    Square s = new Square(5.0);
    System.out.println("Area of square with sides " + s.a + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Area of rectangle with sides " + r.a + " and " + r.b + " = " + r.area());

    Point p1 = new Point(-4, 8);
    Point p2 = new Point(22, -7);
    System.out.println("Distance between points p1 and p2 = " + p1.distance(p2));
  }

  public static void hello(String a) {
    System.out.println("Hello, " + a);
  }

}