public class DiscountSale extends Sale{

	private double discount;

	/**
	 * No argument constructor
	 */
	public DiscountSale( ){
		super( );
		discount = 0;
	}

	/**
	 * 
	 * @param theName
	 * @param thePrice
	 * @param theDiscount
	 */
	public DiscountSale(String theName, double thePrice, double theDiscount){
		super(theName, thePrice);
		setDiscount(theDiscount);
	}

	/**
	 * 
	 * @param originalObject
	 */
	public DiscountSale(DiscountSale originalObject){
		super(originalObject);
		discount = originalObject.discount;
	}

	/**
	 * 
	 * @return the dscount amount
	 */
	public double getDiscount( ){
		return discount;
	}

	/**
	 * 
	 * @param newDiscount
	 */
	public void setDiscount(double newDiscount){
		if (newDiscount >= 0)
			discount = newDiscount;
	}

	// override superclass bill method
	@Override
	public double bill( ){
		double fraction = discount/100;
		return (1 - fraction) * getPrice( );
	}

	@Override
	public String toString( ){
		return  super.toString()
				+ "\n\tDiscount = " + discount + "% "
				+ "Total cost = $" + bill( );
	}

	@Override
	public boolean equals(Object otherObject){
		if (this == otherObject)     return true;
		if (otherObject == null)    return false;
		if (getClass( ) != otherObject.getClass( )) return false;

		DiscountSale otherDiscountSale = (DiscountSale)otherObject;
		return  super.equals(otherDiscountSale)
				&& discount == otherDiscountSale.discount;
	}

	@Override
	public DiscountSale clone( ){
		return new DiscountSale(this);
	}
}
