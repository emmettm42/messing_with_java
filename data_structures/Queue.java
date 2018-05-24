package csc130.maloneye.Lab5a;

/**
 * <p>
 * Title: Queue
 * </p>
 *
 * <p>
 * Description: Implements QueueADT with use of an Array
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


public class Queue<T> implements QueueADT<T> {
	// Instance Variables
	private T[] data;		// Holds data
	private int size, front, rear;
	private final int CAPACITY = 100;
	/**
	 * Default constructor, creates array of size 100
	 */
	public Queue(){
		data = (T[]) new Object[CAPACITY];
		size = 0;
	}
	
	public Queue(int s) throws QueueException {
		if (s < 1) throw new QueueException("Cannot create a queue with a size less than 1");
		data = (T[]) new Object[s];
		size = 0;
	}
	
	
	/**
	 * inserts an element at the rear of the queue
	 */
	@Override
	public synchronized void enqueue(T d) throws QueueException {
		if(isFull()) throw new QueueException("Full");
		data[rear] = d;
		rear = (rear + 1) % data.length;
		size++;
	}

	/**
	 * removes and returns the first element of the queue (null if empty)
	 */
	@Override
	public synchronized T dequeue() throws QueueException {
		if(isEmpty()) throw new QueueException("Empty");
		T answer = data[front]; // capture element
		data[front] = null;  // detach element
		front = (front + 1) % data.length; // change the front element
		size--;
		return answer;
	}

	/** 
	 * returns the element at the front of the queue
	 */
	@Override
	public synchronized T front() throws QueueException {
		if (isEmpty()) throw new QueueException("Empty");
		return data[front];
	}

	/**
	 * returns the element at the rear of the queue
	 */
	@Override
	public synchronized T rear() throws QueueException {
		if(isEmpty()) throw new QueueException("Empty");
		return data[rear];
	}

	/**
	 * tests whether the queue is empty or not
	 */
	@Override
	public synchronized boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * tests if the queue is full
	 */
	@Override
	public synchronized boolean isFull() {
		return (size == data.length);
	}
	
	/**
	 * returns the size of the queue
	 */
	@Override
	public synchronized int getSize() {
		return size;
	}
	
	@Override
	public synchronized String toString() {
		String str = "";
		if (isEmpty()) {
			str = "Queue is empty! Maximum number of items that can be stored is " + data.length;
		} else {
			int trav = front;
			int count = 0;
			str = "The queue contains the following: \n";
			for (int i = 0; i < size; i++) {
				str += data[trav] + ((i < size - 1) ? ", " : "");
				count++;
				trav = (trav + 1) % data.length;
			}
			String introStr = "The number of items in the queue is: " + count + "\n";
			str = introStr + str;
		}

		return str;
	}
	
	public synchronized void makeEmpty() throws QueueException {
		if(isEmpty()) throw new QueueException("Empty");
		while(!isEmpty()){
			data[front] = null;
			front = (front + 1) % data.length;
			size--;
		}
	}


}
