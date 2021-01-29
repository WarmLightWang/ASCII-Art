/**
 * This class records the details of a single change made to the canvas This
 * type of objects are used as data of the nodes in the DrawingStack
 */
public class DrawingChange {

	public final int x; // x coordinate for a change
	public final int y; // y coordinate for a change
	public final char prevChar; // previous character in the (x,y)
	public final char newChar; // new character in the (x,y)

	/**
	 * constructor of the DrawingChange
	 * 
	 * @param x:        x coordinate for a change
	 * @param y:        y coordinate for a change
	 * @param prevChar: previous character in the (x,y)
	 * @param newChar:  new character in the (x,y)
	 */
	public DrawingChange(int x, int y, char prevChar, char newChar) {
		this.x = x;
		this.y = y;
		this.prevChar = prevChar;
		this.newChar = newChar;
	}
}
