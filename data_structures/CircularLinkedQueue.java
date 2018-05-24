package csc130.maloneye.Classwork;

public class CircularLinkedQueue<T> implements CircularQueueADT<T> {
	private class Node<E> {
		private E data;
		private Node<E> next;

		public Node() {
			data = null;
			next = null;
		}

		public Node(E d) {
			data = d;
			next = null;
		}

		public Node(E d, Node<E> n) {
			data = d;
			next = n;
		}
	}

	private Node<T> rear;
	private int size;

	public void enqueue(T d) {
		if (isEmpty()) {
			rear = new Node<T>(d);
			rear.next = rear;
		} else {
			rear.next = new Node<T>(d, rear.next);
			rear = rear.next;
		}
		size++;
	}

	public T dequeue() throws RuntimeException {
		if (isEmpty())
			throw new RuntimeException("Queue empty exception...");
		T d = rear.next.data;
		if (rear.next == rear)
			rear = null;
		else
			rear.next = rear.next.next;
		size--;
		return d;
	}

	public T front() throws RuntimeException {
		if (isEmpty())
			throw new RuntimeException("Queue empty exception...");
		return rear.next.data;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public String toString() {
		String str = "[";
		if (rear != null) {
			Node<T> trav = rear.next;
			for (int i = 0; i < size; i++) {
				str += trav.data + ((i < size-1) ? "," : "");
				trav = trav.next;
			}
		}
		str += "]";
		return str;
	}

	@Override
	public T rear() throws RuntimeException {
		return (T) rear;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}