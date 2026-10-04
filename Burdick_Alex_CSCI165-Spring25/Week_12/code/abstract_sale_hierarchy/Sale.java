/*
 * 
 * This is a simple example of an abstract class that defines a Sale.
 * It is not intended to be instantiated directly, but rather to be subclassed.
 * 
 * An abstract class is a class that has at least one abstract method.
 * An abstract method is a method that has no body and must be implemented by any subclass.
 * 
 * An abstract class can have fields and concrete methods (methods with a body).
 */

public abstract class Sale implements Cloneable, Comparable<Sale>{

	private String name;
	private double price;

	/**
	 * No Argument
	 */
	public Sale( ){
		name = "No name yet";
		price = 0;
	}

	/**
	 * 
	 * @param theName
	 * @param thePrice
	 */
	public Sale(String theName, double thePrice){
		setName(theName);
		setPrice(thePrice);
	}

	/**
	 * 
	 * @param originalObject
	 */
	public Sale(Sale originalObject){
		if (originalObject != null){
			name = originalObject.name;
			price = originalObject.price;
		}
	}

	/**
	 * 
	 * @return price
	 */
	public double getPrice( ){
		return price;
	}

	/**
	 * 
	 * @param newPrice
	 */
	public void setPrice(double newPrice){
		if (newPrice >= 0)
			price = newPrice;
	}

	/**
	 * 
	 * @return name of customer
	 */
	public String getName( ){
		return name;
	}

	/**
	 * 
	 * @param newName
	 */
	public void setName(String newName){
		if (newName != null && newName != "")
			name = newName;
	}

	/**
	 * 
	 * @param otherSale
	 * @return integer specifying order {-1, 0, 1}
	 */
	@Override
	public int compareTo(Sale otherSale){
		if(this == otherSale)               return  0;
		// call polymorphic bill method
		if(this.bill() < otherSale.bill())  return -1;
		if(this.bill() > otherSale.bill())  return  1;
											return  0;
	}

	// really not much to do here
	// at this level bill() is the same as getPrice()
	// but subclasses can override this to define custom behavior
	/**
	 * Copy constructor
	 * @return total for the sale
	 */
	public abstract double bill( );

	// Creates a shallow copy of this Sale object.
	// 
	// Behavior:
	// - Primitive fields and immutable objects (like Strings) are copied directly.
	// - Mutable object references are shared between original and clone.
	// - Will never throw CloneNotSupportedException (throws AssertionError if impossible failure occurs).
	// - Returns Sale type for type safety (not Object).
	//
	// Subclass note:
	// - If Sale contains mutable fields, override this to deep copy them:
	//   @Override
	//   public Sale clone() {
	//       Sale cloned = super.clone();
	//       cloned.mutableField = new MutableType(this.mutableField); // Deep copy
	//       return cloned;
	//
	@Override
	public Sale clone( ){
		try{
			return (Sale)super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError(e); 
		}
	}

	@Override
	public String toString( ){
		return  name + " Price and total cost = $" + bill() ;
	}

	@Override
	public boolean equals(Object otherObject){
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass( ) != otherObject.getClass( )) return false;

		Sale otherSale = (Sale)otherObject;
		
		return  name.equals(otherSale.name)
				&& price == otherSale.price;
	}
}
