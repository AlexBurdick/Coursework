/*
 * Filename: Camera.java
 * Author: Alex Burdick
 * Date: 05/04/25
 * 
 * Description: Class to represent a camera and it's functions. Used to represent the camera in the raymarcher
 *              Sub class of Circle
 *              Implements MouseMotionListener to allow for mouse movement
 */

import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Camera extends Circle implements MouseListener, MouseMotionListener {

    // ================ PUBLIC INSTANCE VARIABLES ================== //
    // Default values of the camera that override the default values of Circle
    public static final double radius = 5.0;
    public double marchAngle = 0.0; // angle of the march

	// ====================== CONSTRUCTORS ========================= //

    /**
     * Overloaded constructor that takes sets all variables
     * 
     * @param color
     * @param filled
     * @param point
     * @param radius
     */
    public Camera(Color color, boolean filled, Point point) {
        super(color, filled, point, radius); // invoke super constructor
    }

    /**
     * Copy constructor
     * 
     * @param toCopy Circle to be copied
     */
    public Camera(Camera toCopy) {
        super(toCopy); // invoke super constructor
    }


    // ==================== EXPECTED METHODS ======================= //
    
    /**
     * Draws the camera object
     * 
     * @param g2d Graphics2D object to draw on
     */
    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        // Implementation for mouse moved event
        point.x = e.getX();
        point.y = e.getY();
    }

    /**
     * Unimplemented method
     */
    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {}


    // ==================== MOUSE LISTENER METHODS ==================== //


    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        // If the left mouse button is pressed, increase the angle of the march
        if (e.getButton() == java.awt.event.MouseEvent.BUTTON1) // Left mouse button
            marchAngle += 1; // Increment the angle
        
        // If the right mouse button is pressed, decrease the angle of the march
        if (e.getButton() == java.awt.event.MouseEvent.BUTTON3) // Right mouse button
            marchAngle -= 1; // Decrement the angle
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        // Placeholder
    }
    
    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        // Placeholder
    }
    
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // Placeholder
    }
    
    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // Placeholder
    }

}
