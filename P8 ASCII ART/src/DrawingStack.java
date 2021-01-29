import java.util.Iterator;

/**
 * This class use the Node class to implement a stack using a
 * chain-of-linked-nodes approach This class implements the
 * StackADT<DrawingChange> interface
 */
public class DrawingStack<T> implements StackADT<DrawingChange> {

	private Node<DrawingChange> top; // a stack using a chain-of-linked-nodes

	/**
	 * Add an element to this stack
	 * 
	 * @param element an element to be added
	 * @throws IllegalArgumentException if the input element is null
	 */
	@Override
	public void push(DrawingChange element) throws IllegalArgumentException {
		if (element == null)
			throw new IllegalArgumentException("You cannot push a null into the stack");
		top = new Node<DrawingChange>(element, top); // construct a node with the given element and the
														// pointer, then pointing the top to this node
	}

	/**
	 * Remove the element on the stack top and return it
	 * 
	 * @return the element removed from the stack top
	 */
	@Override
	public DrawingChange pop() {
		if (!isEmpty()) { // ensure that the stack is not empty
			DrawingChange res = top.getData();
			top = top.getNext();
			return res;
		}
		return null;
	}

	/**
	 * Get the element on the stack top
	 * 
	 * @return the element on the stack top
	 */
	@Override
	public DrawingChange peek() {
		if (!isEmpty()) // ensure that the stack is not empty
			return top.getData();
		return null;
	}

	/**
	 * Returns true if this stack contains no elements.
	 * 
	 * @return true if this stack contains no elements, otherwise false
	 */
	@Override
	public boolean isEmpty() {
		if (top == null) // if the top is empty, this stack must be empty
			return true;
		return false;
	}

	/**
	 * Get the number of elements in the stack
	 * 
	 * @return the size of the stack
	 */
	@Override
	public int size() {
		int count = 0;
		while (top != null) { // iterate through the node and do the counting
			count++;
			top = top.getNext();
		}
		return count;
	}

	/**
	 * Return iterator of the stack
	 * 
	 * @return iterator of the stack
	 */
	@Override
	public Iterator<DrawingChange> iterator() {
		return new DrawingStackIterator<DrawingChange>(top); // use top as the parameter to generate
		// a stack iterator, then return this iterator
	}
}
