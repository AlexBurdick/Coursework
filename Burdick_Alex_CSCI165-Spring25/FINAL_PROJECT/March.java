/*
 * Filename: March.java
 * Author: Alex Burdick
 * Date: 05/06/25
 * 
 * Description: Class that takes creates a march to the next shape
 *              Sub class of Circle
 */

import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Graphics2D;

public class March extends Circle {

    // =============== PRIVATE INSTANCE VARIABLES ================== //
    private Circle circle;
    private Line2D line;
    private Point2D.Double start;
    private Point2D.Double end;
    //private Color color = new Color(255, 255, 255); // default color for the line


    // ====================== CONSTRUCTORS ========================= //

    /**
     * Constructor that initializes the start and end points of the line. The line
     * will go straight up from the start point to the end point. The distance between
     * the start and end points will be the distance to the nearest object (passed in).
     * Then instantiate a creates Circle object based on the line.
     * 
     * @param p      The starting point of the line
     * @param radius The distance to the nearest object
     */
    public March(Point p, double radius, double t) {

        // Get the start and end coordinates of the line from the camera
        double startX = p.getX();
        double startY = p.getY();
        double endX = startX + radius * Math.cos(t); // line will go straight down
        double endY = startY + radius * Math.sin(t); // line will go down by the distance to the nearest object

        // Create a Line2D object with the specified coordinates
        start = new Point2D.Double(startX, startY);
        end   = new Point2D.Double(endX, endY);
        setLine(start, end);

        // Create a Circle object with the Line2D coordinates
        this.point = new Point(start.getX(), start.getY()); // create a point to be used for the Circle
        double length = line.getP1().distance(line.getP2()); // the radius will be the distance between the two points
        setCircle(new Circle(new Color(255,255,255), false, p, length));
    }

    // ===================== GETTERS & SETTERS ======================= //

    public Circle getCircle() {
        return new Circle(circle); // return a copy of the circle object to prevent external modification
    }


    public void setCircle(Circle circle) {
        this.circle = new Circle(circle); // set the circle to a new Circle object to prevent external modification
    }


    public Line2D getLine() {
        return new Line2D.Double(line.getP1(), line.getP2()); // return a copy of the line object to prevent external modification
    }


    public void setLine(Line2D line) {
        this.line = new Line2D.Double(line.getP1(), line.getP2()); // set the line to a new Line2D object to prevent external modification
    }

    public void setLine(Point2D.Double start, Point2D.Double end) {
        this.line = new Line2D.Double(start, end); // set the line to a new Line2D object to prevent external modification
    }


    public Point2D.Double getStart() {
        return new Point2D.Double(start.getX(), start.getY()); // return a copy of the start point to prevent external modification
    }


    public void setStart(Point2D.Double p) {
        start = new Point2D.Double(p.getX(), p.getY()); // set the start point to a new Point2D object to prevent external modification
    }


    public Point getEnd() {
        Point p = new Point(end.getX(), end.getY()); // Convert Point2D.Double to Point
        return p;
    }


    public void setEnd(Point2D.Double p) {
        end = new Point2D.Double(p.getX(), p.getY()); // set the end point to a new Point2D object to prevent external modification
    }


    // =================== EXPECTED METHODS ======================= //

    @Override
    public double computeDistance(Point point) {
        // Placeholder implementation
        return 0.0;
    }

    @Override
    public void drawObject(Graphics2D g) {
        // Draw a vertical line from the start point to the end point
        g.setColor(circle.getColor());
        g.drawLine((int) start.getX(), (int) start.getY(), (int) end.getX(), (int) end.getY());

        // Draw a circle at the end of the line with a radius to the closest Shape
        circle.drawObject(g); // draw the circle at the end of the line
    }

}
