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
		super(title); // Pushes the title of the window to the superclass, this is sets the title of
						// the window
		appSettings(); // Applies all settings of the window
		buttons(); // Creates all the buttons
		labels(); // Creates all the labels
		setTextArea(); // Creates the textArea
	}

	/**
	 * A method to set the size, position, layout, visibility and how to quit the
	 * application. These settings where broken out of the Main-class to minimize
	 * clutter in the code
	 */
	private void appSettings() {
		setLayout(new GridBagLayout()); // Sets the layout to GridBagLayout
		this.setSize(640, 480); // Sets the size of the window
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
		GridBagConstraints gc = new GridBagConstraints(); // A GridBagConstraints to specify where the elements should
															// appear
		gc.fill = GridBagConstraints.BOTH; // Forces the element to fill all possible space that it can.
		gc.weightx = 1; // Specifies the weight of the element. This makes the element fill a greater
						// area
		gc.weighty = 1; // Same as above, but only on the y-axis
		gc.gridwidth = 4; // How many cells this element should span
		gc.gridx = 0; // Position of the element on the x-axis
		gc.gridy = 2; // Position of the element on the y-axis
		gc.insets = new Insets(0, 15, 0, 15); // Insets are used to create som
		textArea = new JTextArea(); // Declares the variable as a new JTextArea
		textArea.setEditable(false); // Makes the textArea not editable
		textArea.setLineWrap(true); // Turns on LineWrap
		textArea.setWrapStyleWord(true); // Forces the wrap to wrap on word, instead of wrapping per character

		JScrollPane jScrollPane = new JScrollPane(textArea); // Creates a JScrollPane with the textArea, resulting in a
																// scrollable textArea

		add(jScrollPane, gc); // Adds the JScrollPane to the GridBagLayout with the information from the
								// GridBagConstraint
	}

	/**
	 * Updates the important labels that are not directly dependent on Item
	 */
	private void labels() {
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 0.1;
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
		gc.insets = new Insets(5, 5, 5, 5);
		gc.gridwidth = 1;
		gc.weightx = 0.1;
		gc.weighty = 0.1;
		gc.gridx = 0;
		gc.gridy = 0;

		// When the button in pressed, a description is sent of the button that was pressed
		// to the handler
		JButton buyBicycleButton = new JButton("Buy bicycle"); // Creates a new button with the label buy bicycle
		buyBicycleButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // So that the cursor indicates it's click-able, changes default
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
		buyFlashlightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // So that the cursor indicates it's click-able, changes default
		buyFlashlightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonWasPressed("Flashlight");
			}
		});
		add(buyFlashlightButton, gc);

		gc.gridx++;
		JButton buyBagButton = new JButton("Buy bag");
		buyBagButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // So that the cursor indicates it's click-able, changes default
		buyBagButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonWasPressed("Bag");
			}
		});
		add(buyBagButton, gc);

		Color clr1 = new Color(0.95f, 0.5f, 0.56f); // This is for changing color, the default colors were too bright so created one that fit better
		gc.gridy++;
		JButton clearButton = new JButton("Clear cart");
		clearButton.setBackground(clr1);
		clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // So that the cursor indicates it's click-able, changes default
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
	 * A method to handle an action created by the buttons. It uses a switch case to
	 * handle the different buttons This is preferable due to expandability, to add
	 * a new Item, simply create a new Item, add a button and add a entry to this
	 * switch case and the cart switch case. This was the simplest way of handling
	 * expanding the application.
	 *
	 * @param name
	 *            The name of the button that was pressed
	 */
	private void buttonWasPressed(String name) {
		switch (name) { // A switch case to handle the different names of the buttons
		case "Bag":
			cart.addItem(name);
			textArea.append("[Bag]");
			break;
		case "Bicycle":
			cart.addItem(name);
			textArea.append("[Bicycle]");
			break;
		case "Flashlight":
			cart.addItem(name);
			textArea.append("[Flashlight]");
			break;
		case "Clear cart":
			cart.clearCart();
			textArea.setText("");
			latestPurchase.setText("Cart was cleared");
			break;
		}

		if (!name.equals("Clear cart")) { // If the button that was pressed is not the "Clear cart"-button, append a
											// space and update the latestPurchase
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

	/**
	 * Updates the the JLabel with the latest purchase.
	 */
	private void updateLatestPurchase() {
		latestPurchase.setText(
				cart.latestItemName() + " with cost of " + cart.latestItemPrice() + " kr is being added to the cart");
	}
}
