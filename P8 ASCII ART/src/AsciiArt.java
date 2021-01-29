import java.util.Scanner;

/**
 * This class provides the interface for user to create a canvas and make
 * different operations to the canvas, for example like create a canvas, draw
 * something on the canvas, undo and redo drawing etc.
 */
public class AsciiArt {

	public static Scanner scnr = new Scanner(System.in); // Scanner to get user input
	public static Canvas canvas; // an interactive canvas

	/**
	 * The printInterface class is printing out the display menu for users. The menu
	 * contains instructions for user to make changes on the canvas.
	 */
	public static void printInterface() {
		System.out.print("======== MENU ========\n" + 
	            "[1] Create a new canvas\n" + 
				"[2] Draw a character\n" + 
				"[3] Undo drawing\n" + 
				"[4] Redo drawing\n" + 
				"[5] Show current canvas\n" + 
				"[6] Show drawing history\n" + 
				"[7] Exit\n" + 
				"> ");
	}

	/**
	 * This method input users command and process the command to modify the canvas.
	 * Base on the command, the application is able to create a canvas, draw a
	 * character, undo or redo the drawing, show the canvas and show the drawing
	 * history.
	 * 
	 * @param command the user command
	 * @return true if the user does not command to quit the application false if
	 *         the user input 7 (exit command)
	 */
	public static boolean processCommand(String command) {
		switch (command) {
		case "1": // Create a canvas
			int width = 0;
			int height = 0;
			System.out.print("Width > ");
			try { // catch the NumberFormatException if input is not a integer number
				width = Integer.parseInt(scnr.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Please enter a integer number!");
				break;
			}
			System.out.print("Height > ");
			try { // catch the NumberFormatException if input is not a integer number
				height = Integer.parseInt(scnr.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Please enter a integer number!");
				break;
			}
			if (width <= 0 || height <= 0) {
				System.out.println("Width or height of the canvas cannot be 0 or less!");
				break;
			}
			canvas = new Canvas(width, height);
			break;
		case "2": // Draw a character
			int row = 0;
			int col = 0;
			char c = 'a';
			if (canvas == null) { // ensure that the canvas is created
				System.out.println("Please create a canvas first!");
				break;
			}
			System.out.print("Row > ");
			try { // catch the NumberFormatException if input is not a integer number
				row = Integer.parseInt(scnr.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Please enter a integer number!");
				break;
			}
			System.out.print("Col > ");
			try { // catch the NumberFormatException if input is not a integer number
				col = Integer.parseInt(scnr.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Please enter a integer number!");
				break;
			}
			System.out.print("Character > ");
			String string = scnr.nextLine();
			if (string.length() != 1) { // if input is not a single character, print error message
				System.out.println("Please enter a single character");
				break;
			}
			c = string.charAt(0);
			try { // catch the exception of the command that out of range
				canvas.draw(row, col, c);
			} catch (IllegalArgumentException e) {
				System.out.println("This point is outside of the canvas area!");
			}
			break;
		case "3": // Undo drawing
			if (canvas == null) { // ensure that the canvas is created
				System.out.println("Please create a canvas first!");
				break;
			}
			if (canvas.undo() == false) // if fail to undo, print error message
				System.out.println("Undo failed!");
			break;
		case "4": // Redo drawing
			if (canvas == null) { // ensure that the canvas is created
				System.out.println("Please create a canvas first!");
				break;
			}
			if (canvas.redo() == false) // if fail to redo, print error message
				System.out.println("Redo failed!");
			break;
		case "5": // Show current canvas
			if (canvas == null) { // ensure that the canvas is created
				System.out.println("Please create a canvas first!");
				break;
			}
			System.out.println(canvas.toString());
			break;
		case "6": // Show drawing history
			if (canvas == null) { // ensure that the canvas is created
				System.out.println("Please create a canvas first!");
				break;
			}
			canvas.printHistory();
			break;
		case "7": // Quit
			System.out.println("Bye!");
			return false;

		default: // if input satisfy none of the above, print error message
			System.out.println("Invalid command!");
			break;
		}
		return true;
	}

	/**
	 * The main method of the Ascii Art class that calls other driver method to
	 * implement the application. The method begins with a driver loop.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		while (true) { // a while driver loop
			printInterface(); // present the menu by calling the displacement methdoth
			String command = scnr.nextLine();
			if (!processCommand(command))
				break;
		}
		scnr.close();
	}
}
