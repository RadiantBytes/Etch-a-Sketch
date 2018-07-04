/**
 * CS 120 Final
 * This program creates an Etch-a-Sketch program, in which the user can draw in
 *  using multiple colors.
 * 
 * Last Modified: December 9, 2016
 * @author Thomas "RadiantBytes" Lynaugh
 *
 */
import java.awt.Color;
import java.util.Random;
import java.awt.event.KeyEvent;

public class Driver {
	// Declares variables and array
	Rectangle[][] gridArr;
	Oval marker;

	int markerX = 2;
	int markerY = 2;
	int gridRow = 0;
	int gridColumn = 0;

	int r = 0;
	int g = 0;
	int b = 0;

	Color drawColor = new Color(r, g, b);
	boolean penDown = true;

	private Window window;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Driver sketch = new Driver();
		// No other Java code should be added to this method
	}

	public Driver() {

		// Sets up the window
		window = new Window();

		window.setTitle("Etch-a-Sketch");
		window.setLocation(20, 20);
		window.setSize(600, 600);
		window.setBackground(Color.PINK);

		// Popup window with instructions
		InstructionsWindow pw = new InstructionsWindow(window);

		/*
		 * Attach the keyboard listener
		 */
		KeyboardListener kl = new KeyboardListener(this, window);

		// Draws the Etch-a-Sketch grid
		gridArr = new Rectangle[30][30];

		for (int i = 0; i < gridArr.length; i++) {
			Line vert;
			vert = new Line(i * 20, 0, i * 20, 600, 2);
			vert.setBackground(Color.black);
			window.add(vert);

			for (int j = 0; j < gridArr.length; j++) {
				Rectangle rec;
				rec = new Rectangle(i * 20, j * 20, 20, 20);
				rec.setBackground(Color.white);
				window.add(rec);

				gridArr[i][j] = rec;

				Line horiz;
				horiz = new Line(0, j * 20, 600, j * 20, 2);
				horiz.setBackground(Color.black);
				window.add(horiz);
			}

		}
		// Adds drawing marker
		marker = new Oval(markerX, markerY, 15, 15);
		marker.setBackground(drawColor);
		window.add(marker);

		// Always repaint when done drawing (keep this as your last line in the
		// constructor)
		window.repaint();
	}

	public void handleKeyboardEvent(int key) {

		// Changes drawing color based upon user's input
		drawColor = new Color(r, g, b);

		// Moves cursor and draws in grid, if the pen is down
		if (KeyEvent.VK_UP == key) {
			if (markerY >= 22) {
				markerY -= 20;
				if (penDown == true) {
					gridArr[gridColumn][gridRow].setBackground(drawColor);
				}
				gridRow -= 1;
			}
		} else if (KeyEvent.VK_DOWN == key) {
			if (markerY < 580) {
				markerY += 20;
				if (penDown == true) {
					gridArr[gridColumn][gridRow].setBackground(drawColor);
				}
				gridRow += 1;
			}
		} else if (KeyEvent.VK_LEFT == key) {
			if (markerX > 2) {
				markerX -= 20;
				if (penDown == true) {
					gridArr[gridColumn][gridRow].setBackground(drawColor);
				}
				gridColumn -= 1;
			}
		} else if (KeyEvent.VK_RIGHT == key) {
			if (markerX < 580) {
				markerX += 20;
				if (penDown == true) {
					gridArr[gridColumn][gridRow].setBackground(drawColor);
				}
				gridColumn += 1;
			}
		}

		// Changes current drawing color
		else if (KeyEvent.VK_B == key) {
			if (b < 251) {
				b += 5;
			}
			if (b >= 251) {
				b = 255;
			}
			drawColor = new Color(r, g, b);
			marker.setBackground(drawColor);
		} else if (KeyEvent.VK_C == key) {
			for (int i = 0; i < gridArr.length; i++) {
				for (int j = 0; j < gridArr.length; j++) {
					gridArr[i][j].setBackground(Color.white);
				}
			}
		} else if (KeyEvent.VK_G == key) {
			if (g < 251) {
				g += 5;
			}
			if (g >= 251) {
				g = 255;
			}

			drawColor = new Color(r, g, b);
			marker.setBackground(drawColor);
		} else if (KeyEvent.VK_K == key) {
			r = 0;
			g = 0;
			b = 0;
			drawColor = new Color(r, g, b);
			marker.setBackground(drawColor);
		} else if (KeyEvent.VK_R == key) {
			if (r < 251) {
				r += 5;
			}
			if (r >= 251) {
				r = 255;
			}
			drawColor = new Color(r, g, b);
			marker.setBackground(drawColor);
		} else if (KeyEvent.VK_X == key) {
			drawColor = getRandomColor();
			r = drawColor.getRed();
			g = drawColor.getGreen();
			b = drawColor.getBlue();
			marker.setBackground(drawColor);
		}
		// Picks pen up or sets pen down
		else if (KeyEvent.VK_SPACE == key) {
			penDown = !penDown;
		}

		// Move marker based upon user input
		marker.setLocation(markerX, markerY);

		// Always repaint when done drawing (keep as last line in this method)
		window.repaint();
	}

	private Color getRandomColor() {
		Random rand = new Random();
		return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
	}
}
