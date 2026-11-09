package it.polito.main.Inheritance;
/*
 TOPICS: abstract classes/methods, Template Method pattern, Composite pattern.
*/
abstract class Shape {
    abstract double area(); // child classes must implement this method

    // Template Method: fixed sequence; area() is supplied by each child.
    public final void printInformation() {
        System.out.println("Area = " + area());
    }
}

class Circle extends Shape {
    private double radius;
    Circle(double radius) { this.radius = radius; }
    @Override double area() { return Math.PI * radius * radius; }
}

class Rectangle extends Shape {
    private double width, height;
    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    @Override double area() { return width * height; }
}

// Composite: a large expression is built from smaller expressions of same type.
interface Expression { int evaluate(); }

class NumberExpression implements Expression {
    private int value;
    NumberExpression(int value) { this.value = value; }
    @Override public int evaluate() { return value; }
}

class AdditionExpression implements Expression {
    private Expression left, right;
    AdditionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    @Override public int evaluate() {
        return left.evaluate() + right.evaluate();
    }
}

class ShapeExamples {
    static void run() {
        // Shape s = new Shape(); // ERROR: abstract class cannot be instantiated.
        Shape circle = new Circle(2);
        Shape rectangle = new Rectangle(4, 3);
        circle.printInformation();
        rectangle.printInformation();

        Shape[] shapes = {new Circle(1), new Rectangle(5, 2)};
        for (Shape s : shapes) s.printInformation();

        // Represents (10 + 20) + 5.
        Expression expression = new AdditionExpression(
            new AdditionExpression(new NumberExpression(10),
                                   new NumberExpression(20)),
            new NumberExpression(5));
        System.out.println("Expression result: " + expression.evaluate());
    }
}
