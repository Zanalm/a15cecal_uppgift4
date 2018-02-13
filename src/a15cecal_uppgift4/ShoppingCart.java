package a15cecal_uppgift4;

import java.util.ArrayList;

import a15cecal_uppgift4.Uppgift4.GUI;

// This means that this class will implement the interface CartGUI declared in the file Uppgift4
public class ShoppingCart implements GUI {
	private ArrayList<Item> shoppingCartItems = new ArrayList<>(); // This
																	// initialize
																	// a new
																	// ArrayList
																	// with the
																	// type it
																	// can
	// contain set to Item

	// This is for the function clear cart that the user can use, this is also
	// used
	// in the interface-file as for most of the other methods in this file
	public void clearShoppingCart() {
		shoppingCartItems.clear();
	}

	// Adds the item and it's name to the cart
	public void addItem(String nameOfItem) {
		switch (nameOfItem) {
		case "Bag":
			shoppingCartItems.add(new ItemBag());
			break;
		case "Bicycle":
			shoppingCartItems.add(new ItemBicycle());
			break;
		case "Flashlight":
			shoppingCartItems.add(new ItemFlashlight());
			break;
		}
	}

	// This is the method in use for writing out the total price for the cart
	public int totalCost() {
		int totalValue = 0;
		for (Item item : shoppingCartItems) {
			totalValue += item.getItemPrice();
		}
		return totalValue; // writes out the price
	}

	// Writes out the number of items that the user bought
	public int itemsInShoppingCart() {
		return shoppingCartItems
				.size(); /*
							 * .size() returns the number of elements in the
							 * cart, so this is the size of the ArrayList
							 */
	}

	// We begin to write out the name of the latest item that was added to the
	// cart
	public String addedItemName() {
		return shoppingCartItems.get(shoppingCartItems.size() - 1).getItemName();
	}

	// Then we return the price for said item
	public int addedItemPrice() {
		return shoppingCartItems.get(shoppingCartItems.size() - 1).getItemPrice();
	}

	public String lastAddedItemName() {
		return null;
	}

}
