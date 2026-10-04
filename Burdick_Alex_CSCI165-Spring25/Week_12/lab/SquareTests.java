/*
	File:	SquareTests.java
	Author:	Alex Burdick
	Date:	4/23/2025

 	Description: Tests for methods in the Square class
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.awt.Color;

public class SquareTests {
	
	// Instantiate objects to test
	Color c1 = new Color(255, 0, 255);
	Point p1 = new Point(1,2);
	Point p2 = new Point(5,10);
	Square squareOne = new Square();
	Square squareTwo = new Square();
	String msg = "";
	
	@BeforeEach
    public void setup() {
        squareOne = null; // clear object data before next test
        squareTwo = null; // clear object data before next test
    }

    @Test
	void testtoString() {
		squareOne = new Square(4, c1, false, p1);
		squareTwo = new Square(1, c1, true, p2);
		System.out.println(squareOne);
		System.out.println(squareTwo);
	}

    @Test
	void testEqualsTrue() {
		// Squares are logically not equal
		squareOne = new Square(1, c1, false, p1);
		squareTwo = new Square(4, c1, false, p1);

		msg = "Squares are not logically equal";
		assertFalse(squareOne.equals(squareTwo), msg);

		squareOne.setSide(1);
		squareTwo.setSide(1);
		msg = "After changing both test instances side, Squares are now logically equal";
		assertTrue(squareOne.equals(squareTwo), msg);
	}

	@Test
	void testEqualsFalse() {
		// Squares are logically equal
		squareOne = new Square(1, c1, false, p1);
		squareTwo = new Square(1, c1, false, p1);
		msg = "Squares are logically equal";
		assertTrue(squareOne.equals(squareTwo), msg);

		// Side
		squareTwo.setSide(10);
		msg = "After changing one test instance side, Squares are now not logically equal";
		assertFalse(squareOne.equals(squareTwo), msg);
		squareTwo.setSide(squareOne.getSide()); // set back to equals
		assertTrue(squareOne.equals(squareTwo), msg);

		// Color
		squareTwo.setColor(new Color(0,0,0));
		msg = "After changing one test instance Color, Squares are now not logically equal";
		assertFalse(squareOne.equals(squareTwo), msg);
		squareTwo.setColor(squareOne.getColor()); // set back to equal
		assertTrue(squareOne.equals(squareTwo), msg);

		// isFilled
		squareTwo.setFilled(true);
		msg = "After changing one test instance filled, Squares are now not logically equal";
		assertFalse(squareOne.equals(squareTwo), msg);
		squareTwo.setFilled(squareOne.isFilled()); // set back to equal
		assertTrue(squareOne.equals(squareTwo), msg);

		// Point
		squareTwo.setLocation(new Point(0,0));
		msg = "After changing one test instance Point, Squares are now not logically equal";
		assertFalse(squareOne.equals(squareTwo), msg);
		squareTwo.setLocation(squareOne.getLocation()); // set back to equal
		assertTrue(squareOne.equals(squareTwo), msg);
	}

	@Test
    void testCopyContructor() {
		squareOne = new Square(1, c1, false, p1);
		squareTwo = new Square(squareOne);
		assertTrue(squareOne.equals(squareTwo));
	}

	@Test
	void testArea() {
		squareOne = new Square(1, c1, false, p1);
		double expectedArea = 1;
		double actualArea = squareOne.area();
		assertEquals(expectedArea, actualArea);
	}

	@Test
	void testPerimeter() {
		squareOne = new Square(1, c1, false, p1);
		double expectedPerimeter = 4;
		double actualPerimeter = squareOne.perimeter();
		assertEquals(expectedPerimeter, actualPerimeter);
	}

	@Test
	void setSide() {
		squareOne = new Square(1, c1, false, p1);
		double expectedSide = 4;
		squareOne.setSide(expectedSide);
		double actualSide = squareOne.getSide();
		assertEquals(expectedSide, actualSide);
		
		double expectedHeight = expectedSide;
		double actualHeight = squareOne.getHeight();
		assertEquals(expectedHeight, actualHeight);

		double expectedWidth = expectedSide;
		double actualWidth = squareOne.getWidth();
		assertEquals(expectedWidth, actualWidth);
	}

	@Test
	void setHeight() {
		squareOne = new Square(1, c1, false, p1);
		double expectedSide = 4;
		squareOne.setHeight(expectedSide);
		double actualSide = squareOne.getSide();
		assertEquals(expectedSide, actualSide);
		
		double expectedHeight = expectedSide;
		double actualHeight = squareOne.getHeight();
		assertEquals(expectedHeight, actualHeight);

		double expectedWidth = expectedSide;
		double actualWidth = squareOne.getWidth();
		assertEquals(expectedWidth, actualWidth);
	}

	@Test
	void setWidth() {
		squareOne = new Square(1, c1, false, p1);
		double expectedSide = 4;
		squareOne.setWidth(expectedSide);
		double actualSide = squareOne.getSide();
		assertEquals(expectedSide, actualSide);
		
		double expectedHeight = expectedSide;
		double actualHeight = squareOne.getHeight();
		assertEquals(expectedHeight, actualHeight);

		double expectedWidth = expectedSide;
		double actualWidth = squareOne.getWidth();
		assertEquals(expectedWidth, actualWidth);
	}

}
