package a15cecal_uppgift4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private ShoppingCart cart = new ShoppingCart();
	private JLabel latestPurchase;
	// private JTextArea textWindow;
	private JTextPane textPane;
	private JPanel panel;
	private JLabel totalCost;
	private JLabel ItemsInCart;

	public GUI(String title) {
		super(title); // This is for the title at the top of the window to be
						// shown correctly
		applicationSettings(); // Applies all settings for the window defined
								// further
		// down
		buttons(); // For creating all the buttons needed
		TextInApp(); // For creating the labels
		setTextArea(); // Creates the textArea for the window
		jFramePanel();
	}

	private void updateTextInApp() {
		totalCost.setText("Total cost: " + cart.totalCost() + " kr");
		ItemsInCart.setText("The number of items in cart is: " + cart.itemsInShoppingCart());
	}

	private void LastBought() {
		latestPurchase.setText(
				cart.lastAddedItemName() + " with cost of " + cart.addedItemPrice() + " kr is being added to the cart");
	}
	private void jFramePanel() {
		GridBagConstraints ConstraintPanel = new GridBagConstraints();
		ConstraintPanel.fill = GridBagConstraints.HORIZONTAL;
		ConstraintPanel.gridx = 1;
		ConstraintPanel.gridy = 1;
		ConstraintPanel.gridwidth = 1;
		Color clr1 = new Color(0.85f, 0.90f, 0.95f);
		panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setLayout(new FlowLayout());
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false); // Makes it so that the user can't edit
		// the text in the textArea, we wouldn't
		// want that, they are supposed to use
		// the buttons for editing the cart
		textPane.setBackground(clr1); // Implements the created color above
		JScrollPane jScrollPane = new JScrollPane(textPane); // JScrollPane
																// makes it so
																// that the user
																// can scroll in
																// the
																// text
		panel.add(textPane);
	}
	// Firstly we set out the layout for how the labels for the cart will be
	// positioned. This updates the labels
	private void TextInApp() {
		GridBagConstraints c = new GridBagConstraints(); // "The
															// GridBagConstraints
															// class specifies
															// constraints for
															// components that
															// are laid out
															// using the
															// GridBagLayout
															// class"
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 0.1;
		c.gridwidth = 4; /*
							 * helps setting out where labels and such will be
							 * positioned in grid
							 */
		c.insets = new Insets(90, 15, 0, 15);
		ItemsInCart = new JLabel("The number of items in cart is:  0");
		add(ItemsInCart, c);
		c.gridy = 3; // positions the label for number of items correctly
		totalCost = new JLabel("The total cost is: " + cart.totalCost() + " kr");
		add(totalCost, c);
		c.weightx = 0.2;
		c.gridy = 4;
		latestPurchase = new JLabel("Nothing in cart, let's change that!", SwingConstants.CENTER); // The
																									// SwingConstants
																									// is
																									// used
																									// for
																									// positioning
																									// the
																									// label
																									// in
																									// the
																									// center
		add(latestPurchase, c);
	}

	/**
	 * Then we create the buttons in the interface Creates all the buttons and
	 * this creates what will happen when the user clicks on a button
	 */
	private void buttons() {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.insets = new Insets(15, 15, 15, 15); // For height and space for the
												// buttons

		JButton btnBuyBicycle = new JButton(); // Creates a new button
		// For image
		try {
			Image img1 = ImageIO.read(getClass().getResource("images/bicycle.png")); // reads
																						// in
																						// the
																						// image
			btnBuyBicycle.setIcon(new ImageIcon(img1)); // The created button
														// uses an icon to
														// symbolize it's
														// meaning
														// instead of text
		} catch (Exception ex) {
		}
		// end for image
		btnBuyBicycle.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Changed this
																	// so that
																	// the
																	// cursor
																	// indicates
																	// for the
																	// user that
																	// the
																	// button is
																	// click-able,
																	// changes
																	// default
		btnBuyBicycle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPressed("Bicycle");
			}
		});
		;
		add(btnBuyBicycle, c); // Adds the button for the interface
		c.gridx++; // Moves one position to the horizontal line so that they'll
					// align correctly
					// next
					// to each other
		JButton btnBuyFlashlight = new JButton();
		// For image
		try {
			Image img2 = ImageIO.read(getClass().getResource("images/flashlight.png")); // This
																						// reads
																						// in
																						// an
																						// image
																						// I
																						// made
																						// for
																						// the
																						// button
			// perspective
			btnBuyFlashlight.setIcon(new ImageIcon(img2)); // Makes the icon
															// appear for the
															// button
		} catch (Exception ex) {
		}
		// end for image
		btnBuyFlashlight.setCursor(new Cursor(Cursor.HAND_CURSOR)); // So that
																	// the
																	// cursor
																	// indicates
																	// it's
																	// click-able,
																	// changes
																	// default
		btnBuyFlashlight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPressed("Flashlight");
			}
		});
		add(btnBuyFlashlight, c);
		c.gridx++;
		JButton btnBuyBag = new JButton();
		// For image
		try {
			Image img3 = ImageIO.read(getClass().getResource("images/bag.png")); // This
																					// adds
																					// an
																					// image
																					// I
																					// made
																					// to
																					// the
			// button "clear cart". A bit more of an
			// UX-approach to the design, even
			// thought a lot is missing in that
			// perspective
			btnBuyBag.setIcon(new ImageIcon(img3));
		} catch (Exception ex) {
		}
		// end for image
		btnBuyBag.setCursor(new Cursor(Cursor.HAND_CURSOR)); // So that the
																// cursor
																// indicates
																// it's
																// click-able,
																// changes
																// default
		btnBuyBag.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPressed("Bag");
			}
		});
		add(btnBuyBag, c);

		Color clr2 = new Color(0.95f, 0.5f,
				0.56f); /*
						 * This is for changing color, the default colors were
						 * too intense so created one that fit better. This is
						 * just to indicate "danger" for the user so that it
						 * doesn't click it by accident
						 **/
		c.gridy++;
		JButton btnClear = new JButton("Clear cart");
		// For image
		try {
			Image img4 = ImageIO.read(getClass().getResource("images/ex.png")); // This
																				// adds
																				// an
																				// image
																				// I
																				// made
																				// to
																				// the
																				// button
																				// "clear
																				// cart".
																				// A
																				// bit
																				// more
																				// of
																				// an
																				// UX-approach
																				// to
																				// the
																				// design,
																				// even
																				// thought
																				// a
																				// lot
																				// is
																				// missing
																				// in
																				// that
																				// perspective
			btnClear.setIcon(new ImageIcon(img4));
		} catch (Exception ex) {
		}
		// end for image
		btnClear.setBackground(clr2);
		btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR)); // So that the
															// cursor indicates
															// it's click-able,
															// changes
															// default
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPressed("Clear cart");
			}
		});
		;
		add(btnClear, c);
	}

	/**
	 * This sets the size, visibility etc. this is declared in the beginning of
	 * this file
	 */
	private void applicationSettings() {
		setLayout(new GridBagLayout()); // Sets the layout to GridBagLayout
		this.setSize(400, 450); // Sets the size of the window, decided to make
								// it kind of like calculator-size
		this.setLocationRelativeTo(null); // This will make the dialog-window
											// centered on the users screen. I
											// find that
											// this is the easiest way to do
											// this
		this.setVisible(true);
		this.setResizable(true); // This lets the user re-size the window if
									// wanted
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This line makes
																// it possible
																// to close the
																// project from
																// running
																// completely
																// (as in not in
																// console) when
																// X is clicked
																// in the window
	}

	// This is to set the text areas for the application
	private void setTextArea() {
		
		/*
		 * This is for changing color, the default colors were too intense so
		 * created one that fit better. Found that this was the easiest way and
		 * looked better than using the brighter() method
		 */

		/*
		 * This is very much like the styling with CSS (using different terms of
		 * course), uses the same logic
		 */
		GridBagConstraints c = new GridBagConstraints(); // This is
															// for a
															// kind
															// of
															// grid
															// that
															// handles
															// where
															// things
															// in
															// the
															// application-window
															// will
															// appear
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 4; // How many cells this element should
							// span, makes the are take up 4 cells
							// and
							// stretching to a good width
		c.gridx = 0; // This declares where on the X-axis it will
						// "begin", where it will show.
		c.gridy = 2; // Same for this one, except on the Y.
		c.insets = new Insets(0, 15, 0, 150); // This is for the
												// borders.

		// textPan.setPreferredSize(new Dimension(250, 145)); // Fix the size
		// for the textPane
		// textPan.setMinimumSize(new Dimension(10, 10));
		// StyledDocument doc = textPane.getStyledDocument();
		// textWindow = new JTextArea();

		// Creates a new JTextArea, from the java.awt-library
		
		// textWindow.setLineWrap(true); // Makes the output-text in the
		// TextArea
		// jump to a new line when reaching the
		// end of the area
		// textWindow.setWrapStyleWord(true); // This makes so that the word in
		// above scenario doesn't get
		// "chopped-off" in
		// the middle, the whole word jumps
		// down a line
		
	
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
