/*
	File:	CircleTest.java
	Author:	Alex Burdick
	Date:	4/23/2025

 	Description: Tests for methods in the Circle class
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.awt.Color;

public class CircleTests {
    
	// Instantiate objects to test
	Color c1 = new Color(0, 0, 255);
	Point p1 = new Point(1,2);
	Point p2 = new Point(3,4);
	Circle circleOne = new Circle();
	Circle circleTwo = new Circle();
	String msg = "";
	
	@BeforeEach
    public void setup() {
        circleOne = null; // clear object data before next test
        circleTwo = null; // clear object data before next test
    }

	@Test
	void testtoString() {
		circleOne = new Circle(c1, false, p1, 1);
		circleTwo = new Circle(c1, true, p2, 2);
		System.out.println(circleOne);
		System.out.println(circleTwo);
	}

    @Test
    void testCopyContructor() {
		circleOne = new Circle(c1, false, p1, 1);
		circleTwo = new Circle(circleOne);
		assertTrue(circleOne.equals(circleTwo));
	}

	@Test
	void testEqualsTrue() {
		// Circles are logically not equal
		circleOne = new Circle(c1, false, p1, 1);
		circleTwo = new Circle(c1, false, p2, 1);
		msg = "Circles are not logically equal";
		assertFalse(circleOne.equals(circleTwo), msg);

		circleOne.setLocation(p1);
		circleTwo.setLocation(p1);
		msg = "After changing both test instances side, Circles are now logically equal";
		assertTrue(circleOne.equals(circleTwo), msg);
	}

	@Test
	void testEqualsFalse() {
		// Circles are logically not equal
		circleOne = new Circle(c1, false, p1, 1);
		circleTwo = new Circle(c1, false, p1, 1);
		msg = "Circles are logically equal";
		assertTrue(circleOne.equals(circleTwo), msg);

		// Color
		circleTwo.setColor(new Color(0,0,0));
		msg = "After changing one test instance Color, Circles are now not logically equal";
		assertFalse(circleOne.equals(circleTwo), msg);
		circleTwo.setColor(circleOne.getColor()); // set back to equal
		assertTrue(circleOne.equals(circleTwo), msg);

		// isFilled
		circleTwo.setFilled(true);
		msg = "After changing one test instance filled, Circles are now not logically equal";
		assertFalse(circleOne.equals(circleTwo), msg);
		circleTwo.setFilled(circleOne.isFilled()); // set back to equal
		assertTrue(circleOne.equals(circleTwo), msg);

		// Point
		circleTwo.setLocation(new Point(0,0));
		msg = "After changing one test instance Point, Circles are now not logically equal";
		assertFalse(circleOne.equals(circleTwo), msg);
		circleTwo.setLocation(circleOne.getLocation()); // set back to equal
		assertTrue(circleOne.equals(circleTwo), msg);

		// Radius
		circleTwo.setRadius(5);
		msg = "After changing one test instance radius, Circles are now not logically equal";
		assertFalse(circleOne.equals(circleTwo), msg);
		circleTwo.setRadius(circleOne.getRadius()); // set back to equals
		assertTrue(circleOne.equals(circleTwo), msg);
	}

	@Test
	void testArea() {
		circleOne = new Circle(c1, false, p1, 1);
		double expectedArea = Math.PI * circleOne.getRadius() * circleOne.getRadius();
		double actualArea = circleOne.area();
		assertEquals(expectedArea, actualArea);
	}

	@Test
	void testPerimeter() {
		circleOne = new Circle(c1, false, p1, 1);
		double expectedPerimeter = 2 * Math.PI * circleOne.getRadius();
		double actualPerimeter = circleOne.perimeter();
		assertEquals(expectedPerimeter, actualPerimeter);
	}

	@Test
	void testSetRadius() {
		circleOne = new Circle(c1, false, p1, 1);
		double expectedRadius = 4;
		circleOne.setRadius(expectedRadius);
		double actualSide = circleOne.getRadius();
		assertEquals(expectedRadius, actualSide);
	}
}
