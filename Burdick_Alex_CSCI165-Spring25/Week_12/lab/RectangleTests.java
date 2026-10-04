/*
	File:	RectangleTests.java
	Author:	Alex Burdick
	Date:	4/23/2025

 	Description: Tests for methods in the Rectangle class
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.awt.Color;

public class RectangleTests {
    
	// Instantiate objects to test
	Color c1 = new Color(0, 0, 255);
	Point p1 = new Point(1,2);
	Point p2 = new Point(3,4);
	Rectangle rectangleOne = new Rectangle();
	Rectangle rectangleTwo = new Rectangle();
	String msg = "";
	
	@BeforeEach
    public void setup() {
        rectangleOne = null; // clear object data before next test
        rectangleTwo = null; // clear object data before next test
    }

    @Test
	void testToString() {
		rectangleOne = new Rectangle(c1, false, p1, 1, 2);
		rectangleTwo = new Rectangle(c1, true, p2, 3, 5);
		System.out.println(rectangleOne);
		System.out.println(rectangleTwo);
	}

    @Test
    void testCopyContructor() {
		rectangleOne = new Rectangle(c1, false, p1, 1, 2);
		rectangleTwo = new Rectangle(rectangleOne);
		assertTrue(rectangleOne.equals(rectangleTwo));
	}

	@Test
	void testEqualsTrue() {
		// Rectangles are logically not equal
		rectangleOne = new Rectangle(c1, false, p1, 1, 2);
		rectangleTwo = new Rectangle(c1, true, p1, 1, 2);

		msg = "Rectangles are not logically equal";
		assertFalse(rectangleOne.equals(rectangleTwo), msg);

		rectangleOne.setFilled(false);
		rectangleTwo.setFilled(false);
		msg = "After changing both test instances side, Rectangles are now logically equal";
		assertTrue(rectangleOne.equals(rectangleTwo), msg);
	}

	@Test
	void testEqualsFalse() {
		// Rectangles are logically equal
		rectangleOne = new Rectangle(c1, false, p1, 1, 2);
		rectangleTwo = new Rectangle(c1, false, p1, 1, 2);
		msg = "Rectangles are logically equal";
		assertTrue(rectangleOne.equals(rectangleTwo), msg);

		// Color
		rectangleTwo.setColor(new Color(0,0,0));
		msg = "After changing one test instance Color, Rectangles are now not logically equal";
		assertFalse(rectangleOne.equals(rectangleTwo), msg);
		rectangleTwo.setColor(rectangleOne.getColor()); // set back to equal
		assertTrue(rectangleOne.equals(rectangleTwo), msg);

		// isFilled
		rectangleTwo.setFilled(true);
		msg = "After changing one test instance filled, Rectangles are now not logically equal";
		assertFalse(rectangleOne.equals(rectangleTwo), msg);
		rectangleTwo.setFilled(rectangleOne.isFilled()); // set back to equal
		assertTrue(rectangleOne.equals(rectangleTwo), msg);

		// Point
		rectangleTwo.setLocation(new Point(0,0));
		msg = "After changing one test instance Point, Rectangles are now not logically equal";
		assertFalse(rectangleOne.equals(rectangleTwo), msg);
		rectangleTwo.setLocation(rectangleOne.getLocation()); // set back to equal
		assertTrue(rectangleOne.equals(rectangleTwo), msg);

		// Height
		rectangleTwo.setHeight(10);
		msg = "After changing one test instance height, Rectangles are now not logically equal";
		assertFalse(rectangleOne.equals(rectangleTwo), msg);
		rectangleTwo.setHeight(rectangleOne.getHeight()); // set back to equals
		assertTrue(rectangleOne.equals(rectangleTwo), msg);

		// Width
		rectangleTwo.setWidth(10);
		msg = "After changing one test instance width, Rectangles are now not logically equal";
		assertFalse(rectangleOne.equals(rectangleTwo), msg);
		rectangleTwo.setWidth(rectangleOne.getWidth()); // set back to equals
		assertTrue(rectangleOne.equals(rectangleTwo), msg);
	}

	@Test
	void testArea() {
		rectangleOne = new Rectangle(c1, false, p1, 1, 2);
		double expectedArea = 2;
		double actualArea = rectangleOne.area();
		assertEquals(expectedArea, actualArea);
	}

	@Test
	void testPerimeter() {
		rectangleOne = new Rectangle(c1, false, p1, 1, 2);
		double expectedPerimeter = 6;
		double actualPerimeter = rectangleOne.perimeter();
		assertEquals(expectedPerimeter, actualPerimeter);
	}

	@Test
	void testsetHeithgt() {
		rectangleOne = new Rectangle(c1, false, p1, 1, 2);
		double expectedHeight = 4;
		rectangleOne.setHeight(expectedHeight);
		double actualHeight = rectangleOne.getHeight();
		assertEquals(expectedHeight, actualHeight);
	}

	@Test
	void testSetWidth() {
		rectangleOne = new Rectangle(c1, false, p1, 1, 2);
		double expectedWidth = 4;
		rectangleOne.setWidth(expectedWidth);
		double actualWidth = rectangleOne.getWidth();
		assertEquals(expectedWidth, actualWidth);
	}
}
