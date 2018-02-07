package a15cecal_uppgift4;

import javax.swing.*;

public class Uppgift4 {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				@SuppressWarnings("unused")
				GUI applicationWindow = new GUI("The tiny webshop"); // The name that later on will be shown as the
																		// application-window-name
			}
		});
	}

}
