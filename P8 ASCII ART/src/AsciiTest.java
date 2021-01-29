/**
 * This test check the function of ASCII ART. First test creates a stack, pushes
 * a DrawingChange onto the stack, and then use peek to verify that the correct
 * item is at the top of the stack. Second test method run the stack to test the
 * specific case of the three Characters changes at the certain place. It checks
 * the redo and undo functions at specific cases. The test also catch the
 * IllegalArgumentException.
 */
public class AsciiTest {

	/**
	 * This test creates a stack, pushes a DrawingChange onto the stack, and then
	 * use peek to verify that the correct item is at the top of the stack.
	 */
	public static boolean testStackPushPeek() {
		DrawingStack<DrawingChange> stack = new DrawingStack<DrawingChange>();
		DrawingChange change = new DrawingChange(1, 2, 'X', 'Y');
		stack.push(change);
		if (change == stack.peek())
			return true;
		return false;
	}

	/**
	 * This test method run the stack to test the specific case of the three
	 * Characters changes at the certain place. It checks the redo and undo
	 * functions at specific cases. The test also catch the
	 * IllegalArgumentException.
	 * 
	 * @return false if any of its component tests fail true if they all succeed.
	 */
	public static boolean runStackTestSuite() {
		Canvas canvas = new Canvas(4, 4);
		try {
			canvas.draw(0, 0, 'X'); // Current character at (0, 0): X
			canvas.draw(0, 0, 'Y'); // Current character at (0, 0): Y
			canvas.draw(0, 0, 'Z'); // Current character at (0, 0): Z
			canvas.undo(); // Undo should succeed, current character at (0, 0): Y
			canvas.undo(); // Undo should succeed, current character at (0, 0): X
			if (canvas.getDrawingArray()[0][0] != 'X')
				return false;
			canvas.redo(); // Redo should succeed, current character at (0, 0): Y
			if (canvas.getDrawingArray()[0][0] != 'Y')
				return false;
			canvas.redo(); // Redo should succeed, current character at (0, 0): Z
			if (canvas.getDrawingArray()[0][0] != 'Z')
				return false;
			canvas.redo(); // Redo should fail, current character at (0, 0): Z
			if (canvas.getDrawingArray()[0][0] != 'Z')
				return false;
			canvas.undo(); // Undo should succeed, current character at (0, 0): Y
			canvas.undo(); // Undo should succeed, current character at (0, 0): X
			if (canvas.getDrawingArray()[0][0] != 'X')
				return false;
			canvas.draw(0, 0, 'T'); // redoStack is cleared, current character at (0, 0): T
			canvas.redo(); // Redo should fail, current character at (0, 0): T
			if (canvas.getDrawingArray()[0][0] != 'T')
				return false;
			canvas.undo(); // Undo should succeed, current character at (0, 0): X
			if (canvas.getDrawingArray()[0][0] != 'X')
				return false;
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	/**
	 * Testing main. Runs each test and prints which (if any) failed. If no problem
	 * occurs, print a single line showing "All tests passed!".
	 */
	public static void main(String[] args) {
		int fails = 0;
		if (!testStackPushPeek()) {
			System.out.println("testStackPushPeek failed");
			fails++;
		}
		if (!runStackTestSuite()) {
			System.out.println("runStackTestSuite failed");
			fails++;
		}
		// If no problem occurs, print a single line showing "All tests passed!".
		if (fails == 0)
			System.out.println("All tests passed!");
	}
}
