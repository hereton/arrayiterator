package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ArrayIterator is a class that iterate elements in an array. it can print
 * value and move next, check if there is next element left.
 * 
 * @author totsapon menkul
 *
 * @param <T>
 *            is a type parameter, which is a placeholder for the name of a
 *            class or Interface
 */
public class ArrayIterator<T> implements Iterator<T> {

	/** attribute for the array we want to iterate over */
	private T[] array;

	/** the position in element; */
	private int cursor;

	/** to check that there is no next element left */
	private boolean check;

	/**
	 * Initialize a new array iterator with the array to process.
	 * 
	 * @param array
	 *            is the array to iterate over
	 */
	public ArrayIterator(T[] array) {
		this.array = array;
		this.check = false;

	}

	/**
	 * if there is no next element left, it will throw NoSuchElementException.
	 * 
	 * 
	 * @throws NoSuchElementException
	 *             if there are no more elements to return.
	 */
	public void remove() {
		if (check) {
			array[cursor - 1] = null;
			check = false;
		}

		else {
			throw new NoSuchElementException();
		}

	}

	/**
	 * to check is there has next element in an array
	 * 
	 * @return true if there is next element (not include "null" in the element)
	 *         false if there is not has next element.
	 */
	@Override
	public boolean hasNext() {
		for (int i = this.cursor; i < this.array.length; i++) {
			if (this.array[i] != null) {
				this.cursor = i;
				return true;
			}
		}

		return false;
	}

	/**
	 * Return the next non-null element from array, if any.
	 * 
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException
	 *             if there are no more elements to return.
	 */
	@Override
	public T next() {
		if (this.hasNext()) {
			T nextElement = array[cursor];
			this.cursor += 1;
			this.check = true;
			return nextElement;
		}

		else {
			throw new NoSuchElementException();
		}

	}

}
