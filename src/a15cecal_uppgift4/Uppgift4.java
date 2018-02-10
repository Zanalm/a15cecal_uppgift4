package a15cecal_uppgift4;

public class Uppgift4 {

	public static void main(String[] args) {
		UserInterface GUI = new UserInterface();
		GUI.Initialization();

	}

	// For the interface
	public interface GUI {
		int addedItemPrice();

		void clearShoppingCart();

		int totalCost();

		String lastAddedItemName();

		void addItem(String name);

		int itemsInShoppingCart();
	}

}
