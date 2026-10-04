import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MoveablePointTest {
    
    Point pointOne, pointTwo;	    // Point object
    MoveablePoint moveablePointOne,
                  moveablePointTwo; // MoveablePoint objects
	String msg;					    // test message

	@BeforeEach
	public void setup() {  // set objects to null before each test
		pointOne = null;
        pointTwo = null;
        moveablePointOne = null;
        moveablePointTwo = null;
	}
    
    @Test
    void testEquals() {
        // Test when they are equal
        moveablePointOne = new MoveablePoint(1, 1);
        moveablePointTwo = new MoveablePoint(1, 1);
        assertEquals(moveablePointOne, moveablePointTwo); // should be the same

        // Test when they are not equal
        moveablePointTwo.xSpeed = 2; // change xSpeed of second instance
        moveablePointTwo.xSpeed = 2; // change ySpeed of second instance
        assertNotEquals(moveablePointOne, moveablePointTwo); // should not be the same
    }

    @Test
    void testMove() {
        moveablePointOne = new MoveablePoint(1, 1);
        MoveablePoint expectedPoint = new MoveablePoint(moveablePointOne); // store state before move
        MoveablePoint actualPoint   = moveablePointOne.move();             // store state after move

        assertNotEquals(expectedPoint, actualPoint); // should not be the same

        MoveablePoint moveablePointTwo = moveablePointOne.move(); // moves the point and also returns a copy of the moved point
        assertEquals(moveablePointOne, moveablePointTwo); // print the point after move()
    }
}
