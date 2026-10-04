import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Point3DTest {

    Point pointOne;	                // Point object
	Point3D point3DOne, point3DTwo;	// Point3D objects
	String msg;					    // test message

	@BeforeEach
	public void setup() { // set objects to null before each test
		pointOne = null;
		point3DOne = null;
		point3DTwo = null;
	}

    @Test
    void testEquals() {
        // Test when they are equal
        point3DOne = new Point3D(); // (0, 0, 0)
        point3DTwo = new Point3D(); // (0, 0, 0)
        assertEquals(point3DOne, point3DTwo); // should be the same

        // Test when they are not equal
        point3DTwo.setXYZ(1, 1, 1); // set point3DTwo to (1, 1, 1)
        assertNotEquals(point3DOne, point3DTwo);
    }

    @Test
    void testSetXYZ1() { // Test setter that accepts a three ints
        point3DOne = new Point3D(); // (0, 0, 0)
        
        int[] expectedXYZ = {1, 2, 3}; // (1, 2, 3)
        point3DOne.setXYZ(expectedXYZ[0], expectedXYZ[1], expectedXYZ[2]); // int args are array elements

        int[] actualXYZ = point3DOne.getXYZ(); // get array of updated (x, y, z) values
        
        assertTrue(Arrays.equals(expectedXYZ, actualXYZ));
    }

    @Test
    void testSetXYZ2() { // Test setter that accepts a Point and an int
        pointOne   = new Point(1, 1); // (1, 1)
        point3DOne = new Point3D();       // (0, 0, 0)
        
        int[] expectedXYZ = {pointOne.getX(), pointOne.getY(), 3}; // last element is z value
        point3DOne.setXYZ(pointOne, expectedXYZ[2]); // int arg is the last element of array

        int[] actualXYZ = point3DOne.getXYZ(); // get array of updated (x, y, z) values
        
        assertTrue(Arrays.equals(expectedXYZ, actualXYZ));
    }

    @Test
    void testSetZ() {
        point3DOne = new Point3D();         // (0, 0, 0)
        
        int expectedZ = 3;
        point3DOne.setZ(expectedZ);         // change z to 3

        int actualZ = point3DOne.getZ();    // get updated z value
        
        assertEquals(expectedZ, actualZ);   // both should be 3 now
    }
}
