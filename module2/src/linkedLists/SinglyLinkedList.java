package linkedLists;

import java.util.NoSuchElementException;


/**
 * Your implementation of a Singly-Linked List.
 * @param <Node>
 */
public class SinglyLinkedList<T, Node> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
    	
        if (data == null) {
        	throw new IllegalArgumentException("No data is passed in.");
        }
        // check if list is empty. 
        if (head == null) {
        	head = new SinglyLinkedListNode<T>(data);
        	size++;
        }
        // if not empty, then create a new node. 
        else {
        	SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(data);
        	// set new nodes next ref to head. 
        	newNode.setNext(head);
        	// set the head ref to the new node. 
        	head = newNode;
        	size++;
        }
    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        if (data == null) {
        	throw new IllegalArgumentException("data passed is null");
        } 
        // if list is empty.
        if (head == null) {
        	head = new SinglyLinkedListNode<T>(data);
        	size++;
        }
        else {
        	// create currNode and point it to head. 
        	SinglyLinkedListNode<T> currNode = head; 
        	while (currNode.getNext() != null) {
        		// move currNode forward till the last node. 
        		currNode = currNode.getNext();
        	}
        	// once last node is reached, currNode.next will be null.
        	SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(data);
        	currNode.setNext(newNode);
        }
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
    	
    	// If list is empty. 
    	if (head == null) {
    		throw new NoSuchElementException("List is empty");
    	} else {
    		head = head.getNext();
    	}
		return null;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
    	// if list is empty. 
    	if (head == null) {
    		throw new NoSuchElementException("List is empty");
    		// if list only contains 1 node. 
    	} else if(head.getNext() == null) {
    		head = null;
    	} else {
    		// initialize current node at head. 
    		SinglyLinkedListNode<T> currNode = head;
    		// loop while curr.next.next is not null to stop before the last node. 
    		while (currNode.getNext().getNext() != null) {
    			currNode = currNode.getNext();
    		}
    		// right before next node. set the next ref to null. 
    		currNode.setNext(null);
    	}
		return null;
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}
