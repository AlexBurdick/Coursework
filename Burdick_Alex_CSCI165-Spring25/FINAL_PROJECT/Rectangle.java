/*
 * File: Rectangle.java
 * Author: Alex Burdick
 * Date: 04/21/25
 * 
 * Description: Class to represent a rectangle and it's functions
 *              Sub class of Shape
 */

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Rectangle extends Shape {

	// ============== PROTECTED INSTANCE VARIABLES ================= //
    protected double height;
    protected double width;


	// ====================== CONSTRUCTORS ========================= //

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


	// =================== GETTERS AND SETTERS ====================== //

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

    
    // ====================== MATH METHODS ========================= //

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


	// ==================== EXPECTED METHODS ======================= //

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
     * {@inheritDoc}
     */
    @Override
    public void drawObject(Graphics2D g2d) {

        // Set the color for the rectagle
        g2d.setColor(color);

        // Draw the rectangle
        if (isFilled()) {
            g2d.fillRect((int)point.x, (int)point.y, (int)width, (int)height);
        } else {
            g2d.drawRect((int)point.x, (int)point.y, (int)width, (int)height);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override  
    public double computeDistance(Point cameraPosition) {
        // Create Points for the rectangle
        Point2D.Double topLeft     = new Point2D.Double(point.x, point.y);
        Point2D.Double topRight    = new Point2D.Double(point.x + width, point.y);
        Point2D.Double bottomLeft  = new Point2D.Double(point.x, point.y + height);
        Point2D.Double bottomRight = new Point2D.Double(point.x + width, point.y + height);

        // Create Lines for the rectangle
        Line2D.Double[] rectangleLines = new Line2D.Double[4];
        rectangleLines[0] = new Line2D.Double(topLeft, topRight);
        rectangleLines[1] = new Line2D.Double(topRight, bottomRight);
        rectangleLines[3] = new Line2D.Double(bottomRight, bottomLeft);
        rectangleLines[2] = new Line2D.Double(bottomLeft, topLeft);
        
        // Calculate the distance from the camera to each line
        double minDistance = Double.MAX_VALUE; // suggested by Copilot
        double distance = 0;
        for (Line2D.Double line : rectangleLines) {
            distance = line.ptSegDist(cameraPosition.x, cameraPosition.y);
            if (distance < minDistance) {
                minDistance = distance;
            }
        }
        // Calculate the distance from the camera to the rectangle
        return minDistance;
    }

} // end Rectangle class
