package a15cecal_uppgift4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
	private static final long serialVersionUID = 8956595341030113259L;
	private Cart cart = new Cart();
	private JTextArea textArea;
	private JLabel numberOfItemsInCart;
	private JLabel totalPrice;
	private JLabel latestPurchase;

	// Default constructor for the class GUI
	public GUI(String title) {
		super(title); // Pushes the title of the window
		appSettings(); // Applies all settings for the window
		buttons(); // Creates all the buttons needed
		labels(); // Creates the labels
		setTextArea(); // Creates the textArea for the window
	}

	/**
	 * A method that sets the size, visibility etc. and how to quit the application
	 */
	private void appSettings() {
		setLayout(new GridBagLayout()); // Sets the layout to GridBagLayout
		this.setSize(650, 450); // Sets the size of the window
		this.setLocationRelativeTo(null); // Centers the window relative to null, rendering the window in the center of
											// the screen
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * A method to set the text areas for the application
	 */
	private void setTextArea() {
		Color clr1 = new Color(0.85f, 0.90f, 0.95f); /*
														 * This is for changing color, the default colors were too
														 * bright so created one that fit better
														 */

		GridBagConstraints gc = new GridBagConstraints(); // A GridBagConstraints to specify where the elements should
															// appear
		gc.fill = GridBagConstraints.BOTH; // Forces element to fill the space that is available
		gc.weightx = 1; // Specifies the weight of the element. This makes the element fill a greater
						// area
		gc.weighty = 1; // Same as above, but only on the y-axis
		gc.gridwidth = 4; // How many cells this element should span
		gc.gridx = 0; // Position of the element on the x-axis
		gc.gridy = 2; // Position of the element on the y-axis
		gc.insets = new Insets(0, 15, 0, 150);
		textArea = new JTextArea();
		textArea.setEditable(false); // Makes it so that the user can't edit the text in the textArea
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBackground(clr1); // Implements the created color

		JScrollPane jScrollPane = new JScrollPane(textArea); // Creates a JScrollPane with the textArea. This makes it
																// possible to scroll
		add(jScrollPane, gc);
	}

	// Updates the labels that are not controlled/inherited by Item
	private void labels() {
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = 0;
		gc.gridy = 1; // Decides where the label will show up
		gc.weightx = 0.5;
		gc.weighty = 0.1;
		gc.gridwidth = 4;
		gc.insets = new Insets(0, 15, 0, 15);
		numberOfItemsInCart = new JLabel("The number of items in cart is:  0");
		add(numberOfItemsInCart, gc);
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		totalPrice = new JLabel("The total cost is: " + cart.totalCost() + " kr");
		add(totalPrice, gc);
		gc.weighty = 0.2;
		gc.weightx = 0.2;
		gc.gridy = 4;
		latestPurchase = new JLabel("Nothing in cart, let's change that", SwingConstants.CENTER);
		add(latestPurchase, gc);
	}

	/**
	 * Creates the buttons and also adds the functionality for events to occur when
	 * a button is pressed
	 */
	private void buttons() {
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.insets = new Insets(5, 5, 5, 5); // Decides height and space for the buttons
		gc.gridwidth = 1;
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		gc.gridx = 0;
		gc.gridy = 0;

		// When the button in pressed, a description is sent of the button that was
		// pressed
		// to the event handler
		JButton buyBicycleButton = new JButton("Buy bicycle"); // Creates a new button with the label buy bicycle
		buyBicycleButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // So that the cursor indicates for the user that
																	// it's click-able,
																	// changes default
		buyBicycleButton.addActionListener(new ActionListener() { // An anonymous class
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonWasPressed("Bicycle");
			}
		});
		;
		add(buyBicycleButton, gc); // Adds the button to the layout of the interface

		gc.gridx++; // Moves 1 position on the x-axis
		JButton buyFlashlightButton = new JButton("Buy flashlight");
		buyFlashlightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // So that the cursor indicates it's click-able,
																		// changes default
		buyFlashlightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonWasPressed("Flashlight");
			}
		});
		add(buyFlashlightButton, gc);

		gc.gridx++;
		JButton buyBagButton = new JButton("Buy bag");
		buyBagButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // So that the cursor indicates it's click-able, changes
																// default
		buyBagButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonWasPressed("Bag");
			}
		});
		add(buyBagButton, gc);

		Color clr2 = new Color(0.95f, 0.5f, 0.56f); /*
													 * This is for changing color, the default colors were too bright so
													 * created one that fit better. This is just to indicate "danger"
													 * for the user so that it doesn't click it by accident
													 **/
		gc.gridy++;
		JButton clearButton = new JButton("Clear cart");
		clearButton.setBackground(clr2);
		clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // So that the cursor indicates it's click-able, changes
																// default
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonWasPressed("Clear cart");
			}
		});
		;
		add(clearButton, gc);
	}

	/**
	 * A method to handle an action created by the buttons. A switch is used to
	 * handle all the different buttons. Makes the case of adding new buttons
	 * easier. This was the easiest way of handling the scenario of wanting to
	 * expand the application.
	 */
	private void buttonWasPressed(String name) {
		switch (name) { // A switch case to handle the different names of the buttons
		case "Bag":
			cart.addItem(name);
			textArea.append("[Bag] ");
			break;
		case "Bicycle":
			cart.addItem(name);
			textArea.append("[Bicycle] ");
			break;
		case "Flashlight":
			cart.addItem(name);
			textArea.append("[Flashlight] ");
			break;
		case "Clear cart":
			cart.clearCart();
			textArea.setText(""); // Makes the textArea look empty
			latestPurchase.setText("Cart was cleared");
			break;
		}

		if (!name.equals("Clear cart")) { // If the button that was pressed is not the "Clear cart"-button an additional
											// space is added and update the latestPurchase
			textArea.append(" ");
			updateLatestPurchase();
		}
		updateLabels();
	}

	/**
	 * Updates the labels that are not dependent on Item
	 */
	private void updateLabels() {
		totalPrice.setText("The total cost is: " + cart.totalCost() + " kr");
		numberOfItemsInCart.setText("The number of items in cart is: " + cart.itemsInCart());
	}

	// Updates the the JLabel with the latest purchase
	private void updateLatestPurchase() {
		latestPurchase.setText(
				cart.latestItemName() + " with cost of " + cart.latestItemPrice() + " kr is being added to the cart");
	}
}
