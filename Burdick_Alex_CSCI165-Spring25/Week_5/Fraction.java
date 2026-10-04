/*
 * File:		Fraction.java
 * Author:		Ken Whitener
 * Modified By: Alex Burdick
 * Date:		March 20, 2025
 * 
 * This file contains the definition of a class that represents a fraction.
 * 
 * TASK:	Complete the implementation of the Fraction class as described in the comments below.
 * 			Respond to each TO DO comment by implementing the described functionality.
 * 
 * 			Add your name to the "Modified By" line above.
 */

public class Fraction {

	// +============================+
	// | PRIVATE INSTANCE VARIABLES |
	// +============================+
	private int numerator;		// the numerator of the fraction

	// TO DO: add a private int instance variable for the denominator

	// +==============+
	// | CONSTRUCTORS |
	// +==============+

	/**
	 * Fraction constructor that takes 2 arguments
	 * 
	 * @param n	the numerator of the fraction
	 * @param d	the denominator of the fraction
	 */
	public Fraction(int n, int d) {
		// TO DO: implement this constructor.
		// denominator should not be set to 0. If it is, set it to 1
		// but you may not duplicate validation code in the constructor
	}

	// TO DO: add a constructor that takes 1 argument (the numerator) and sets the denominator to 1

	// +=========================+
	// | PUBLIC INSTANCE METHODS |
	// +=========================+

	/**
	 * Sets the numerator of the fraction
	 * @param n
	 */
	public void setNumerator(int n) {
		// TO DO: implement this method
	}

	/**
	 * 
	 * @return the numerator of the fraction
	 */
	public int getNumerator() {
		// TO DO: implement this method
		return 0;	// replace this with the correct return value
	}

	// TO DO: add a method to set the denominator of the fraction
	//		  prevent the denominator from being set to 0.
	//		  Set it to 1 if so. Call this method from the constructor to validate the denominator.

	// TO DO: add a method to get the denominator of the fraction

	/**
	 * Method to add a fraction to this fraction
	 * @return	nothing
	 */
	public void add(Fraction f) {
		// TO DO: implement this method
	}

	// TO DO: add a void method to subtract a fraction from this fraction
	// TO DO: add a void method to multiply this fraction by another fraction
	// TO DO: add a void method to divide this fraction by another fraction
	// TO DO: add a void method to reduce the fraction to lowest terms

	/**
	 * 
	 * @return the value of the fraction as a double
	 */
	public double toDecimal() {
		// TO DO: implement this method
		return 0.0;	// replace this with the correct return value
	}

	/**
	 * 
	 * @return the value of the fraction as a string "numerator/denominator"
	 */
	public String toString() {
		// TO DO: implement this method
		return "";	// replace this with the correct return value
	}

	/**
	 * Determines if this fraction is equal to another fraction
	 * @param f	the fraction to compare to
	 * @return	true if the fractions are equal, false otherwise
	 */
	public boolean equals(Fraction f) {
		// TO DO: implement this method
		return false;	// replace this with the correct return value
	}

	/**
	 * Compares this fraction to another fraction to determine lexical ordering
	 * @param f	the fraction to compare to
	 * @return	-1 if this fraction is less than f, 0 if they are equal, 1 if this fraction is greater than f
	 */
	public int compareTo(Fraction f) {
		// TO DO: implement this method
		return 0;	// replace this with the correct return value
	}

	// +=================+
	// | PRIVATE METHODS |
	// +=================+

	// In practice we do not document private methods using javadoc comments
	// because they are not part of the public interface of the class.
	private int gcd(int a, int b) {
		// TO DO: implement this method
		return 0;	// replace this with the correct return value
	}

}
