package csc130.maloneye.Classwork;

public class ArrayStack<T> implements ArrayStackADT<T> {
	private T[] data;
	private int f;
	private int size;
	private final int CAPACITY = 100;
	
	public ArrayStack(){
		data = (T[])(new Object[CAPACITY]);
		size = 0;
	}
	
	public ArrayStack(int s){
		if (s < 1)
			throw new RuntimeException("Invalid stack size exception...");
		data = (T[])(new Object[CAPACITY]);
		size = 0;
	}

	public void push(T d) throws RuntimeException {
		if(isFull())
			throw new RuntimeException("Stack full exception...");
		data[size] = d;
		size++;
	}


	public T pop() throws RuntimeException {
		if(isEmpty())
			throw new RuntimeException("Stack empty exception...");
		size--;
		T d = data[size];
		return d;
			
	}


	public T peek() throws RuntimeException {
		if (isEmpty())
			throw new RuntimeException("Stack empty exception...");
		return data[size-1];
	}

	
	public boolean isFull() {
		return size == data.length;
	}


	public boolean isEmpty() {
		return size == 0;
	}


	public int getSize() {
		return size;
	}
	
	public String toString() {
		String str = "Stack - size: " + size + "\n";
		for (int i = size - 1; i >= 0; i--)
			str += data[i] + "\n";
		return str;
	}

}
