package linkedLists;

import org.w3c.dom.Node;

public class Recursion<T> {
	
	private Node head;
	
	/**
	 * Recursion with a sorted SLL and no tail reference.
	 */
	
	// Wrapper (). 
	public void removeDuplicates() {
		head = rRemove(head);
	}
	
	private Node rRemove(Node curr){
		Node curr1 = null;
		 
		// Base case, if current is null, end of list has been reached. 
		if (curr1 == null) {
			return null;
		}
		// if not null, call the recursive ().
		curr1 = rRemove(curr1);
		
		if (curr1 != null && curr1.equals(curr1)) {
			return curr1;
		}
		return curr1;
	}

}
