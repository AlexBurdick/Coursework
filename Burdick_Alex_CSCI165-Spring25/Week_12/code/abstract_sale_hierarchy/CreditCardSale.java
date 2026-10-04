public class CreditCardSale extends Sale{

	private double fee;

	/**
	 * 
	 * @param fee
	 */
	public CreditCardSale(double fee) {
		this.fee = fee;
	}

	/**
	 * 
	 * @param theName
	 * @param thePrice
	 * @param fee
	 */
	public CreditCardSale(String theName, double thePrice, double fee) {
		super(theName, thePrice);
		this.fee = fee;
	}

	/**
	 * 
	 * @param originalObject
	 * @param fee
	 */
	public CreditCardSale(Sale originalObject, double fee) {
		super(originalObject);
		this.fee = fee;
	}

	/**
	 * Copy Constructor
	 * @param other
	 */
	public CreditCardSale(CreditCardSale other){
		super(other);
		this.fee = other.fee;
	}

	/**
	 * 
	 * @return the credit card fee
	 */
	public double getFee() {
		return fee;
	}

	/**
	 * 
	 * @param fee
	 */
	public void setFee(double fee) {
		this.fee = fee;
	}

	// override superclass bill method
	@Override
	public double bill(){
		return getPrice() + getFee();
	}
	
	@Override
	public String toString(){
		return  super.toString() +
				" Credit Card fee: $" + fee +
				" Total cost = $" + bill();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)                    return true;
		if (obj == null)                    return false;
		if (!super.equals(obj))             return false;
		if (getClass() != obj.getClass())   return false;

		CreditCardSale other = (CreditCardSale) obj;

		if (Double.doubleToLongBits(fee) != Double.doubleToLongBits(other.fee))
			return false;
		return true;
	}

	@Override
	public CreditCardSale clone( ){
		return new CreditCardSale(this);
	}
}
