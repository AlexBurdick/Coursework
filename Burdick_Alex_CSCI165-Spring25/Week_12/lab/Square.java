/*
 * File: Square.java
 * Author: Alex Burdick
 * Date: 04/21/25
 * 
 * Description: Class to represent a square and it's functions
 *              Sub class of Rectangle (which is sub class of Shape)
 */

import java.awt.Color;

public class Square extends Rectangle {
    
    // CONSTRUCTORS

    /**
     * No argument constuctor
     */
    public Square(){}

    /**
     * Overloaded constructor that accepts a length
     * 
     * @param 
     */
    public Square(double side) {
        super(side, side); // invoke super constructor
    }

    /**
     * Overloaded constructor that accepts all variables
     * @param length
     * @param filled
     * @param point
     */
    public Square(double side, Color color, boolean filled, Point point) {
        super(color, filled, point, side, side); // invoke super constructor
    }

    /**
     * Copy constructor to create a new Square object as a copy of an existing one. (Copilot)
     * 
     * @param originalSquare the Square object to copy
     */
    public Square(Square originalSquare) {
        super(originalSquare); // invoke the copy constructor of Rectangle
    }


    // GETTERS & SETTERS

    /**
     * Returns one side, could be height or length
     * 
     * @return one of the sides
     */
    public double getSide() {
        return height;
    }

    /**
     * Sets both vairables of rectangle to the same value to maitain a square
     * 
     * @param side
     */
    public void setSide(double side) {
        super.setHeight(side);
        super.setWidth(side);
    }

    /**
     * Sets the height and also the width to maitain a square
     * 
     * @param side
     */
    @Override
    public void setHeight(double side) {
        super.setHeight(side);
        super.setWidth(side);
    }

    /**
     * Sets the width and also the height to maitain a square
     * 
     * @param side
     */
    @Override
    public void setWidth(double side) {
        super.setHeight(side);
        super.setWidth(side);
    }


    // EXPECTED METHODS
    // No overriden equals method, the logic will be the same as Rectangle

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return super.toString() + "\nSquare [height=" + height + ", width=" + width + "]";
    }

    /**
     * Change the height and length base on the input percent. This cannot use the 
     * Rectangle resize because of the overriden setHeight and setWidth functions
     * in Square, which each set both dimensions. This means that the Rectangle resize()
     * would do the math on each side twice.
     * 
     * @param percent
     */
    @Override
    public void resize(int percent) {
        double percentage = ((double)percent)/100;
        setSide(height * percentage);
    }

}
