package csc130.maloneye.Classwork;

public interface ArrayStackADT<T> {
	void push(T d) throws RuntimeException;
	T pop() throws RuntimeException;
	T peek() throws RuntimeException;
	boolean isFull();
	boolean isEmpty();
	int getSize();

}
