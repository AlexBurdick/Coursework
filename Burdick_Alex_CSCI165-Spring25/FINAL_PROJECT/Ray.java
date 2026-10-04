/*
 * Filename: Ray.java
 * Author: Alex Burdick
 * Date: 05/07/25
 * 
 * Description: Class that takes a group of marches
 */

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Ray {

    // =============== PRIVATE INSTANCE VARIABLES ================== //
    private ArrayList<March> marches;
    private int marchCount;
    private int marchIndex;
    private int marchSize;
    private double marchLength;


    // ====================== CONSTRUCTORS ========================= //
    
    /**
     * Constructor that initializes the march array
     * 
     * @param marches Array of March objects
     */
    public Ray(ArrayList<March> marches) {
        setMarches(marches); 
    }


    // ===================== GETTERS & SETTERS ======================= //

    public ArrayList<March> getMarches() {
        return marches;
    }


    public void setMarches(ArrayList<March> marches) {
        this.marches = new ArrayList<March>(marches); // create a new ArrayList to prevent external modification
    }


    public int getMarchCount() {
        return marchCount;
    }


    public void setMarchCount(int marchCount) {
        this.marchCount = marchCount;
    }


    public int getMarchIndex() {
        return marchIndex;
    }


    public void setMarchIndex(int marchIndex) {
        this.marchIndex = marchIndex;
    }


    public int getMarchSize() {
        return marchSize;
    }


    public void setMarchSize(int marchSize) {
        this.marchSize = marchSize;
    }


    public double getMarchLength() {
        return marchLength;
    }


    public void setMarchLength(double marchLength) {
        this.marchLength = marchLength;
    }
    

    // ======================= METHODS =========================== //

    /**
     * Draws the ray
     * 
     * @param g2d Graphics2D object to draw on
     */
    public void drawRay(Graphics2D g2d) {
        for (March march : marches)
            march.drawObject(g2d); // draw each march object
    }
}
