/*
	File:	SemiCircleTest.java
	Author:	Alex Burdick
	Date:	4/23/2025

 	Description: Tests for methods in the SemiCircle class
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.awt.Color;

public class SemiCircleTests {
    
	// Instantiate objects to test
	Color c1 = new Color(0, 0, 255);
	Point p1 = new Point(1,2);
	Point p2 = new Point(3,4);
	SemiCircle semiCircleOne = new SemiCircle();
	SemiCircle semiCircleTwo = new SemiCircle();
	String msg = "";
	
	@BeforeEach
    public void setup() {
        semiCircleOne = null; // clear object data before next test
        semiCircleTwo = null; // clear object data before next test
    }

	@Test
	void testtoString() {
		semiCircleOne = new SemiCircle(c1, false, p1, 1);
		semiCircleTwo = new SemiCircle(c1, true, p2, 2);
		System.out.println(semiCircleOne);
		System.out.println(semiCircleTwo);
	}

    @Test
    void testCopyContructor() {
		semiCircleOne = new SemiCircle(c1, false, p1, 1);
		semiCircleTwo = new SemiCircle(semiCircleOne);
		assertTrue(semiCircleOne.equals(semiCircleTwo));
	}

	@Test
	void testEqualsTrue() {
		// Circles are logically not equal
		semiCircleOne = new SemiCircle(c1, false, p1, 1);
		semiCircleTwo = new SemiCircle(c1, false, p1, 2);
		msg = "Semi-circles are not logically equal";
		assertFalse(semiCircleOne.equals(semiCircleTwo), msg);

		semiCircleTwo.setRadius(1);
		msg = "After changing both test instances side, Semi-circles are now logically equal";
		assertTrue(semiCircleOne.equals(semiCircleTwo), msg);
	}

	@Test
	void testEqualsFalse() {
		// Circles are logically not equal
		semiCircleOne = new SemiCircle(c1, false, p1, 1);
		semiCircleTwo = new SemiCircle(c1, false, p1, 1);
		msg = "Semi-circles are logically equal";
		assertTrue(semiCircleOne.equals(semiCircleTwo), msg);

		// Color
		semiCircleTwo.setColor(new Color(0,0,0));
		msg = "After changing one test instance Color, semi-circles are now not logically equal";
		assertFalse(semiCircleOne.equals(semiCircleTwo), msg);
		semiCircleTwo.setColor(semiCircleOne.getColor()); // set back to equal
		assertTrue(semiCircleOne.equals(semiCircleTwo), msg);

		// isFilled
		semiCircleTwo.setFilled(true);
		msg = "After changing one test instance filled, semi-circles are now not logically equal";
		assertFalse(semiCircleOne.equals(semiCircleTwo), msg);
		semiCircleTwo.setFilled(semiCircleOne.isFilled()); // set back to equal
		assertTrue(semiCircleOne.equals(semiCircleTwo), msg);

		// Point
		semiCircleTwo.setLocation(new Point(0,0));
		msg = "After changing one test instance Point, semi-circles are now not logically equal";
		assertFalse(semiCircleOne.equals(semiCircleTwo), msg);
		semiCircleTwo.setLocation(semiCircleOne.getLocation()); // set back to equal
		assertTrue(semiCircleOne.equals(semiCircleTwo), msg);

		// Radius
		semiCircleTwo.setRadius(5);
		msg = "After changing one test instance radius, Circles are now not logically equal";
		assertFalse(semiCircleOne.equals(semiCircleTwo), msg);
		semiCircleTwo.setRadius(semiCircleOne.getRadius()); // set back to equals
		assertTrue(semiCircleOne.equals(semiCircleTwo), msg);
	}

	@Test
	void testArea() {
		semiCircleOne = new SemiCircle(c1, false, p1, 1);
		double expectedArea = Math.PI * semiCircleOne.getRadius() * semiCircleOne.getRadius() / 2;
		double actualArea = semiCircleOne.area();
		assertEquals(expectedArea, actualArea);
	}

	@Test
	void testPerimeter() {
		semiCircleOne = new SemiCircle(c1, false, p1, 1);
		double expectedPerimeter = Math.PI * semiCircleOne.getRadius() + 2 * semiCircleOne.getRadius();
		double actualPerimeter = semiCircleOne.perimeter();
		assertEquals(expectedPerimeter, actualPerimeter);
	}

	@Test
	void testSetRadius() {
		semiCircleOne = new SemiCircle(c1, false, p1, 1);
		double expectedRadius = 4;
		semiCircleOne.setRadius(expectedRadius);
		double actualSide = semiCircleOne.getRadius();
		assertEquals(expectedRadius, actualSide);
	}
}