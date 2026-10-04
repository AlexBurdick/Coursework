/*
 * File: Shape.java
 * Author: Alex Burdick
 * Date: 04/21/25
 * 
 * Description: Shape parent class
 */

import java.awt.Graphics2D;
import java.awt.Color;

public abstract class Shape implements Drawable{
    
	// ============== PROTECTED INSTANCE VARIABLES ================= //
    protected Color color;
    protected boolean filled;
    protected Point point;
    

	// ====================== CONSTRUCTOCRS ========================= //
    
    /**
     * No argument constructor that uses default values
     */
    public Shape(){}

    /**
     * Parameterized constructor to initialize a Shape object with specified color, 
     * filled status, and location. (Copilot)
     * 
     * @param color  the color of the shape
     * @param filled true if the shape is filled, false otherwise
     * @param point  the location of the shape as a Point object
     */
    public Shape(Color color, boolean filled, Point point) {
        this.color  = color;
        this.filled = filled;
        this.point  = new Point(point); // privacy protection
    }

    /**
     * Copy constructor to create a new Shape object as a copy of an 
     * existing one. (Copilot)
     * 
     * @param originalObject the Shape object to copy
     */
    public Shape(Shape originalObject) {
        if (originalObject != null){ // null check
			color  = originalObject.getColor();
			filled = originalObject.isFilled();
            point  = new Point(originalObject.getLocation());
		}
    }


	// =================== GETTERS AND SETTERS ====================== //

    /**
     * Gets the Point location of the shape.
     * 
     * @return the color of the shape, or null if not set
     */
    public Point getPoint() {
        if (point == null)  return null; // null check
        return new Point(point); // protect privacy
    }

    /**
     * Gets the color of the shape. (Copilot)
     * 
     * @return the color of the shape, or null if not set
     */
    public Color getColor() {
        if (color == null)  return null; // null check
        return color;
    }

    /**
     * Sets the color of the shape. (Copilot)
     * 
     * @param color the color to set; if null, no change is made
     */
    public void setColor(Color color) {
        if (color == null)  return; // null check
        this.color = color;
    }

    /**
     * Checks if the shape is filled. (Copilot)
     * 
     * @return true if the shape is filled, false otherwise
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Sets the filled status of the shape.
     * 
     * @param filled true to set the shape as filled, false otherwise
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Gets the location of the shape. (Copilot)
     * 
     * @return a new Point object representing the location of the shape, or null if not set
     */
    public Point getLocation() {
        if (point == null)  return null; // null check
        return new Point(point); // protect privacy
    }

    /**
     * Sets the location of the shape. (Copilot)
     * 
     * @param point the Point object representing the new location; if null, no change is made
     */
    public void setLocation(Point point) {
        if (point == null)  return; // null check
        this.point = new Point(point); // protect privacy
    }


	// ===================== MATH METHODS ======================== //

    /**
     * Calculate the area of the shape
     */
    public abstract double area();

    /**
     * Calculate the permimeter of the shape
     */
    public abstract double perimeter();

    /**
     * Calculate the distance from the camera to the edge of the shape
     * 
     * @param cameraPosition the position of the camera
     * @return the distance from the camera to the shape
     */
    public abstract double computeDistance(Point cameraPosition);
    

	// ==================== EXPECTED METHODS ======================= //
    
    /**
     * Do a deep comparison of two Shape objects, testing all fields
     * 
     * @param obj should be Shape obejct to be compared to
     * @return true if the Shapes are the same
     */
    @Override
    public boolean equals(Object obj) {
        // fail first, fail fast
        if (this == obj)    return true;    // idenetity check
        if (obj == null)    return false;   // null check
        if (getClass() != obj.getClass())
                            return false;   // class check
        
        Shape other = (Shape) obj; // down cast
        
        // validation for all fields (Copliot)
        if (color == null) {                // color null check
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (filled != other.filled)
            return false;
        if (point == null) {                // point null check
            if (other.point != null)
                return false;
        } else if (!point.equals(other.point))
            return false;
        return true;
    }

    /**
     * Abstract method from Drawable interface
     * 
     * @param g2d
     */
    public abstract void drawObject (Graphics2D g2d);

} // end Shape class
