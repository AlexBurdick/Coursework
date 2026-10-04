public class MenuItem {
    
    // ================================
	// || Private instance variables ||
	// ================================
    private String name	 = "unknown";
    private double price = 1.0;
    private int calories = 0;


    // ==================
	// || Constructors ||
	// ==================

    /**
	 * Constructor that accepts all fields
     * 
	 * @param name  The item name
	 * @param price	 The item price
	 * @param calories  The item calories
	 */
    public MenuItem(String name, double price, int calories){
        this.setName(name);
        this.setPrice(price);
        this.setCalories(calories);
    }

    /**
	 * Copy constuctor
     * 
	 * @param item MenuItem object to be deep copied
	 */
    public MenuItem(MenuItem toCopy){
        this.name     = toCopy.name;
        this.price    = toCopy.price;
        this.calories = toCopy.calories;
    }


    // =============================
	// || "GETTERS" and "SETTERS" ||
	// =============================

    /**
	 * Returns the name field
     * 
	 * @return name (String)
	 */
    public String getName() {
        return name;
    }

    /**
     * Sets the item's name
     * 
     * @param name The item's name
     */
    public void setName(String name) {
        if(name != null) // null check
            this.name = name;
    }

    /**
     * Returns the price field
     * 
     * @return price (double)
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the item's price
     * 
     * @param price The item's price
     */
    public void setPrice(double price) {
        if(price > 0)
            this.price = price;
    }

    /**
     * Returns the calories field
     * 
     * @return calories (int)
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Sets the item's calories
     * 
     * @param calories The item's calories
     */
    public void setCalories(int calories) {
        if(calories >= 0)
            this.calories = calories;
    }


    // ======================
	// || Expected Methods ||
	// ======================
    
    /**
     * Returns a string of all the values
     * 
     * @return String of all variables as strings
     */
    public String toString(){
        return String.format("%s - $%.2f (%d)", name, price, calories);
	}

    /**
     * Returns true if the two object are deep equals
     * 
     * @return boolean true if all Fail conditions are false - guaranteed equality
     */
    public boolean equals(MenuItem other){
        if (this == other)return true;  // identity check
        if (other == null)return false;	// argument is null, can't be equal

        // Collection of fail first, fail fast conditions
        if (name == null){					// name, with null checks
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))	// call String class equals
            return false;

        if (price != other.price)			// price
            return false;
        if (calories != other.calories)     // calories
            return false;

        return true;
    }

    /**
     * Method to determine the order based on calories
     * 
     * @param other The MenuItem object to be compared to this one
     * @return int 0 if they are equal
     */
    public int compareTo(MenuItem other){ 
        if (this.calories < other.calories) return -1;
        if (this.calories > other.calories) return 1;
        
        return 0;
    }

} // end class MenuItem