/*
	File:	Driver.java
	Author:	Alex Burdick
	Date:	4/23/2025

 	Description: Tests for findLargest and totalArea methods in the Driver class
*/

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.ArrayList;

public class DriverTests {
    
    // Instantiate objects to test
    String msg = "";
	Color c1 = new Color(0, 0, 255);
	Point p1 = new Point(1,2);
	Point p2 = new Point(3,4);
	Circle circleOne = new Circle(c1, false, p1, 1);
    Circle circleTwo = new Circle(c1, true, p2, 2);
    Rectangle rectangleOne = new Rectangle(c1, false, p1, 1, 2);
	Rectangle rectangleTwo = new Rectangle(c1, true, p2, 3,5);
    Square squareOne = new Square(4, c1, false, p1);
    Square squareTwo = new Square(1, c1, true, p2);
    Circle largestShape = new Circle(c1, true, p2, 200);
    
    // Create an arraylist of different shape types
    ArrayList<Shape> shapes = new ArrayList<Shape>();
    {
        shapes.add(circleOne);
        shapes.add(circleTwo);
        shapes.add(rectangleOne);
        shapes.add(largestShape);
        shapes.add(rectangleTwo);
        shapes.add(squareOne);
        shapes.add(squareTwo);
    }
    
    @Test
    public void testFindLargest() {
        Shape largest = Driver.findLargest(shapes);
        assertEquals(largest, largestShape);
        System.out.println(largest);
    }

    @Test
    public void testTotalArea() {
        double expectedArea = circleOne.area() + 
                              circleTwo.area() + 
                              rectangleOne.area() + 
                              rectangleTwo.area() + 
                              squareOne.area() + 
                              squareTwo.area() + 
                              largestShape.area();
        double actualArea   = Driver.totalArea(shapes);
        msg = "Expected area = " + expectedArea + " | Actual area = " + actualArea;
        assertEquals(expectedArea, actualArea, 0.0001);
        
        System.out.println(msg);
    }
}
