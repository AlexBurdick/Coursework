/*
 * File: Rectangle.java
 * Author: Alex Burdick
 * Date: 04/21/25
 * 
 * Description: Class to represent a rectangle and it's functions
 *              Sub class of Shape
 */

import java.awt.Color;

public class Rectangle extends Shape implements Resizable{

    // INSTANCE VARIABLES
    protected double height;
    protected double width;


    // CONSTRUCTORS

    /**
     * No-argument constructor
     */
    public Rectangle(){}

    /**
     * Overloaded constructor accepting height and width fields
     * 
     * @param height
     * @param width
     */
    public Rectangle(double height, double width) {
        setHeight(height);
        setWidth(width);
    }

    /**
     * Overloaded constructor accepting all fields
     * 
     * @param color
     * @param filled
     * @param point
     * @param height
     * @param width
     */
    public Rectangle(Color color, boolean filled, Point point, double height, double width) {
        super(color, filled, point); // invoke super constructor
        setHeight(height);
        setWidth(width);
    }

    /**
     * Copy constructor
     * 
     * @param toCopy Rectangle to be copied
     */
    public Rectangle(Rectangle originalObject) {
        super(originalObject); // invoke constructor
        setHeight(originalObject.height);
        setWidth(originalObject.width);
    }


    // GETTERS & SETTERS

    /**
     * 
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * 
     * @param height
     */
    public void setHeight(double height) {
        if (height > 0)  this.height = height;
    }

    /**
     * 
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * 
     * @param width
     */
    public void setWidth(double width) {
        if (width > 0)  this.width = width;
    }

    
    // MATH METHODS
    
    /**
     * Calculate the area of the Rectangle
     * 
     * @return area of Rectangle
     */
    @Override
    public double area() {
        return height * width;
    }

    /**
     * Calculate the perimeter of the Rectangle
     * 
     * @return perimeter of Rectangle
     */
    @Override
    public double perimeter() {
        return 2 * height + 2 * width;
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

        Rectangle other = (Rectangle) obj; // down cast

        if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
            return false;
        if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
            return false;
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return super.toString() + "\nRectangle [height=" + height + ", width=" + width + "]";
    }

    /**
     * Change the height and width based on the input percent
     * 
     * @param percent
     */
    @Override
    public void resize(int percent) {
        if (percent >= 0) { 
            double percentage = ((double)percent)/100;
            setHeight(height * percentage);
            setWidth(width * percentage);
        }
    }

} // end Rectangle class
