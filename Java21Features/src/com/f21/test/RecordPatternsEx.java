package com.f21.test;

public class RecordPatternsEx {
	record Point(int x, int y) {}
	
	interface Shape {}
	record Circle(double radius) implements Shape { }
	record Square(double side) implements Shape { }
	record Rectangle(double length, double width) implements Shape { }
	record Triangle(double side1, double side2, double side3) implements Shape { }
	
	public static int beforeRecordPattern(Object obj) {
	    int sum = 0;
	    if(obj instanceof Point p) {
	        int x = p.x();
	        int y = p.y();
	        sum = x+y;
	    }
	    return sum;
	}
	    
	public static int afterRecordPattern(Object obj) {
	    if(obj instanceof Point(int x, int y)) {
	        return x + y;
	    }
	    return 0;
	}
	
	public static void switchShape(Shape shape) {
		switch(shape) {

		  case Circle(double radius):
		    System.out.println("The shape is Circle with area: " + Math.PI * radius * radius);
		    break;

		  case Square(double side):
		    System.out.println("The shape is Square with area: " + side * side);
		    break;

		  case Rectangle(double length, double width):
		    System.out.println("The shape is Rectangle with area: + " + length * width);
		    break;

		  default:
		    System.out.println("Unknown Shape: " + shape);
		    break;
		}
	}
	
	public static void main(String[] args) {
		Point point = new Point(10, 20);
		//Point point = new Point(10, 20);
		int sum1 = beforeRecordPattern(point);
		System.out.println("Sum 1: " + sum1);
		int sum2 = afterRecordPattern(point);
		System.out.println("Sum 2: " + sum2);
		/*
		 * Shape circle = new Shape("Circle", 10); System.out.println(circle.type());
		 * System.out.println(circle.unit()); System.out.println(circle); if (circle
		 * instanceof Shape(String type, long unit)) { System.out.println("Area of " +
		 * type + " is : " + Math.PI * Math.pow(unit, 2)); } if (circle instanceof Shape
		 * shape) { System.out.println("Area of " + shape.type() + " is : " + Math.PI *
		 * Math.pow(shape.unit(), 2)); }
		 */
		Shape circle = new Circle(10);
		Shape square = new Square(22);
		Shape rectangle = new Rectangle(10, 22);
		Shape triangle = new Triangle(12, 10, 15);
		Object polygon = new Object();
		switchShape(circle);
		switchShape(square);
		switchShape(rectangle);
		switchShape(triangle);
		switchShape((Shape) polygon);
		
	}

}
