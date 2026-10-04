/*
 * File: Circle.java
 * Author: Alex Burdick
 * Date: 04/21/25
 * 
 * Description: Class to represent a circle and it's functions
 *              Sub class of Shape
 */

import java.awt.Graphics2D;
import java.awt.Color;

public class Circle extends Shape {

	// ============== PROTECTED INSTANCE VARIABLES ================= //
    protected double radius;


	// ====================== CONSTRUCTORS ========================= //

    /**
     * No-argument constructor (package-private by default)
     */
    Circle(){}

    /**
     * Overloaded constructor that takes sets all variables
     * 
     * @param color
     * @param filled
     * @param point
     * @param radius
     */
    public Circle(Color color, boolean filled, Point point, double radius) {
        super(color, filled, point); // invoke super constructor
        setRadius(radius);
    }

    /**
     * Overloaded constructor that takes radius
     * 
     * @param radius
     */
    public Circle(double radius) {
        setRadius(radius);
    }

    /**
     * Copy constructor
     * 
     * @param toCopy Circle to be copied
     */
    public Circle(Circle originalObject) {
        super(originalObject); // invoke super constructor
        setRadius(originalObject.radius);
    }


	// =================== GETTERS AND SETTERS ====================== //

    /**
     * 
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * 
     * @param radius
     */
    public void setRadius(double radius) {
        if (radius > 0)  this.radius = radius;
    }


	// ====================== MATH METHODS ========================= //

    /**
     * Calculate the area of the circle
     * 
     * @return area
     */
    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * Calculate the permimeter of the circle
     * 
     * @return perimeter
     */
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }


	// ==================== EXPECTED METHODS ======================= //

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)        return true;  // identity check
        if (obj == null)        return false; // null check
        if (!super.equals(obj))               // super check
            return false;
        if (getClass() != obj.getClass())     // class check
            return false;
        
        Circle other = (Circle) obj; // down cast
        
        if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius)) // doubleToLongBits added by Copilot
            return false;
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return super.toString() + "\nCircle [radius=" + radius + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void drawObject (Graphics2D g2d) {
        // Find the position of the corner to start drawing, relative to the center of the circle (x,y)) {
        double cornerX = (point.x-radius);
        double cornerY = (point.y-radius);
        double side = radius * 2; // side length of the square

        // Set the color for the oval (circle)
        g2d.setColor(color);
	    
        // Draw the oval (circle) insisde of a square
        if (isFilled()) {
            g2d.fillOval((int)cornerX, (int)cornerY, (int)side, (int)side);
        } else {
            g2d.drawOval((int)cornerX, (int)cornerY, (int)side, (int)side);
        }
    }

    /**
     * Compute the distance from the center of the circle to a given point.
     * 
     * @param point the point to compute the distance to
     * @return the distance from the center of the circle to the given point
     */
    @Override
    public double computeDistance(Point point) {
        return Point.distance(this.point, point) - radius;
    }

} // end Circle class
