/*
	File:	TriangleTests.java
	Author:	Alex Burdick
	Date:	4/23/2025

 	Description: Tests for methods in the Triangle class
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.awt.Color;

public class TriangleTest {

    // Instantiate objects to test
	Color c1 = new Color(0, 0, 255);
    Color c2 = new Color(0, 0, 0);
	Point p1 = new Point(1,2);
	Point p2 = new Point(3,4);
	Triangle triangleOne = new Triangle();
	Triangle triangleTwo = new Triangle();
	String msg = "";
	
	@BeforeEach
    public void setup() {
        triangleOne = null; // clear object data before next test
        triangleTwo = null; // clear object data before next test
    }

    @Test
	void testToString() {
		triangleOne = new Triangle(c1, false, p1, 1, 2);
		triangleTwo = new Triangle(c1, true, p2, 3, 5);
		System.out.println(triangleOne);
		System.out.println(triangleTwo);
	}

    @Test
    void testCopyContructor() {
		triangleOne = new Triangle(c1, false, p1, 1, 2);
		triangleTwo = new Triangle(triangleOne);
		assertTrue(triangleOne.equals(triangleTwo));
	}

	@Test
	void testEqualsTrue() {
		// Triangles are logically not equal
		triangleOne = new Triangle(c1, false, p1, 1, 2);
		triangleTwo = new Triangle(c2, false, p1, 1, 2);

		msg = "Triangles are not logically equal";
		assertFalse(triangleOne.equals(triangleTwo), msg);

		triangleOne.setColor(c1);
		triangleTwo.setColor(c1);
		msg = "After changing both test instances side, Triangles are now logically equal";
		assertTrue(triangleOne.equals(triangleTwo), msg);
	}

	@Test
	void testEqualsFalse() {
		// Rectangles are logically equal
		triangleOne = new Triangle(c1, false, p1, 1, 2);
		triangleTwo = new Triangle(c1, false, p1, 1, 2);
		msg = "Triangles are logically equal";
		assertTrue(triangleOne.equals(triangleTwo), msg);

		// Color
		triangleTwo.setColor(new Color(0,0,0));
		msg = "After changing one test instance Color, Triangles are now not logically equal";
		assertFalse(triangleOne.equals(triangleTwo), msg);
		triangleTwo.setColor(triangleOne.getColor()); // set back to equal
		assertTrue(triangleOne.equals(triangleTwo), msg);

		// isFilled
		triangleTwo.setFilled(true);
		msg = "After changing one test instance filled, Triangles are now not logically equal";
		assertFalse(triangleOne.equals(triangleTwo), msg);
		triangleTwo.setFilled(triangleOne.isFilled()); // set back to equal
		assertTrue(triangleOne.equals(triangleTwo), msg);

		// Point
		triangleTwo.setLocation(new Point(0,0));
		msg = "After changing one test instance Point, Triangles are now not logically equal";
		assertFalse(triangleOne.equals(triangleTwo), msg);
		triangleTwo.setLocation(triangleOne.getLocation()); // set back to equal
		assertTrue(triangleOne.equals(triangleTwo), msg);

		// Height
		triangleTwo.setHeight(10);
		msg = "After changing one test instance height, Triangles are now not logically equal";
		assertFalse(triangleOne.equals(triangleTwo), msg);
		triangleTwo.setHeight(triangleOne.getHeight()); // set back to equals
		assertTrue(triangleOne.equals(triangleTwo), msg);

		// Base
		triangleTwo.setBase(10);
		msg = "After changing one test instance base, Triangles are now not logically equal";
		assertFalse(triangleOne.equals(triangleTwo), msg);
		triangleTwo.setBase(triangleOne.getBase()); // set back to equals
		assertTrue(triangleOne.equals(triangleTwo), msg);
	}

	@Test
	void testArea() {
		triangleOne = new Triangle(c1, false, p1, 1, 2);
		double expectedArea = 1;
		double actualArea = triangleOne.area();
		assertEquals(expectedArea, actualArea);
	}

	@Test
	void testPerimeter() {
		triangleOne = new Triangle(c1, false, p1, 3, 4);
		double expectedPerimeter = 12;
		double actualPerimeter = triangleOne.perimeter();
		assertEquals(expectedPerimeter, actualPerimeter);
	}

	@Test
	void testsetHeithgt() {
		triangleOne = new Triangle(c1, false, p1, 1, 2);
		double expectedHeight = 4;
		triangleOne.setHeight(expectedHeight);
		double actualHeight = triangleOne.getHeight();
		assertEquals(expectedHeight, actualHeight);
	}

	@Test
	void testSetBase() {
		triangleOne = new Triangle(c1, false, p1, 1, 2);
		double expectedBase = 4;
		triangleOne.setBase(expectedBase);
		double actualBase = triangleOne.getBase();
		assertEquals(expectedBase, actualBase);
	}
}
