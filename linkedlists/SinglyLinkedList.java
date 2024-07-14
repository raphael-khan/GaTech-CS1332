package linkedlists;

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
        	throw new IllegalArgumentException("Data cannot be null.");
        }
        
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
        
        // check if list is empty, the new node is both head and tail.
        if (head == null) {
        	head = newNode;
        	tail = newNode;
        }
        // if the list is not empty. 
        else {
        	newNode.setNext(head);
        	head = newNode;
        }
        
        size++;
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
        	throw new IllegalArgumentException("Data cannot be null.");
        }
        
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
        
        if (head == null) {
        	// if list is empty, the new node is both head and tail. 
        	head = newNode;
        	tail = newNode;
        }
        else {
        	// if list is not empty, link the tail's next to the new node to run in O(1). 
        	tail.setNext(newNode);
        	tail = newNode;
        }
        
        size++;
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
    	} 
    	
    	// Get the data from the head node. 
    	T removedData = head.getData();
    	
    	// Update the head to the next node. 
    	head = head.getNext();
    	
    	// if the list is now empty because there was only 1 node. 
    	if (head == null) {
    		tail = null;
    	}
    	
    	// Decrement the size. 
    	size--;
    	
		return removedData;
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
    	}
    	
    	// if list only contains 1 node. 
    	if(head.getNext() == null) {
    		T removedData = head.getData();
    		head = null;
    		tail = null;
    		size--;
    		return removedData;
    	}
    	
    	// Initialize current node at head. 
    	SinglyLinkedListNode<T> currNode = head;
    	// Loop until currNode is the node right before the last node. 
    	while (currNode.getNext().getNext() != null) {
    		currNode = currNode.getNext();
    	}
    	
    	// Get the data from last node. 
    	T removedData = currNode.getNext().getData();
    	
    	// Set the next reference of the node before the last node to null. 
    	currNode.setNext(null);
    	
    	// update the tail to the new last node. 
    	tail = currNode;
    	
    	// Decrement the size. 
    	size--;
    	
		return removedData;
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
