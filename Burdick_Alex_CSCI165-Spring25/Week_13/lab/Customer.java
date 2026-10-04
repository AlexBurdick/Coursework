/*
 * File:	Customer.java
 * Author:	Alex Burdick
 * Date:	4/14/2025
 * 
 * Description: This class represents a customer that has a dateJoined and a customer ID.
 *              Customer is a subclass of Person.
 */


public class Customer extends Person {
    // Class variables
    Date dateJoined;
    String custID;

    /* When the Date object is instantiated here, it doesn't call the Date constructor to create
     * an instance of a Date object. Instead it creates a null pointer which can't get used to call
     * methods or variables of the class.
     */

    // Constructors

    /**
	 * Overloaded constructor accepts all fields as arguments
     * 
	 * @param firstName
     * @param lastName
     * @param Phone
     * @param DOB
     * @param dateJoined
     * @param custID
	 */
    public Customer(String firstName, String lastName, String Phone, Date DOB, Date dateJoined, String custID) {
        super(firstName, lastName, Phone, DOB); // invoke the super class constructor
        setDateJoined(dateJoined); // copy of date passed in
        
        // Set the customer ID
        try {
            setID(custID);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
	 * Overloaded constructor accepts a Person object as an argument
     * 
	 * @param p Person super class
     * @param dateJoined
     * @param custID
	 */
    public Customer(Person p, Date dateJoined, String custID) {
        super(p); // invoke the super class constructor
        setDateJoined(dateJoined); // copy of date passed in
        
        // Set the customer ID
        try {
            setID(custID);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
	 * Copy constructor
     * Is there a more efficient way to do this?
     * 
	 * @param toCopy Customer object ot be copied
	 */
    public Customer(Customer toCopy) {
        this(   toCopy.getFirstName(), 
                toCopy.getLastName(),
                toCopy.getRawPhoneNumber(),
                toCopy.getDOB(),
                toCopy.getDateJoined(),
                toCopy.getID()
            ); // invoke overloaded constructor
    }

    // Getters & Setters

    /**
	 * Get dateJoined
     * 
	 * @return dateJoined
	 */
    public Date getDateJoined() {
        return new Date(dateJoined);
    }

    /**
	 * Set dateJoined
     * 
	 * @param dateJoined
	 */
    public void setDateJoined(Date dateJoined) {
        /* Null check - keeps the value null and avoids calling the Date copy constructor, 
         * which will throw null pointer exceptions if the Date object passed in is null. */
        if (dateJoined == null) return;

        this.dateJoined = new Date(dateJoined); // copy of date passed in
    }

    /**
	 * Get custID
     * 
	 * @return custID
	 */
    public String getID() {
        return custID;
    }

    /**
	 *  Validates that the customer ID is a letter followed by three numbers.
     * 
	 * @param id the customer ID to be tested
	 */
    public void setID(String id) throws IDNotWellFormedException {
        if (id != null && id.matches("[A-Za-z]\\d{3}")) // written by Copilot
            custID = id;
        else throw new IDNotWellFormedException(
            "The ID " + id + " is not valid. The customer ID must be a letter followed by three digits.");
    }

    // Expected Methods

    /**
	 * Overriden toString that uses the toString of the super class
     * 
	 * @return the values converted to a String
	 */
    @Override
    public String toString() {
        return super.toString() + "\nJoined: " + dateJoined + "\nID: " + custID;
    }

    /**
	 * Overriden equals that does a deep comparison
     * 
	 * @return true if the objects are the same
	 */
    @Override
    public boolean equals(Object obj) {
        // fail fast checks
        if (obj == null)                    return false; // null check
        if (this == obj)                    return true;  // identity check
        if (!super.equals(obj))             return false; // inheritance check
        if (getClass() != obj.getClass())   return false; // class check
        
        Customer other = (Customer) obj;  // down cast
        
        if (dateJoined == null) {           // copilot suggested null checks for other member objects
            if (other.dateJoined != null)   // this will prevent null pointer errors when the equals methods
                return false;               // for those classes are called
        } else if (!dateJoined.equals(other.dateJoined)) // invoke the Date class equals method
            return false;
        if (custID == null) {
            if (other.custID != null)
                return false;
        } else if (!custID.equals(other.custID))
            return false;
        return true;
    }
    
    /**
	 * Overriden clone that invokes the copy constructor
     * 
	 * @return a copy of this
	 */
    @Override
    public Customer clone() {
        Customer cloned = new Customer(this);
        return cloned;
    }
    
} // end Customer class
