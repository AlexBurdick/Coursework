/*
 * File: Driver.java
 * Author: Alex Burdick
 * Date: 04/21/25
 * 
 * Description: Interface for Shapes project
 */

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    
    /**
     * The main method serves as the entry point for the program. It demonstrates the use of 
     * various Shape objects (Circle, Rectangle, Square), their methods, and polymorphism. 
     * It also calls methods from the lab assignment. (Copilot)
     * 
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        Point p = new Point(1, 2);
        Color c = new Color(255, 255, 0);
        Shape s1 = new Circle(c, false, p, 5.5);

        System.out.println(s1);     // This will run the toString in Circle, the JVM knows that 
                                    // the Circle constructor was used to create s1 using dynamic 
                                    // method dispatch (or late binding).
        System.out.println(s1.area());      // Circle (overriden from abstract method in Shape)
        System.out.println(s1.perimeter()); // Circle (overriden from abstract method in Shape)
        System.out.println(s1.getColor());  // Shape
        System.out.println(s1.isFilled());  // Shape
        // s1 was called with the Circle constructor, but because it was declared as a class 
        // Shape, it will only see members of Shape. The getRadius method is in the Circle
        // class, and therefor cannot be invoke by s1.
        // System.out.println(s1.getRadius()); // Error: The method getRadius() is undefined for the type ShapeJava(67108964)
    
        Circle c1 = (Circle)s1;     // down cast s1 to a Circle - it can do this because the Circle 
                                    // constructor was used to create it.
        System.out.println(c1); 
        System.out.println(c1.area());      // Circle
        System.out.println(c1.perimeter()); // Circle
        System.out.println(c1.getColor());  // inherited from Shape
        System.out.println(c1.isFilled());  // inherited from Shape
        System.out.println(c1.getRadius()); // now s1 can invoke methods in the Circle class
    
        Shape s3 = new Rectangle(c, false, p, 1.0, 2.0); 
        System.out.println(s3);             // toString of Rectangle
        System.out.println(s3.area());      // Rectangle
        System.out.println(s3.perimeter()); // Rectangle
        System.out.println(s3.getColor());  // inherited from Shape
        // This is the same issue is s1 - s3 is cast as a Shape, which does not have a 
        // getWidth method. s3 would have to be cast as a Rectangle for it to be used to
        // invoke getWidth.
        // System.out.println(s3.getWidth()); // The method getWidth() is undefined for the type ShapeJava(67108964)
    
        Rectangle r1 = (Rectangle)s3;       // down cast to Rectangle 
        System.out.println(r1);             // toString of Rectangle
        System.out.println(r1.area());      // Recatangle
        System.out.println(r1.getColor());  // inherited from Shape
        System.out.println(r1.getHeight()); // Rectangle (not overriden, this is not a Shape method)
    
        Shape s4 = new Square(6.6);    // Square constructor, cast as a Shape 
        System.out.println(s4);             // Square
        System.out.println(s4.area());      // Rectangle
        System.out.println(s4.getColor());  // Shape
        // System.out.println(s4.getSide());// not avialalbe to a Shape object, s4 would need to
                                            // to be cast as a Square to access this method
 
        Rectangle r2 = (Rectangle)s4;       // down cast to a rectangle 
        System.out.println(r2);             // still uses the Square toString
        System.out.println(r2.area());      // Rectangle
        System.out.println(r2.getColor());  // Shape
        System.out.println(r2.getHeight()); // Square
        System.out.println(r2.getWidth());  // Square
    
        //Shape s2 = new Shape(); // Error: Cannot instantiate the type ShapeJava(16777373)
                                  // Shape is abstract which means you cannot instantiate it directly
                                  // A sub class can invoke the Shape constructor, and a sub class can
                                  // be cast as a Shape, but java will no compile new Shape constructor.
        Square sq1 = (Square)r2; 
        System.out.println(sq1); 
        System.out.println(sq1.area());     // Square (overridden of abstrat Shape method)
        System.out.println(sq1.getColor()); // inherited from Shape
        System.out.println(sq1.getSide());  // Square
        System.out.println(sq1.getWidth()); // Square (overriden of Rectangle method)
        
        // Create new shapes
        Triangle t1 = new Triangle(c, false, p, 2, 3); // instantiate a Triangle object
        SemiCircle sc1 = new SemiCircle(c, true, p, 10); // instantiate a SemiCircle object
        
        // Create an arraylist of different shape types
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(c1);     // Circle
        shapes.add(r1);     // Rectangle
        shapes.add(sq1);    // Square
        shapes.add(t1);     // Triangle
        shapes.add(sc1);    // Semi-circle

        System.out.println("Largest: " + findLargest(shapes));
        System.out.println("Total Area: " + totalArea(shapes));

        // Create an arraylist of different shape types and cast them as Resizable type
        ArrayList< Resizable > resizables = new ArrayList<Resizable>();
        resizables.add(c1); // Circle
        resizables.add(r1); // Rectangle
        resizables.add(sq1);// Square
        resizables.add(t1); // Triangle
        resizables.add(sc1);// Semi-circle
        resize(resizables, 50);
    }

    /**
     * Finds the shape with the largest area from a list of shapes. (Copilot)
     * 
     * @param shapes an ArrayList of Shape objects to search through
     * @return the Shape object with the largest area, or null if the list is empty
     */
    public static Shape findLargest( ArrayList< Shape > shapes) {
        
        // Placeholder for area
        double area = 0;
        // Placeholder for the largest shape, starts with first shape in the arraylist
        Shape largestShape = shapes.get(0);

        // For-each loop to go through shapes
        for (Shape s : shapes) {
            double temp = s.area(); // store area of current shape
            
            // if the area of the  new shape is lareger than the previous largest area,
            // set area equal to it and set the largestShape to the current shape
            if (temp > area) {
                area = temp;
                largestShape = s;
            }
        }
        return largestShape;
    }

    /**
     * Calculates the total area of all shapes in the given list. (Copilot)
     * 
     * @param shapes an ArrayList of Shape objects to calculate the total area for
     * @return the sum of the areas of all shapes in the list as a double
     */
    public static double totalArea( ArrayList< Shape > shapes) {
        System.out.println("TOTAL AREA TEST");

        double totalArea = 0;       // placeholder for area
        
        for (Shape s : shapes)      // for-each loop to go through shapes

            totalArea += s.area();  // add area of current Shape to total area
                                    // Even though the object type is Shape, the overriden area() method
                                    // in the sub class will be invoked.
        
        return totalArea;           // return the sum of all Shape areas
    }


    /**
     * Resizes all Resizable objects in the given list by the specified percentage.
     * 
     * @param resizables an ArrayList of Resizable objects to resize
     * @param percent    the percentage by which to resize each object
     */
    public static void resize( ArrayList< Resizable > resizables, int percent ) {
        System.out.println("\n------------------------");
        System.out.println("RESIZE TEST");
        System.out.println("------------------------");

        // Get user input for the percentage (this block written by Copilot)
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a positive integer for the resize percentage: ");
            percent = scanner.nextInt();
        }
        
        for (Resizable r : resizables) {
            System.out.println("Original:");
            System.out.println(r);
            r.resize(percent);
            System.out.println("Resized:");
            System.out.println(r + "\n");
        }
    }
}
