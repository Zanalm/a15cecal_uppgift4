package a15cecal_uppgift4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private Cart cart = new Cart();
	private JTextArea textArea;
	private JLabel ItemsInCart;
	private JLabel totalPrice;
	private JLabel latestPurchase;

	// Default constructor for the class GUI
	public GUI(String title) {
		super(title); // This is for the title at the top of the window to be shown correctly
		appSettings(); // Applies all settings for the window defined further down
		buttons(); // For creating all the buttons needed
		labels(); // For creating the labels
		setTextArea(); // Creates the textArea for the window
	}

	// Firstly we decide how the labels will be positioned. This updates the labels
	private void labels() {
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = 0;
		gc.gridy = 1; // Decides where the label will show up on y-axis
		gc.weighty = 0.1;
		gc.gridwidth = 4; /* helps setting out where labels and such will be positioned in grid */
		gc.insets = new Insets(90, 15, 0, 15); // Made this small so that it only fills up and extends (by scrolling) if
												// the user is adding many things in the basket. No need for it to be
												// big from the start
		ItemsInCart = new JLabel("The number of items in cart is:  0");
		add(ItemsInCart, gc);
		gc.gridy = 3; // positions the label for number of items correctly
		totalPrice = new JLabel("The total cost is: " + cart.totalCost() + " kr");
		add(totalPrice, gc);
		gc.weighty = 0.2;
		gc.weightx = 0.2;
		gc.gridy = 4;
		latestPurchase = new JLabel("Nothing in cart, let's change that", SwingConstants.CENTER);
		add(latestPurchase, gc);
	}

	/**
	 * Then we create the buttons in the interface Creates all the buttons and this
	 * creates what will happen when the user clicks on a button
	 */
	private void buttons() {
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = new Insets(5, 5, 5, 5); // Decides height and space for the buttons
		gc.gridwidth = 1;

		// When the button in pressed, a description is sent of the button that was
		// pressed to the event handler
		JButton btnBuyBicycle = new JButton("Buy bicycle"); // Creates a new button with the label buy bicycle
		btnBuyBicycle.setCursor(new Cursor(Cursor.HAND_CURSOR)); // So that the cursor indicates for the user that the
																	// button is click-able,
																	// changes default
		btnBuyBicycle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPressed("Bicycle");
			}
		});
		;
		add(btnBuyBicycle, gc); // Adds the button for the interface

		gc.gridx++; // Moves 1 position to the horizontal line so that they'll align correctly next
					// to each other
		JButton btnBuyFlashlight = new JButton("Buy flashlight");
		btnBuyFlashlight.setCursor(new Cursor(Cursor.HAND_CURSOR)); // So that the cursor indicates it's click-able,
																	// changes default
		btnBuyFlashlight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPressed("Flashlight");
			}
		});
		add(btnBuyFlashlight, gc);

		gc.gridx++;
		JButton btnBuyBag = new JButton("Buy bag");
		btnBuyBag.setCursor(new Cursor(Cursor.HAND_CURSOR)); // So that the cursor indicates it's click-able, changes
																// default
		btnBuyBag.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPressed("Bag");
			}
		});
		add(btnBuyBag, gc);

		Color clr2 = new Color(0.95f, 0.5f, 0.56f); /*
													 * This is for changing color, the default colors were too bright so
													 * created one that fit better. This is just to indicate "danger"
													 * for the user so that it doesn't click it by accident
													 **/
		gc.gridy++;
		JButton btnClear = new JButton("Clear cart");
		try {
			Image img = ImageIO.read(getClass().getResource("images/ex.png")); // This adds an image I made to the
																				// button "clear cart". A bit more of an
																				// UX-approach to the design, even
																				// thought a lot is missing in that
																				// perspective
			btnClear.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		btnClear.setBackground(clr2);
		btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR)); // So that the cursor indicates it's click-able, changes
															// default
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPressed("Clear cart");
			}
		});
		;
		add(btnClear, gc);
	}

	/**
	 * This sets the size, visibility etc. this is declared in the beginning of this
	 * file
	 */
	private void appSettings() {
		setLayout(new GridBagLayout()); // Sets the layout to GridBagLayout
		this.setSize(350, 450); // Sets the size of the window, decided to make it look kind of like an
								// calculator
		this.setLocationRelativeTo(null); // This will make the dialog-window centered on the users screen. I find that
											// this is the easiest way to do this
		this.setVisible(true);
		this.setResizable(true); // This lets the user re-size the window if wanted
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This makes it possible to close the project from running
																// completely (as in not in console) when X is clicked
																// in the window
	}

	// This is to set the text areas for the application
	private void setTextArea() {
		Color clr1 = new Color(0.85f, 0.90f, 0.95f);
		/*
		 * This is for changing color, the default colors were too intense so created
		 * one that fit better. Found that this was the easiest way and looked better
		 * than using the brighter() method
		 */

		/*
		 * This is very much like the styling with CSS (using different terms of
		 * course), uses the same logic
		 */
		GridBagConstraints bagConstraints = new GridBagConstraints(); // This is for a kind of grid that handles where
																		// things in the
		// application-window will appear
		bagConstraints.fill = GridBagConstraints.BOTH; // This forces the area to take up the available space in the
														// window. Without
		// it it'll be very tiny
		bagConstraints.weighty = 1;
		bagConstraints.gridwidth = 4; // How many cells this element should span, makes the are take up 4 cells and
		// stretching to a good width
		bagConstraints.gridx = 0; // This declares where on the X-axis it will "begin", where it will show.
		bagConstraints.gridy = 2; // Same for this one, except on the Y.
		bagConstraints.insets = new Insets(0, 15, 0, 150); // This is for the borders.
		textArea = new JTextArea(); // Creates a new JTextArea, from the java.awt-library
		textArea.setEditable(false); // Makes it so that the user can't edit the text in the textArea, we wouldn't
										// want that, they are supposed to use the buttons for editing the cart
		textArea.setLineWrap(true); // Makes the output-text in the TextArea jump to a new line when reaching the
									// end of the area
		textArea.setWrapStyleWord(true); // This makes so that the word in above scenario doesn't get "chopped-off" in
											// the middle, the whole word jumps down a line
		textArea.setBackground(clr1); // Implements the created color above
		JScrollPane jScrollPane = new JScrollPane(textArea); // JScrollPane makes it so that the user can scroll in the
																// textArea
		add(jScrollPane, bagConstraints);
	}

	// This handles the case when an button is pressed, the set actions for said
	// button
	private void buttonPressed(String ItemName) {
		switch (ItemName) {
		case "Bag":
			cart.addItem(ItemName);
			textArea.append("[Bag] "); /* This is the text shown in the cart */
			break;
		case "Bicycle":
			cart.addItem(ItemName);
			textArea.append("[Bicycle] ");
			break;
		case "Flashlight":
			cart.addItem(ItemName);
			textArea.append("[Flashlight] ");
			break;
		case "Clear cart":
			cart.clearCart();
			textArea.setText(""); // Makes the textArea look empty
			latestPurchase.setText("Cart was cleared");
			break;
		}

		if (!ItemName.equals("Clear cart")) { // If the button that was pressed is not the "Clear cart"-button an
												// additional
												// space is added and this updates the cart to the latest purchase
			LatestPurchase();
		}
		updateLabels();
	}

	private void updateLabels() {
		totalPrice.setText("Total cost: " + cart.totalCost() + " kr");
		ItemsInCart.setText("The number of items in cart is: " + cart.itemsInCart());
	}

	// Updates the the JLabel with the latest purchase
	private void LatestPurchase() {
		latestPurchase.setText(
				cart.lastAddedItemName() + " with cost of " + cart.addedItemPrice() + " kr is being added to the cart");
	}
}
