package test.junit;

import java.util.List;

/**
 * Class ShoppingCart.
 * @author Valter R. Inacio Jr.
 * Created on 02/04/2005, 18:21:14.
 */
public class ShoppingCart {

	/** The list of items. */
	private List items;
	
	/** The total price of the shopping (in dollars). */
	private double total;
	
	/** The total discount of the shopping (in dollars). */
	private double discount;
	
	/** Constructor. */
	public ShoppingCart() {
		// TODO
	}
	
	/**
	 * Adds an item to the shopping cart.
	 * @param item The item to be added.
	 * @return True if the item was added; false otherwise.
	 */
	public boolean addItem(ShoppingItem item) {
		// TODO
	}
	
	/**
	 * Removes an item from the shopping cart.
	 * @param item The item to be removed.
	 * @return True if the item was removed; false otherwise.
	 */
	public boolean removeItem(ShoppingItem item) {
		// TODO
	}
	
	/**
	 * Removes all the items from the shopping cart.
	 * @return True if the items were removed; false otherwise.
	 */
	public boolean removeAllItems() {
		// TODO 
	}
		
	/**
	 * Gets the total price of the shopping.
	 * @return The total price.
	 */
	public double getTotal() {
		return total;
	}
	
	/**
	 * Gets the total discount of the shopping. 
	 * @return The total discount.
	 */
	public double getDiscount() {
		return discount;
	}
	
	/**
	 * Gets the total price of the items calculated with the discount.
	 * @return Returns the total.
	 */
	public double getTotalWithDiscount() {
		// TODO
	}
	
	/**
	 * Gets the number of items.
	 * @return Returns the number of items.
	 */
	public int getNumberOfItems() {
		return items.size();
	}
	
}
