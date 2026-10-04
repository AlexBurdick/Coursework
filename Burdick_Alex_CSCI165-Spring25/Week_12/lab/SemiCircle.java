/*
 * File: SemiCircle.java
 * Author: Alex Burdick
 * Date: 04/23/25
 * 
 * Description: Class to represent a semi circle and it's functions
 *              Sub class of Circle
 */

 import java.awt.Color;

public class SemiCircle extends Circle {

    // CONSTRUCTORS

    /**
     * No-argument constructor (package-private by default)
     */
    SemiCircle(){}

    /**
     * Contstructor that takes radius only
     * 
     * @param radius
     */
    public SemiCircle(double radius) {
        super(radius); // invokes super constructor
    }

    /**
     * Contstructor that takes all fields as arguments
     * 
     * @param radius
     */
    public SemiCircle(Color color, boolean filled, Point point, double radius) {
        super(color, filled, point, radius); // invoke super constructor        
    }

    /**
     * Copy constructor
     * 
     * @param SemiCircle to be copied
     */
    public SemiCircle(SemiCircle toCopy) {
        super(toCopy);
    }


    // MATH METHODS

    /**C
     * Calculate the area of the semi-circle
     * 
     * @return area
     */
    @Override
    public double area() {
        return (Math.PI * Math.pow(radius, 2)) / 2;
    }

    /**
     * Calculate the permimeter of the semi-circle
     * 
     * @return perimeter
     */
    @Override
    public double perimeter() {
        return Math.PI * radius + 2 * radius;
    }


    // EXPECTED METHODS

    /**
     * Convert object to String
     * 
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + "\nSemi-circle [radius=" + radius + "]";
    }
}
