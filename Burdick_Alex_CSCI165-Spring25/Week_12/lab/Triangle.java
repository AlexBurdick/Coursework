/*
 * File: Rectangle.java
 * Author: Alex Burdick
 * Date: 04/23/25
 * 
 * Description: Class to represent a right Triangle and it's functions
 *              Sub class of Shape
 */

import java.awt.Color;

public class Triangle extends Shape implements Resizable {
    
    // INSTANCE VARIABLES
    protected double base;
    protected double height;
    

    // CONSTRUCTORS

    /**
     * Default constructor
     */
    Triangle(){}
    
    /**
     * Constructs a Triangle with the specified base and height. (Copilot)
     * 
     * @param base   the base length of the triangle
     * @param height the height of the triangle
     */
    public Triangle(double base, double height) {
        setBase(base);
        setHeight(height);
    }

    /**
     * Constructs a Triangle with the specified color, filled status, location,
     * base, and height. (Copilot)
     * 
     * @param color   the color of the triangle
     * @param filled  true if the triangle is filled, false otherwise
     * @param point   the location of the triangle as a Point object
     * @param base    the base length of the triangle
     * @param height  the height of the triangle
     */
    public Triangle(Color color, boolean filled, Point point, double base, double height) {
        super(color, filled, point);
        setBase(base);
        setHeight(height);
    }

    /**
     * Constructs a Triangle as a copy of an existing Shape object, with the 
     * specified base and height. (Copilot)
     * 
     * @param originalObject the Shape object to copy
     * @param base           the base length of the triangle
     * @param height         the height of the triangle
     */
    public Triangle(Triangle originalObject) {
        super(originalObject);
        setBase(originalObject.base);
        setHeight(originalObject.height);
    }


    // GETTERS & SETTERS

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    // MATH METHODS

    /**
     * Calculates the area of the triangle using the formula:
     * 0.5 * base * height. (Copilot)
     * 
     * @return the area of the triangle as a double
     */
    @Override
    public double area() {
        return 0.5 * base * height;
    }

    /**
     * Calculates the perimeter of the triangle, assuming that it is a right
     * triangle. (Method by Copilot)
     * 
     * @return the perimeter of the triangle as a double
     */
    @Override
    public double perimeter() {
        // Assuming the triangle is a right triangle, calculate the hypotenuse
        double hypotenuse = Math.sqrt((base * base) + (height * height));
        return base + height + hypotenuse;
    }

    
    // EXPECTED METHODS
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)        return true;  // idenetity check
        if (obj == null)        return false; // null check
        if (!super.equals(obj))               // super check
            return false;
        if (getClass() != obj.getClass())     // class check
            return false;

        Triangle other = (Triangle) obj; // down cast

        if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
            return false;
        if (Double.doubleToLongBits(base) != Double.doubleToLongBits(other.base))
            return false;
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return super.toString() + "\nTriangle [height=" + height + ", base=" + base + "]";
    }

    /**
     * Change the base and height based on the input percent
     * 
     * @param percent
     */
    @Override
    public void resize(int percent) {
        if (percent >= 0) {
            double percentage = ((double)percent)/100;
            setHeight(height * percentage);
        }
    }
}
