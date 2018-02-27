package a15cecal_uppgift4;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.text.StyledDocument;

public class UserInterface {
	JFrame frame = new JFrame("The tiny webshop"); // Title of the window
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

	/*
	 * Here we add everything we need for the interface We also declare how
	 * things should look and be positioned
	 */
	public void Initialization() {
		// For the buttons
		frame.setLayout(new FlowLayout());
		frame.setSize(500, 400); // sets the size for the window
		frame.setLocation(100, 100);
		/* Changes the default cursor, to indicate it's click-able */
		BicycleBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BagBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		FlashlightBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ClearCartBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

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
		ClearCartBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPressed("Clear cart");
			}
		});

		// For the labels
		ItemsInCart = new JLabel("The number of items in cart is:  0");
		totalCost = new JLabel("The total cost is: " + "0 kr");
		latestPurchase = new JLabel("Nothing in cart, let's change that!");

		// sets size for the cart-area
		textPane.setPreferredSize(new Dimension(490, 200));

		// For displaying the different panels
		cartItemsPanel.setPreferredSize(new Dimension(300, 50)); // Sets the
																	// size and
																	// location
																	// for the
																	// number in
																	// cart
																	// text
		pricePanel.setPreferredSize(new Dimension(300, 50)); // Sets the size
																// and location
																// for
																// price-text
		addedItemPanel.setPreferredSize(new Dimension(300, 50)); // Sets the
																	// size and
																	// location
																	// for the
																	// last
																	// added-text

		// Adds the labels to panel and the displayed text to the frame
		cartItemsPanel.add(ItemsInCart);
		pricePanel.add(totalCost);
		addedItemPanel.add(latestPurchase);
		frame.add(cartItemsPanel);
		frame.add(textPane);
		frame.add(pricePanel);
		frame.add(addedItemPanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // default
																		// behavior
																		// of a
																		// JFrame
																		// is to
																		// just
																		// hide
		// on close, that's why you want to define this
		// if you want it to close
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
			try {
				doc.insertString(doc.getLength(), "[Bag] ", null);
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
		case "Bicycle":
			cart.addItem(ItemName);
			try {
				doc.insertString(doc.getLength(), "[Bicycle] ", null);
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
		case "Flashlight":
			cart.addItem(ItemName);
			try {
				doc.insertString(doc.getLength(), "[Flashlight] ", null);
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
		case "Clear cart":
			cart.clearShoppingCart();
			textPane.setText(""); // Makes the textArea look empty
			break;
		}

		if (!ItemName.equals("Clear cart")) {
			LastBought();
		} else {

		}
		updateTextInApp();
	}
}
