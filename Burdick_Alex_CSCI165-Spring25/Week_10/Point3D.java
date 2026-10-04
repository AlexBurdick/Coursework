public class Point3D extends Point {
    //-------------------------------------------------
    // PRIVATE INSTANCE VARIABLES
    //-------------------------------------------------
    /*
     * Variables to store the coordinate values. Even though
     * they don't have data validation they are private for
     * testing purposes
     */
    private int z;


    //-------------------------------------------------
    // CONSTRUCTORS
    //-------------------------------------------------

    /**
	 * No argument constructor which u(ses default values
	 */
    public Point3D() {
        this(0, 0, 0); // invoke overloaded constructor
    }

    /**
	 * Overloaded constructor that takes args for all values
     * 
     * @param x coordinate
     * @param y coordinate
     * @param z coordinate
	 */
    public Point3D(int x, int y, int z) {
        super(x, y); // invoke Point constructor
        this.z = z;  // set z
    }

    /**
	 * Overloaded constructor that takes a Point and int as args
     * 
     * @param p coordinate
     * @param z coordinate
	 */
    public Point3D(Point p, int z) {
        super(p); // invoke Point copy constructor
        this.z = z;  // set z
    }

    /**
     * Copy Constructor
     */
    public Point3D(Point3D toCopy) {
        this(toCopy.getX(), toCopy.getX(), toCopy.z); // invoke overloaded constructor
    }


    //-------------------------------------------------
    // GETTERS & SETTERS
    //-------------------------------------------------

    /**
	 * Getter for this.z
     * 
     * @return z coordinate
	 */
    public int getZ() {
        return z;
    }

    /**
	 * Setter for this.z
     * 
     * @param z coordinate
	 */
    public void setZ(int z) {
        this.z = z;
    }

    /**
	 * Getter for all coordinates (x, y, z)
     * 
     * @return array of all coordinates
	 */
    public int[] getXYZ() {
        int[] coordinates = {super.getX(), super.getY(), z};
        return coordinates;
    }

    /**
	 * Setter for all coordinates (x, y, z)
     * Accepts three ints as args
     * 
     * @param x coordinate
     * @param y coordinate
     * @param z coordinate
	 */
    public void setXYZ(int x, int y, int z) {
        super.setX(x);
        super.setY(y);
        this.z = z;
    }

    /**
	 * Setter for all coordinates (x, y, z)
     * Accepts a point and an int as args
     * 
     * @param Point with x, y coordinates
     * @param z coordinate
	 */
    public void setXYZ(Point xy, int z) {
        super.setX(xy.getX());
        super.setY(xy.getY());
        this.z = z;
    }


    //-------------------------------------------------
    // EXPECTED METHODS
    //-------------------------------------------------

    /**
	 * Converts all coordinates to a String in the format
     * "(x, y, z)"
     * 
     * @return String
	 */
    @Override
    public String toString() {
        // Invoke the Point constructor and remove the ')' at the end
        String p = super.toString();
        String s = p.substring(0, p.length() - 1);
        return ( s + ", " + z + ")" );
    }

    /**
	 * Equals method to see if Point3D objects are deep equals
     * 
     * @return true if the values in both ojbects are the same
	 */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)                    return true;    // identity check
        if (obj == null)                    return false;   // null check
        if (getClass() != obj.getClass())   return false;   // origin check
        if (!super.equals(obj))				return false;   // super class checks (inheritance)
        Point3D other = (Point3D) obj;                      // Downcast obj back to Point3D
        return z == other.z;                                // compare z
    }
    

    //-------------------------------------------------
    // DISTANCE METHODS
    //-------------------------------------------------

    // Methods to calculate the distance from one 3D point to another/
    
    /**
	 * Distance from this point to given (x, y)
     * 
     * @param x the x value
     * @param y the y value
     * @param z the z value
     * @return the distance
	 */
    public double distance(int x, int y, int z) {
        return Math.sqrt(Math.pow(super.getX() - x, 2) + 
                         Math.pow(super.getY() - y, 2) + 
                         Math.pow(this.z - z, 2));
    }

    /**
	 * Distance from this point to the other point
     * 
     * @param other the other Point3D
     * @return the distance
	 */
    public double distance(Point3D other) {
        return Math.sqrt(Math.pow(super.getX() - other.getX(), 2) +  
                         Math.pow(super.getY() - other.getY(), 2) + 
                         Math.pow(this.z - other.getZ(), 2));

        /* other is a Point3D object, but the above formula is calling the
         * getX() and getY() methods of the super class Point. Since those 
         * methods are public, Point3D objects inheret them and can be used
         * to call them.
         */
    }

    /**
	 * Distance from this point to origin (0, 0, 0)
     * 
     * @return the distance
	 */
    @Override // there is a distance() method in Point with the same signature
    public double distance() {
        return Math.sqrt(Math.pow(super.getX(), 2) + 
                         Math.pow(super.getY(), 2) + 
                         Math.pow(z, 2));
    }

    /**
	 * Distance from one Point3D to another
     * 
     * @param x the x value
     * @param y the y value
     * @return the distance
	 */
    public static double distance(Point3D p1, Point3D p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + 
                         Math.pow(p1.getY() - p2.getY(), 2) + 
                         Math.pow(p1.getZ() - p2.getZ(), 2));
    }

} // end class Point3D
