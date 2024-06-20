package queues;

import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayQueue.
 */
public class ArrayQueue<T> {

    /*
     * The initial capacity of the ArrayQueue.
     *
     * DO NOT MODIFY THIS VARIABLE.
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int front;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayQueue.
     * 
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayQueue() {
        // DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the back of the queue.
     *
     * If sufficient space is not available in the backing array, resize it to
     * double the current length. When resizing, copy elements to the
     * beginning of the new array and reset front to 0.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the queue
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void enqueue(T data) {
        // check if the data is null. 
    	if (data == null) {
    		throw new IllegalArgumentException("Data cannot be null.");
    	}
    	// check if the array is full and needs resized.
    	if (size == backingArray.length) {
    		T[] newArray = (T[]) new Object[backingArray.length * 2];
    		
    		// copy elements from old array to new array. 
    		for (int i =0; i < size; i++) {
    			newArray[i] = backingArray[(front + i) % backingArray.length];
    		}
    		
    		// update the backing array, reset front to 0.
    		backingArray = newArray;
    		front = 0;
    	}
    	
    	// calculate the index for the new element. 
    	int index = (front + size) % backingArray.length;
    	
    	// Add the new element to the array. 
    	backingArray[index] = data;
    	
    	// increment the size.
    	size++;
    }

    /**
     * Removes and returns the data from the front of the queue.
     *
     * Do not shrink the backing array.
     *
     * Replace any spots that you dequeue from with null.
     *
     * If the queue becomes empty as a result of this call, do not reset
     * front to 0.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T dequeue() {
    	// check if the queue is empty.
    	if (size == 0) {
    		throw new NoSuchElementException("Queue is empty");
    	}
    	
    	// get the data from the front of the queue. 
    	T data = backingArray[front];
    	
    	// set the front element to null.
    	backingArray[front] = null;
    	
    	// update the front index.
    	front = (front + 1) % backingArray.length;
    	
    	// decrement the size. 
    	size--;
    	
		return data;

    }

    /**
     * Returns the backing array of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the queue
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the queue
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}