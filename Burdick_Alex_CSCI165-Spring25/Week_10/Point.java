public class Point {

    //-------------------------------------------------
    // PRIVATE INSTANCE VARIABLES
    //-------------------------------------------------
    /*
     * Variables to store the coordinate values. Even though
     * they don't have data validation they are private for
     * testing purposes
     */
    private int x;
    private int y;


    //-------------------------------------------------
    // CONSTRUCTORS
    //-------------------------------------------------

    /**
	 * No argument constructor which uses default values (0, 0)
	 */
    public Point() {
        this(0, 0); // invoke overloaded constructor
    }

    /**
	 * Overloaded constructor that takes args for all values
     * 
     * @param x coordinate
     * @param y coordinate
	 */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy Constructor
     */
    public Point(Point toCopy) {
        this(toCopy.x, toCopy.y); // invoke overloaded constructor
    }
    

    //-------------------------------------------------
    // GETTERS & SETTERS
    //-------------------------------------------------
    
    /**
	 * Getter for x
     * 
     * @return x coordinate
	 */
    public int getX() {
        return x;
    }

    /**
	 * Getter for y
     * 
     * @return y coordinate
	 */
    public int getY() {
        return y;
    }

    /**
	 * Setter for x
     * 
     * @param x the x coordinate
	 */
    public void setX(int x) {
        this.x = x;
    }

    /**
	 * Setter for y
     * 
     * @param y the y coordinate
	 */
    public void setY(int y) {
        this.y = y;
    }

    /**
	 * Getter for x and y
     * 
     * @return 2 element array of both coordinates
	 */
    public int[] getCoords() {
        int[] coordinates = {x, y};
        return coordinates;
    }

    /**
	 * Setter for x and y
     * 
     * @param x the x coordinate
     * @param y the y coordinate
	 */
    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }
    

    //-------------------------------------------------
    // EXPECTED METHODS
    //-------------------------------------------------
    
    /**
	 * Converts all coordinates to a String in the format
     * "(x, y)"
     * 
     * @return String
	 */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
	 * Overridden equals that typcasts the arg as Object
     * 
     * @return true if the two objects have the same values
	 */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // identity check
        if (obj == null) return false; // null check
        if (getClass() != obj.getClass()) return false; // origin check
        
        Point other = (Point) obj; // Downcast obj back to Point

        if (x != other.x) return false; // compare x values
        return y == other.y; // compare y values
    }
    

    //-------------------------------------------------
    // DISTANCE METHODS
    //-------------------------------------------------

    /**
	 * Distance from this point to given (x, y)
     * 
     * @param x the x value
     * @param y the y value
     * @return the distance
	 */
    public double distance(int x, int y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2)); // Copilot auto-generated the formula
    }

    /**
	 * Distance from this point to the other point
     * 
     * @param other the other Point
     * @return the distance
	 */
    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    /**
	 * Distance from this point to origin (0, 0)
     * 
     * @return the distance
	 */
    public double distance() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    /**
	 * Distance from Point one to Point two
     * 
     * @param x the x value
     * @param y the y value
     * @return the distance
	 */
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

} // end class Point