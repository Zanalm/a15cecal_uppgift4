package a15cecal_uppgift4;

// This is an interface that makes it so that all different carts behave in the same manners
public interface CartGUI {
	void clearCart();

	int totalCost();

	int itemsInCart();

	int latestItemPrice();

	String latestItemName();

	void addItem(String name);

}
