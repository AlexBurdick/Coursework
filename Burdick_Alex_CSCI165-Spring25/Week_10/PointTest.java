import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PointTest {

    Point pointOne, pointTwo;   // Point object
	String msg;                 // test message

	@BeforeEach
	public void setup() { // set objects to null before each test
		pointOne = null;
        pointTwo = null;
	}

    @Test
    void testDistance1() { // test method that accepts two ints
        pointOne = new Point(1, 1);                 // (1, 1)
        double distance = pointOne.distance(4, 5);  // (4, 5)
        assertEquals(distance, 5);// the distance should be 5
    }

    @Test
    void testDistance2() { // test method that accepts a Point
        pointOne = new Point(1, 1);  // (1, 1)
        pointTwo = new Point(4, 5);  // (4, 5)
        double distance = pointOne.distance(pointTwo);
        assertEquals(distance, 5);// the distance should be 5
    }

    @Test
    void testDistance3() { // test static method that accpets two Points
        pointOne = new Point(1, 1);  // (1, 1)
        pointTwo = new Point(4, 5);  // (4, 5)
        double distance = Point.distance(pointOne, pointTwo);
        assertEquals(distance, 5);// the distance should be 5
    }

    @Test
    void testEquals() {
        // Test when they are equal
        pointOne = new Point(); // (0, 0)
        pointTwo = new Point(); // (0, 0)
        assertEquals(pointOne, pointTwo); // should be the same

        // Test when they are not equal
        pointOne.setCoords(1, 1);
        assertNotEquals(pointOne, pointTwo);
    }

    @Test
    void testGetCoords() {
        pointOne = new Point(); // (0, 0)
        int actualX = pointOne.getX();
        int actualY = pointOne.getY();
        assertEquals(actualX, 0); // should be the default value
        assertEquals(actualY, 0); // should be the default value
    }

    @Test
    void testSetCoords() {
        pointOne = new Point();

        int expectedX = 3;
        int expectedY = 4;

        pointOne.setCoords(expectedX, expectedY); // set new coordinates

        int actualX = pointOne.getX(); // get updated x
        int actualY = pointOne.getY(); // get update y
        
        assertEquals(expectedX, actualX); // should be the same
        assertEquals(expectedY, actualY); // should be the same
    }

    @Test
    void testSetX() {
        pointOne = new Point();
        int expectedX = 3;

        pointOne.setX(expectedX);
        int actualX = pointOne.getX();
        
        assertEquals(expectedX, actualX);
    }

    @Test
    void testSetY() {
        pointOne = new Point();
        int expectedY = 3;

        pointOne.setY(expectedY);
        int actualY = pointOne.getY();
        
        assertEquals(expectedY, actualY);
    }
}
