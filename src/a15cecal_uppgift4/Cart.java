package a15cecal_uppgift4;

import java.util.ArrayList;

public class Cart implements CartGUI {
	private ArrayList<Item> cart = new ArrayList<>(); // An ArrayList of items, uses polymorphism since the cart is
														// containing different types, Bag and so on

	public Cart() {
	}

	// A simple method for clearing the cart
	public void clearCart() {
		cart.clear();
	}

	/**
	 * A method to iterate over all items in the cart and add all the prices,
	 * resulting in a total price of the cart
	 */
	public int totalCost() {
		int totalPrice = 0;
		for (Item item : cart) {
			totalPrice += item.getPrice();
		}
		return totalPrice;
	}

	// Returns the amount of items in cart
	public int itemsInCart() {
		return cart.size();
	}

	// Returns the price of the latest item in cart
	public int latestItemPrice() {
		return cart.get(cart.size() - 1).getPrice();
	}

	// Returns the name of the latest item in cart
	public String latestItemName() {
		return cart.get(cart.size() - 1).getProductName();
	}

	// Adds an item. This is to enable expansion for the cart
	public void addItem(String name) {
		switch (name) {
		case "Bag":
			cart.add(new Bag());
			break;
		case "Bicycle":
			cart.add(new Bicycle());
			break;
		case "Flashlight":
			cart.add(new Flashlight());
			break;
		}
	}
}
