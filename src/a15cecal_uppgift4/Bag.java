package a15cecal_uppgift4;

/* Same as for the Bicycle etc, this implements polymorphism in the cart
 * Sets the price for said item, same for the other classes
 */
public class Bag extends Item {
	public int getPrice() {
		return 300;
	}

	public String getProductName() {
		return "Bag";
	}

}
