package csc130.maloneye.Classwork;
// Emmett Maloney
// Spring 2017

public class Node<T> {
	T data;
	Node<T> next;
	
	public Node(){
		 data = null;
		 next = null;
	}
	
	public Node(T t){
		data = t;
		next = null;
	}
	
	public Node(T t, Node<T> n){
		data = t;
		next = n;
	}
	
	public String toString(){
		return this.data + "";
	}

}
