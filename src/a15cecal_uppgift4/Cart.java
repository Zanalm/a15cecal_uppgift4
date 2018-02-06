package a15cecal_uppgift4;

import java.util.ArrayList;

// This means that this class will implement the interface CartGUI
public class Cart implements CartGUI {
	private ArrayList<Item> cartItems = new ArrayList<>(); // This initialize a new ArrayList with the type it can contain set to Item

	// This is for the function clear cart that the user can use, this is also used
	// in the CartGUI-file as for most of the other methods in this file
	// This below adds items to the created ArrayList
	public void clearCart() {
		cartItems.clear();
	}

	// Adds the item and it's name to the cart
	public void addItem(String name) {
		switch (name) {
		case "Bag":
			cartItems.add(new Bag());
			break;
		case "Bicycle":
			cartItems.add(new Bicycle());
			break;
		case "Flashlight":
			cartItems.add(new Flashlight());
			break;
		}
	}
	
	 // This is the method in use for writing out the total price for the cart
	public int totalCost() {
		int totalPrice = 0;
		for (Item item : cartItems) {
			totalPrice += item.getPrice();
		}
		return totalPrice; // writes out the price
	}

	// Returns the amount of items in cart
	public int itemsInCart() {
		return cartItems.size(); /*.size() returns the number of elements in the cart, so this is the size of the ArrayList*/
	}
	
	// We begin to write out the name of the latest item that was added to the cart
	public String addedItemName() {
		return cartItems.get(cartItems.size() - 1).getProductName();
	}
	
	// Then we return the price for said item
	public int addedItemPrice() {
		return cartItems.get(cartItems.size() - 1).getPrice();
	}

	@Override
	public String lastAddedItemName() {
		// TODO Auto-generated method stub
		return null;
	}
}
