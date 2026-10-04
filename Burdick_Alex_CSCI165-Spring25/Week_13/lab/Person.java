/*
 * File:	Person.java
 * Author:	Ken Whitener
 * Date:	4/15/2024
 * 
 * Description: This class represents a person with a first name, last name, phone number, and date of birth.
 */

public class Person{
	// There will be a default value for testing purposes, to prevent null pointer exceptions
	private final String unknown = "unknown";
	// instance variables
	private String firstName; // no default value for names because the constructors require these fields
	private String lastName;
	private String phoneNumber = unknown; // setting a defualt value for phone number
	private Date   DOB;


	//constructors

	/*
	The user should not be able to create a Person object without passing in a name,
	so we won't provide a no argument constructor. 
	*/

	/**
	 * No argument constructor	
	 */
	//public Person(){}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName) {
		this.firstName	= firstName;
		this.lastName	= lastName;
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 */
	public Person(String firstName, String lastName, String phoneNumber) {
		this(firstName, lastName);			// call to overloaded constructor
		this.setPhoneNumber(phoneNumber);
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param DOB
	 */
	public Person(String firstName, String lastName, String phoneNumber, Date DOB) {
		this(firstName, lastName);			// call overloaded constructor
		this.setPhoneNumber(phoneNumber);
		this.setDOB(DOB);
	}

	/**
	 * Copy Constructor
	 * @param toCopy Person object to copy
	 */
	public Person(Person toCopy){
		// uses "this" to call constructor in the same class
		this(	toCopy.getFirstName(), 
				toCopy.getLastName(), 
				toCopy.getRawPhoneNumber(), 
				toCopy.getDOB()
			); // invoke overloaded constructor
	}

	/**
	 * 
	 * @return Person's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return Person's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return Person's full name
	 */
	public String getName(){
		return this.firstName + " " + this.lastName;
	}

	/**
	 * 
	 * @return Person's formatted phone number
	 */
	public String getPhoneNumber() {
		// Adding check for default value
		if (phoneNumber == unknown) return phoneNumber;
		
		String area		= phoneNumber.substring(0, 3);
		String prefix	= phoneNumber.substring(3, 6);
		String route	= phoneNumber.substring(6);
		return "(" + area + ")" + prefix + "-" + route;
	}

	/**
	 * Adding another getter for phoneNumber, because the above one returns a 
	 * string that is longer than 10 characters long. This makes the setter
	 * below ignore it. This will be used when using the copy constructor and a
	 * phone number from another instance of Person class needs to be passed in.
	 * 
	 * @return Person's unformatted phone number
	 */
	public String getRawPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		if(phoneNumber.length() == 10)
			this.phoneNumber = phoneNumber;
	}

	/**
	 * 
	 * @param DOB
	 */
	public void setDOB(Date DOB){
		/* Null check - keeps the value null and avoids calling the Date copy constructor, 
         * which will throw null pointer exceptions if the Date object passed in is null. */
        if (DOB == null) return;

		this.DOB = new Date(DOB);		// privacy protection
	}

	/**
	 * 
	 * @return The Person's Date of Birth
	 */
	public Date getDOB(){
		if (DOB == null) return null; // account for null date
		return new Date(this.DOB);	  // privacy protection
	}

	@Override
	public String toString() {
		return  "Name: " 	+ firstName + " " + lastName + "\n" +
				"Phone: " 	+ getPhoneNumber() + "\n" +
				"DOB: " 	+ DOB;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)					return true;	// identity check
		if (obj == null)					return false;	// null check
		if (getClass() != obj.getClass())	return false;	// origin check	(inheritance)

		Person other = (Person) obj;						// down cast

		// check each field, be mindful of null pointers when dealing with objects
		if (firstName == null){							// check first name
			if (other.firstName != null)
				return false;
		}
		else if (!firstName.equals(other.firstName))		// calls String.equals (composition)
			return false;

		if (lastName == null){								// check last name
			if (other.lastName != null)
				return false;
		}
		else if (!lastName.equals(other.lastName))			// calls String.equals (composition)
			return false;

		if (phoneNumber == null){							// check phone number
			if (other.phoneNumber != null)
				return false;
		}
		else if (!phoneNumber.equals(other.phoneNumber))	// calls String.equals (composition)
			return false;

		if (DOB == null){									// check DOB
			if (other.DOB != null)
				return false;
		}
		else if (!DOB.equals(other.DOB))					// calls Date.equals (composition)
			return false;

		return true;
	}
}