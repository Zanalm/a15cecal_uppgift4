package a15cecal_uppgift4;

public interface CartGUI {
	int addedItemPrice();

	void clearCart();

	int totalCost();

	String lastAddedItemName();

	void addItem(String name);

	int itemsInCart();
}
