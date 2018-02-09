package a15cecal_uppgift4;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class UserInterface {
	JFrame frame = new JFrame("The tiny webshop");
	private ShoppingCart cart = new ShoppingCart();
	JButton BagBtn = new JButton("Bag");
	JButton BicycleBtn = new JButton("Bicycle");
	JButton FlashlightBtn = new JButton("Flashlight");
	JButton ClearCartBtn = new JButton("Clear cart");
	JPanel buttonPanel = new JPanel();
	JPanel addedItemPanel = new JPanel();
	JPanel pricePanel = new JPanel();
	JPanel cartItemsPanel = new JPanel();
	JTextPane textPane = new JTextPane();
	StyledDocument doc = textPane.getStyledDocument();
	Container contentPane = frame.getContentPane();    
	JLabel ItemsInCart;
	JLabel totalCost;
	JLabel latestPurchase;

	public void Initialization() {
		// For the buttons
		frame.setLayout(new FlowLayout());
		frame.setSize(500, 400); // sets the size for the window
		frame.setLocation(100, 100);
		buttonPanel.add(BagBtn);
		buttonPanel.add(BicycleBtn);
		buttonPanel.add(FlashlightBtn);
		buttonPanel.add(ClearCartBtn);
		frame.add(buttonPanel); // adds it to the frame
		// these down below will handle the events of when a button is clicked
		BicycleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPressed("Bicycle");
			}
		});
		FlashlightBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPressed("Flashlight");
			}
		});
		BagBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPressed("Bag");
			}
		});
		

		// For the labels
		ItemsInCart = new JLabel("The number of items in cart is:  0");
		totalCost = new JLabel("The total cost is: " + " kr"); // move this down below the text-window to the right
		latestPurchase = new JLabel("Nothing in cart, let's change that!"); // move this to a new panel later for the styling
		
		// The cart text
		textPane.setText( "some badass text" ); // this is for the JTextPane, also adds some styling
		SimpleAttributeSet keyWord = new SimpleAttributeSet();
		StyleConstants.setForeground(keyWord, Color.RED);
		StyleConstants.setBackground(keyWord, Color.YELLOW);
		StyleConstants.setBold(keyWord, true);
		try
		{
		    doc.insertString(0, "Start of text\n", null ); // this will "override" the first sentence and put this one at the top
		    doc.insertString(doc.getLength(), "\nEnd of text", keyWord ); // This also adds text but in a different way than the first one
		}
		catch(Exception e) { System.out.println(e); }
		
		// sets size for the cart-area
		textPane.setPreferredSize( new Dimension(490, 200)); 
		
		// For displaying the different panels
		cartItemsPanel.setPreferredSize( new Dimension(300, 50)); // Sets the size and location for the number in cart text
		pricePanel.setPreferredSize( new Dimension(300, 50)); // Sets the size and location for price-text
		addedItemPanel.setPreferredSize( new Dimension(300, 50)); // Sets the size and location for the last added-text
		
		cartItemsPanel.add(ItemsInCart);
		pricePanel.add(totalCost);
		addedItemPanel.add(latestPurchase);
		frame.add(cartItemsPanel);
		frame.add(textPane);
		frame.add(pricePanel);
		frame.add(addedItemPanel);
		frame.setVisible(true);
	}
	
	private void updateTextInApp() {
		totalCost.setText("Total cost: " + cart.totalCost() + " kr");
		ItemsInCart.setText("The number of items in cart is: " + cart.itemsInShoppingCart());
	}

	private void LastBought() {
		latestPurchase.setText(
				cart.lastAddedItemName() + " with cost of " + cart.addedItemPrice() + " kr is being added to the cart");
	}
	
	// This handles the case when an button is pressed, the set actions for said
		// button
		private void buttonPressed(String ItemName) {
			switch (ItemName) {
			case "Bag":
				cart.addItem(ItemName);
				textPane.setText("[Bag] "); /*
											 * This is the text shown in the cart
											 * a.k.a the textArea
											 */
				break;
			case "Bicycle":
				cart.addItem(ItemName);
				textPane.setText("[Bicycle] ");
				break;
			case "Flashlight":
				cart.addItem(ItemName);
				textPane.setText("[Flashlight] ");
				break;
			case "Clear cart":
				cart.clearShoppingCart();
				textPane.setText(""); // Makes the textArea look empty
				latestPurchase.setText("Cart was cleared");
				break;
			}

			if (!ItemName.equals("Clear cart")) { // If the button that was pressed
													// is not the "Clear
													// cart"-button an
													// additional
													// space is added and this
													// updates the cart to the
													// latest purchase
				LastBought();
			}
			updateTextInApp();
		}
	}
