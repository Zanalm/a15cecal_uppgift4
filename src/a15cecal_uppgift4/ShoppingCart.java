package a15cecal_uppgift4;

import java.util.ArrayList;

import a15cecal_uppgift4.Uppgift4.GUI;

// This means that this class will implement the user interface declared in the file Uppgift4
public class ShoppingCart implements CartGUI {
	private ArrayList<Item> shoppingCartItems = new ArrayList<>(); /*
																	 * This
																	 * initializes
																	 * a new
																	 * ArrayList
																	 * with the
																	 * type it
																	 * can
																	 * contain
																	 * set to
																	 * Item
																	 */

	/* This is for the function to clear the cart */
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
		return totalValue;
	}

	// Writes out the number of items that the user bought
	public int itemsInShoppingCart() {
		return shoppingCartItems.size();
	}

	// Writes out the name of the latest item that was added to the
	// cart
	public String addedItemName() {
		return shoppingCartItems.get(shoppingCartItems.size() - 1).getItemName();
	}

	// Returns the price for said item
	public int addedItemPrice() {
		return shoppingCartItems.get(shoppingCartItems.size() - 1).getItemPrice();
	}

	public String lastAddedItemName() {
		return null;
	}

	@Override
	public void addItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int addedItemsPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

}
