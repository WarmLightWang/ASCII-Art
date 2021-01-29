import java.util.Iterator;

/**
 * This class is a direct iterator of the stack, starting at the given the given
 * node. This class implements the Iterator<DrawingChange> interface
 */
public class DrawingStackIterator<T> implements Iterator<DrawingChange> {

	private Node<DrawingChange> node; // a stack using a chain-of-linked-nodes

	/**
	 * Constructor of the iterator, creating an iterator starting at the given node.
	 * 
	 * @param a node containing DrawingChange type data
	 */
	public DrawingStackIterator(Node<DrawingChange> node) {
		this.node = node; // set the beginning node to the given node
	}

	/**
	 * Returns true if this node has a following node.
	 * 
	 * @return true if this node has a following node, false otherwise
	 */
	@Override
	public boolean hasNext() {
		if (node == null) // ensure that the node is not null first to avoid a nullPointerException
			return false;
		if (node.getData() == null)
			return false;

		return true;
	}

	/**
	 * Returns the data stored in the current node, then change the pointer to the
	 * next node.
	 * 
	 * @return DrawingChange type data stored in the current node
	 */
	@Override
	public DrawingChange next() {
		if (!hasNext())
			return null;
		DrawingChange now = node.getData(); // store the data here
		node = node.getNext();
		return now;
	}
}
