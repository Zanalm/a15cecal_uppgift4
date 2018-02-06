package a15cecal_uppgift4;

// The class for Flashlights. This is for example where we set the price for the item
// This shows that the item Flashlight is an subclass of Item. This is true for all the other items too
public class Flashlight extends Item {
	public int getPrice() {
		return 99; // Sets price
	}

	public String getProductName() {
		return "Flashlight"; // Sets name
	}

}
