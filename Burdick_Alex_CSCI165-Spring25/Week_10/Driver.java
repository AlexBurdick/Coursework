/*
* This is the Driver class with main method for the Point class
*/
public class Driver {
    
    public static void main(String[] args) {
        demoPoint();
        demo3DPoint();
        demoMoveablePoint();
        demoDistance();
        demoToString();
        demoPolymorphism();
        demoObjects();
    } // end Main

    public static void demoPoint() {
        Point p1 = new Point();         // no argument constructor
        Point p2 = new Point(1,2);  // overloaded constructor
        Point p3 = new Point(p1);       // copy constructor

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);
    }

    public static void demo3DPoint() {
        Point3D p3D = new Point3D(1,4,5); // create new Point3D
        System.out.println("p3D: " + p3D);

        // Get the distance from the origin (0, 0)
        double distance = p3D.distance();
        System.out.println("Distance from origin = " + distance);

        // Change x and y values by calling Point mehtods from Point3D object
        p3D.setCoords(10, 10);
        System.out.println("p3D setCoords(): " + p3D);

    }

    public static void demoMoveablePoint() {
        // Test move()
        System.out.println("Testing move(): ");
        Point p = new Point(2, 5); // to be passed to the MoveablePoint constructor
        MoveablePoint mp = new MoveablePoint(p, 1, 1); // (2, 5)
        System.out.println("mp: "); // print point before move
        System.out.println("move() method: " + mp.move()); // print poin after move

        // Test floats, int casting, and rounding
        System.out.println("Testing: floats, ints, and rounding");
        System.out.println("mp: " + mp); // print the point before move()
        mp.xSpeed = 4.1f; // public variables can be accessed outside of the class
        mp.ySpeed = 3.9f;   

        System.out.println( "The move function will not move the point by the decimal values that " +
                            "were declared. Because the the speed values are integers, any values" +
                            "we try to do math with must be cast to integers. The decimal portion " + 
                            "is truncated and then added to the coordinates.");
        System.out.println("moved: " + mp.move()); // print the point after move()
    }

    public static void demoDistance() {
        MoveablePoint mp = new MoveablePoint( new Point(1, 2), 3, 4);
        Point3D p3d      = new Point3D( new Point(12, 34), 6);
        double dis       = mp.distance(p3d);

        System.out.println(dis);
    }

    public static void demoToString() {
        /* The point that gets printed will include the (x, y) text created
        * by the toString() in the Point class. This demonstrates method calls
        * from a sub class to a super class.
        */ 
        Point3D p3d = new Point3D( new Point(12, 34), 6);
        System.out.println("p3d = " + p3d);

        MoveablePoint mp = new MoveablePoint( new Point(1, 2), 3, 4);
        System.out.println("mp = " + mp);
    }

    public static void demoPolymorphism() {
        Point[] points = new Point[9]; // array of superclass type
        // Fill array with different types of points
        points[0] = new Point(1, 1);
        points[1] = new Point(1, 1);
        points[2] = new Point(2, 2);
        points[3] = new Point3D(3, 3, 3);
        points[4] = new Point3D(4, 4, 4);
        points[5] = new Point3D(5, 5, 5);
        points[6] = new MoveablePoint(6, 6, 1.5f, 1.5f);
        points[7] = new MoveablePoint(7, 7, 1.5f, 1.5f);
        points[8] = new MoveablePoint(8, 8, 1.5f, 1.5f);
        
        // Print each of the points in the array
        for (Point p : points) {
            System.out.println(p);
        }

        // Determine which point is furthest from origin
        double longestDistance = 0; // placeholder for distance
        Point furthestPoint = null; // placeholder for Point
        for (Point p : points) {                    // loop through each point
            if ( p.distance() > longestDistance )   // if the distance is greater than the last
                longestDistance = p.distance();     // set new longest distacne
                furthestPoint = p;                  // set furthest to new point
                // p.move();
                /* The error says 'The method move() is undefined for the type PointJava(67108964)
                 * This is because the method is in subclass MoveablePoint, and therefore is not
                 * intherited by a different sub class like Point3D, or it's super class Point.
                 */
        }
        System.out.println(furthestPoint + " is " + longestDistance + " from origin");
    }

    public static void demoObjects() {
        // Work with and array of Objects
        Object[] objects = new Object[9]; // array of superclass type
        // Fill array with different types of points
        objects[0] = new Point(1, 1);
        objects[1] = new Point(1, 1);
        objects[2] = new Point(2, 2);
        objects[3] = new Point3D(3, 3, 3);
        objects[4] = new Point3D(4, 4, 4);
        objects[5] = new Point3D(5, 5, 5);
        objects[6] = new MoveablePoint(6, 6, 1.5f, 1.5f);
        objects[7] = new MoveablePoint(7, 7, 1.5f, 1.5f);
        objects[8] = new MoveablePoint(8, 8, 1.5f, 1.5f);

        // Print each of the points in the array
        for (Object o : objects) {
            System.out.println(o);
            /* (From Leo)
             * When an object is upcast, the JVM determines which toString() method 
             * to call based on the object's actual class, not the reference type. 
             * This is why the overridden toString() method in the subclass is called 
             * even after upcasting to a superclass. 
             */

            /* o.setX(5);
             * The above line has an error because once the object is upcast,the
             * compiler will only see the methods and instances available to the
             * reference type. The exception is overriden methods.
             */
        }
    }

} // end Driver class