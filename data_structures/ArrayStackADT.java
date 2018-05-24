package data_structures;
// Emmett Maloney
// Spring 2017

public interface ArrayStackADT<T> {
	void push(T d) throws RuntimeException;
	T pop() throws RuntimeException;
	T peek() throws RuntimeException;
	boolean isFull();
	boolean isEmpty();
	int getSize();

}
