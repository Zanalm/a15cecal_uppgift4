package a15cecal_uppgift4;

/* All public types of the items must be declared in it's own file, the program won't compile otherwise. 
 * This shows that the item Flashlight is an subclass of Item. This is true for all the other items too, which also means that we use polymorphism here as it was a goal with the assignment*/
public class ItemFlashlight extends Item {
	public int getItemPrice() {
		return 99; // Sets the price
	}

	public String getItemName() {
		return "Flashlight"; // Sets the name
	}

}
