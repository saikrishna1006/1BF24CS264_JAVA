import java.util.Scanner;
abstract class Shape {
    int a, b;
    Shape(int a, int b) {
        this.a = a;
        this.b = b;
    }
    abstract void printArea();
}

class Rectangle extends Shape {
    Rectangle(int length, int breadth) {
        super(length, breadth);
    }

    void printArea() {
        int area = a * b;
        System.out.println("Area of rectangle is : " + area);
    }
}

class Triangle extends Shape {
    Triangle(int base, int height) {
        super(base, height);
    }
    void printArea() {
        double area = 0.5 * a * b;
        System.out.println("Area of triangle : " + area);
    }
}

class Circle extends Shape {
    Circle(int radius) {
        super(radius,0); 
    }

    void printArea() {
        double area = 3.14 * a * a;
        System.out.println("Area of rectangle : " + area);
    }
}

public class Area {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter dimension of rectangle(length,breadth)");
        int len = s.nextInt();
        int bre = s.nextInt();
        Rectangle ob = new Rectangle(len, bre);

        System.out.println("Enter dimension of triangle(base,height)");
        int bas = s.nextInt();
        int hei = s.nextInt();        
        Triangle ob1 = new Triangle(bas, hei);

        System.out.println("Enter dimension of circle(radius)");
        int r = s.nextInt();           
        Circle ob2 = new Circle(r);

        ob.printArea();
        ob1.printArea();
        ob2.printArea();
    }
}
