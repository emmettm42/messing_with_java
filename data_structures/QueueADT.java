package csc130.maloneye.Lab5a;
/**
 * <p>
 * Title: QueueADT.java
 * </p>
 *
 * <p>
 * Description: Interface for a Queue
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2017
 * </p>
 *
 * <p>
 * Company:
 * </p>
 *
 * @author E Maloney
 * @version 1.0
 */


public interface QueueADT<T> {
	void enqueue(T d) throws QueueException;

	T dequeue() throws QueueException;

	T front() throws QueueException;
	
	T rear() throws QueueException;

	int getSize();
	
	boolean isFull();

	boolean isEmpty();

}
