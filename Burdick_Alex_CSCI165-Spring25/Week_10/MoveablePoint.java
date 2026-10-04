public class MoveablePoint extends Point {
    //-------------------------------------------------
    // PUBLIC INSTANCE VARIABLES
    //-------------------------------------------------
    /*
     * The speed values can be any number, therefore there is no need 
     * for data validation. For simplicity the variables will be public,
     * and there are no getters or setters for them individually.
     */
    public float xSpeed;
    public float ySpeed;


    //-------------------------------------------------
    // CONSTRUCTORS
    //-------------------------------------------------

    /**
	 * Overloaded constructor which takes all values
     * 
     * @param xSpeed speed
     * @param ySpeed speed
	 */
    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    /**
	 * Constructor that also takes int values for the Point
     * 
     * @param x coordinate
     * @param y coordinate
     * @param xSpeed speed
     * @param ySpeed speed
	 */
    public MoveablePoint(int x, int y, float xSpeed, float ySpeed) {
        super(x, y); // invoke Point constructor
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    /**
	 * Constructor that also takes a Point object
     * 
     * @param Point point
     * @param xSpeed speed
     * @param ySpeed speed
	 */
    public MoveablePoint(Point point, float xSpeed, float ySpeed) {
        super(point); // invoke Point constructor
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    /**
	 * Copy constructor
     * 
     * @param x coordinate
     * @param y coordinate
     * @param xSpeed speed
     * @param ySpeed speed
	 */
    public MoveablePoint(MoveablePoint toCopy) {
        this(toCopy.xSpeed, toCopy.ySpeed); // invoke overloaded constructor
    }


    //-------------------------------------------------
    // GETTERS & SETTERS
    //-------------------------------------------------
    /**
	 * Gets xSpeed and ySpeed at the same time
     * 
     * @return array of both speed values
	 */
    public float[] getSpeeds() {
        float[] result = new float[2]; // construct an array
        result[0] = xSpeed;
        result[1] = ySpeed;
        return result;
    }


    //-------------------------------------------------
    // EXPECTED METHODS
    //-------------------------------------------------

    /**
	 * Converts all coordinates and speeds to a String in the format
     * "(x, y): speed = (xs, ys)"
     * 
     * @return all coordinates in (x, y, z) form
	 */
    @Override
    public String toString() {
        // Invoke the Point constructor
        return ( super.toString() + ": speed = (" + xSpeed + ", " + ySpeed + ")" );
    }

    /**
	 * Checks to see if two MoveablePoint objects are deep equals
     * 
     * @return true if both are deep equals
	 */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)                    return true;    // identity check
        if (obj == null)                    return false;   // null check
        if (getClass() != obj.getClass())   return false;   // origin check
        if (!super.equals(obj))             return false;   // super class checks (inheritance)
        
        MoveablePoint other = (MoveablePoint) obj;          // downcast
        
        if (xSpeed != other.xSpeed)         return false;   // test xSpeed
        return ySpeed == other.ySpeed;                      // test ySpeed
    }

    
    //-------------------------------------------------
    // CLASS METHODS
    //-------------------------------------------------

    /**
	 * Change the x and y values of this instance of the variable
     * then return this instance.
     * 
     * @return this
	 */
    public MoveablePoint move() {
        // Convert floats to ints
        int xS = (int) xSpeed;// + super.getX();
        int yS = (int) ySpeed;// + super.getX();

        super.setX( super.getX() + xS ); // add xSpeed to the x value
        super.setY( super.getY() + yS ); // add ySpeed to the y value

        return this; //new MoveablePoint(this);
    }

} // end class MoveablePoint
