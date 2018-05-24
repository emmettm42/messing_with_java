package csc130.maloneye.Classwork;

public interface CircularQueueADT<T> {
	void enqueue(T t) throws RuntimeException;
	T dequeue() throws RuntimeException;
	T front() throws RuntimeException;
	T rear() throws RuntimeException;
	int size();
	boolean isEmpty();

}
