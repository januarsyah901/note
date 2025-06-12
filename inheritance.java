abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    public void displayInfo() {
        System.out.print(getClass().getSimpleName() + " - Color: " + color);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println();
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle("Red", 7.0);
        Shape rectangle = new Rectangle("Blue", 5.0, 3.0);
        
        circle.displayInfo();
        System.out.println("Area: " + circle.calculateArea());
        System.out.println("Perimeter: " + circle.calculatePerimeter());
        
        rectangle.displayInfo();
        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
        
        /* Output:
           Circle - Color: Red
           Area: 153.93804002589985
           Perimeter: 43.982297150257104
           Rectangle - Color: Blue
           Area: 15.0
           Perimeter: 16.0
        */
    }
}
