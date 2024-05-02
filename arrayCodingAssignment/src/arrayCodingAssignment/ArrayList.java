package arrayCodingAssignment;

import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayList.
 */
public class ArrayList<T> {

	/*
	 * The initial capacity of the ArrayList.
	 *
	 * DO NOT MODIFY THIS VARIABLE!!
	 */
	public static final int INITIAL_CAPACITY = 9;

	/*
	 * Do not add new instance variables or modify existing ones.
	 */
	private T[] backingArray;
	private int size;

	/**
	 * This is the constructor that constructs a new ArrayList.
	 * 
	 * Recall that Java does not allow for regular generic array creation, so
	 * instead we cast an Object[] to a T[] to get the generic typing.
	 */
	public ArrayList() {
		// DO NOT MODIFY THIS METHOD!
		backingArray = (T[]) new Object[INITIAL_CAPACITY];
	}

	/**
	 * Adds the data to the front of the list.
	 *
	 * This add may require elements to be shifted.
	 *
	 * Method should run in O(n) time.
	 *
	 * @param data the data to add to the front of the list
	 * @throws java.lang.IllegalArgumentException if data is null
	 */
	public void addToFront(T data) {
		if (data == null) {
			throw new IllegalArgumentException("Data cannot be null");
		}

		// Check if array is full.
		if (size == INITIAL_CAPACITY) {
			T[] newBackingArr = (T[]) new Object[backingArray.length * 2];
			for (int i = 0; i < size; i++) {
				/**
				 *  Keep the first index empty when resizing and adding to the front. 
				 */
				
				newBackingArr[i + 1] = backingArray[i];
			}
			
			backingArray = newBackingArr;
			
			size = size * 2;
			
		} else {
			// start from back and shift elements to right. 
			for (int i = size - 1; i >= 0; i--) {
				backingArray[i + 1] = backingArray[i];
			}
		}

		backingArray[0] = data;

		size++;
	}

	/**
	 * Adds the data to the back of the list.
	 *
	 * Method should run in amortized O(1) time.
	 *
	 * @param data the data to add to the back of the list
	 * @throws java.lang.IllegalArgumentException if data is null
	 */
	public void addToBack(T data) {
		if (data == null) {
			throw new IllegalArgumentException("data cannot be null");
		}

		// Check if array is full.
		if (size == INITIAL_CAPACITY) {
			// Resize.
			T[] newBackingArr = (T[]) new Object[backingArray.length * 2];
			for (int i = 0; i < size; i++) {
				// copy over to the new arr.
				newBackingArr[i] = backingArray[i];
			}

			backingArray = newBackingArr;
			
			size = size * 2;
		}
		// Add the data regardless to the next available index.
		backingArray[size] = data;

		// Increment size of the array.
		size++;
	}

	/**
	 * Removes and returns the first data of the list.
	 *
	 * Do not shrink the backing array.
	 *
	 * This remove may require elements to be shifted.
	 *
	 * Method should run in O(n) time.
	 * 
	 * @return
	 *
	 * @throws java.util.NoSuchElementException if the list is empty
	 */
	public T removeFromFront() {

		if (size == 0) {
			throw new NoSuchElementException("List cannot be empty.");
		}

		T dataRemoved = backingArray[0];

		// Shift the elements to left.
		for (int i = 1; i < size; i++) {
			backingArray[i - 1] = backingArray[i];
		}
		// Set the last element to null.
		backingArray[size - 1] = null;

		// update size.
		size--;

		return dataRemoved;

	}

	/**
	 * Removes and returns the last data of the list.
	 *
	 * Do not shrink the backing array.
	 *
	 * Method should run in O(1) time.
	 *
	 * @return the data formerly located at the back of the list
	 * @throws java.util.NoSuchElementException if the list is empty
	 */
	public T removeFromBack() {

		if (size == 0) {
			throw new NoSuchElementException("List cannot be empty");
		}


		T dataRemoved = backingArray[size - 1];
		
		backingArray[size- 1] = null;
		
		size--;

		return dataRemoved;
	}

	/**
	 * Returns the backing array of the list.
	 *
	 * For grading purposes only. You shouldn't need to use this method since you
	 * have direct access to the variable.
	 *
	 * @return the backing array of the list
	 */
	public T[] getBackingArray() {
		// DO NOT MODIFY THIS METHOD!
		return backingArray;
	}

	/**
	 * Returns the size of the list.
	 *
	 * For grading purposes only. You shouldn't need to use this method since you
	 * have direct access to the variable.
	 *
	 * @return the size of the list
	 */
	public int size() {
		// DO NOT MODIFY THIS METHOD!
		return size;
	}

}
