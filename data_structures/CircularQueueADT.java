package data_structures;
// Emmett Maloney
// Spring 2017

public interface CircularQueueADT<T> {
	void enqueue(T t) throws RuntimeException;
	T dequeue() throws RuntimeException;
	T front() throws RuntimeException;
	T rear() throws RuntimeException;
	int size();
	boolean isEmpty();

}
