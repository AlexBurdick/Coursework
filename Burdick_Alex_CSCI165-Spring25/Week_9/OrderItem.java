public class OrderItem {
    
    // ================================
	// || Private instance variables ||
	// ================================
    private MenuItem menuItem;
    private int quantity = 1;
    

    // ==================
	// || Constructors ||
	// ==================
    
    /**
	 * Constructor that accepts all fields
     * 
	 * @param item The menuItem for this order
	 * @param quantity The quantity of the item
	 */
    public OrderItem(MenuItem item, int quantity) {
        
        // validation for quantity, must not be negative
        if (quantity >= 0)
            this.quantity = quantity;

        this.menuItem = new MenuItem(item);
    }

    /**
	 * Copy constructor
     * 
	 * @param OrderItem The OrderItem to copy
	 */
    public OrderItem(OrderItem toCopy) {
        this.menuItem = new MenuItem(toCopy.menuItem);
        this.quantity = toCopy.quantity;
    }


    // ===============
	// || "GETTERS" ||
	// ===============
    
    /**
     * Returns the menuItem field
     * 
     * @return menuIteam (MenuItem) which is a copy from the MenuItem copy constructor
     */
    public MenuItem getMenuItem() {
        return new MenuItem(menuItem);
    }

    /**
     * Returns the quantity field
     * 
     * @return quantity (int)
     */
    public int getQuantity() {
        return quantity;
    }


    // ======================
	// || Expected Methods ||
	// ======================

    /**
     * Returns a string of all the values
     * 
     * @return String of MenuItem toString with quantity concatinted to the end
     */
    public String toString(){
        return menuItem.toString() + " : " + quantity;
    }

    /**
     * Returns the true if the two object are deep equals
     * 
     * @return boolean Returns true when all Fail conditions are false - guaranteed equality
     */
    public boolean equals(OrderItem other){
        if (this == other)return true;		  // identity check
        if (other == null)return false;		  // argument is null, can't be equal

        if (!menuItem.equals(other.menuItem)) // call MenuItem class equals
            return false;

        if (quantity != other.quantity)       // quantity
            return false;

        return true;
    }

    /**
     * Add an input quantity to the current quantity
     * 
     * @param quantity The quantity that we are adding to current quantity
     */
    public void updateQuantity(int input){
        int testNum = this.quantity + input;
        if (testNum >= 0) // Quantity can't be negative
            this.quantity = testNum;
    }
    
} // end class
