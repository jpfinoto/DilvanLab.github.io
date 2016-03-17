package test.junit;

/**
 * Class ShoppingItem.
 * @author Valter R. Inacio Jr.
 * Created on 02/04/2005, 18:37:17.
 */
public class ShoppingItem {
		
	/** The id number of the item. */
	private long id;
	
	/** The name of the item. */
	private String name;
	
	/** The price of the item (in dollars). */
	private double price;
	
	/** The discount of the item (in percentage). */
	private double discount;
	
	/**
	 * Constructor.
	 * @param id The id to set.
	 * @param name The name to set.
	 * @param price The price to set.
	 * @param discount The discount to set.
	 * @throws IllegalArgumentException - if the parameters have invalid values.
	 */
	public ShoppingItem(long id, String name, double price, double discount) 
		throws IllegalArgumentException {
		// TODO
	}
	
	/**
	 * Tests if two items are equal (share the same id number).
	 * @param obj The object to be compared.
	 * @return True if the two objects are equal; false otherwise.
	 */
	public boolean equals(Object obj) {
		if (obj instanceof ShoppingItem) {
			ShoppingItem item = (ShoppingItem) obj;
			return (this.id == item.id);
		}
		return false;
	}
	
	/**
	 * Gets the id of the item.
	 * @return Returns the id.
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Gets the name of the item.
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the price of the item.
	 * @return Returns the price.
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Gets the price of the item calculated with the discount.
	 * @return Returns the price.
	 */
	public double getPriceWithDiscount() {
		// TODO
	}
		
	/**
	 * Gets the discount of the item.
	 * @return Returns the discount.
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * Sets the id of the item.
	 * @param id The id to set.
	 * @throws IllegalArgumentException - if the id is negative.
	 */
	public void setId(long id) throws IllegalArgumentException {
		// TODO
	}
	
	/**
	 * Sets the name of the item.
	 * @param name The name to set.
	 * @throws IllegalArgumentException - if the name is null or an empty string.	 
	 */
	public void setName(String name) throws IllegalArgumentException {
		// TODO
	}
	
	/**
	 * Sets the price of the item.
	 * @param price The price to set.
	 * @throws IllegalArgumentException - if the price is negative or equals zero.
	 */
	public void setPrice(double price) throws IllegalArgumentException {
		// TODO
	}

	/**
	 * Sets the discount of the item.
	 * @param discount The discount to set.
	 * @throws IllegalArgumentException - if the discount is negative.
	 */
	public void setDiscount(double discount) throws IllegalArgumentException {
		// TODO
	}
	
}
