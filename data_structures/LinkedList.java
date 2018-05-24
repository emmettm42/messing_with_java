package data_structures;
// Emmett Maloney
// Spring 2017

// A Linked List class with a private static inner Node class.


import java.util.*;

public class LinkedList<T> implements Iterable<T> {
   private Node<T> head;

 // Constructs an empty list
   public LinkedList(){
      head = null;
   }
 // Returns true if the list is empty
   public boolean isEmpty(){
      return head == null;
   }
	
 // Inserts a new node at the beginning of this list.
   public void addFirst(T item){
      head = new Node<T>(item, head);
   }
 // Returns the first element in the list.
   public T getFirst(){
      if(head == null) throw new NoSuchElementException();
      return head.data;
   }
 // Removes the first element in the list.
   public T removeFirst(){
      T tmp = getFirst();
      head = head.next;
      return tmp;
   }
 // Inserts a new node to the end of this list.
   public void addLast(T item){
      if( head == null)
         addFirst(item);
      else
      {
         Node<T> tmp = head;
         while(tmp.next != null) tmp = tmp.next;

         tmp.next = new Node<T>(item, null);
      }
   }
 // Returns the last element in the list.
   public T getLast()
   {
      if(head == null) throw new NoSuchElementException();

      Node<T> tmp = head;
      while(tmp.next != null) tmp = tmp.next;

      return tmp.data;
   }
 // Removes all nodes from the list.
   public void clear()
   {
      head = null;
   }
 // Returns true if this list contains the specified element.
   public boolean contains(T x)
   {
      for(T tmp : this)
         if(tmp.equals(x)) return true;

      return false;
   }
 // Returns the data at the specified position in the list.
   public T get(int pos)
   {
      if (head == null) throw new IndexOutOfBoundsException();

      Node<T> tmp = head;
      for (int k = 0; k < pos; k++) tmp = tmp.next;

      if( tmp == null) throw new IndexOutOfBoundsException();

      return tmp.data;
   }
 // Returns a string representation
   public String toString(){
      StringBuffer result = new StringBuffer();
      for(Object x : this)
      	result.append(x + " ");

      return result.toString();
   }
 /**
   *  Inserts a new node after a node containing the key.
   *
   */
   public void insertAfter(T key, T toInsert){
      Node<T> tmp = head;

      while(tmp != null && !tmp.data.equals(key)) tmp = tmp.next;

      if(tmp != null)
         tmp.next = new Node<T>(toInsert, tmp.next);
   }
 // Inserts a new node before a node containing the key.
   public void insertBefore(T key, T toInsert)
   {
      if(head == null) return;

      if(head.data.equals(key))
      {
         addFirst(toInsert);
         return;
      }

      Node<T> prev = null;
      Node<T> cur = head;

      while(cur != null && !cur.data.equals(key))
      {
         prev = cur;
         cur = cur.next;
      }
      //insert between cur and prev
      if(cur != null)
         prev.next = new Node<T>(toInsert, cur);
   }
 // Removes the first occurrence of the specified element in this list.
   public void remove(T key){
      if(head == null)
         throw new RuntimeException("cannot delete");
      if( head.data.equals(key) ){
         head = head.next;
         return;
      }

      Node<T> cur  = head;
      Node<T> prev = null;
      while(cur != null && !cur.data.equals(key) ){
         prev = cur;
         cur = cur.next;
      }

      if(cur == null)
         throw new RuntimeException("cannot delete");

      //delete cur node
      prev.next = cur.next;
   }
 /*
  *  Returns a deep copy of the list
  *  Complexity: O(n^2)  
  */
   public  LinkedList<T> copy1(){
      LinkedList<T> twin = new LinkedList<T>();
      Node<T> tmp = head;
      while(tmp != null)
      {
         twin.addLast( tmp.data );
         tmp = tmp.next;
      }

      return twin;
   }
 /**
   *  Returns a deep copy of the list
   *  Complexity: O(n)
   */
   public LinkedList<T> copy2(){
      LinkedList<T> twin = new LinkedList<T>();
      Node<T> tmp = head;
      while(tmp != null)
      {
         twin.addFirst( tmp.data );
         tmp = tmp.next;
      }

      return twin.reverse();
   }
 /**
   *  Reverses the list
   *  Complexity: O(n)
   */
   public LinkedList<T> reverse(){
      LinkedList<T> list = new LinkedList<T>();
      Node<T> tmp = head;
      while(tmp != null)
      {
         list.addFirst( tmp.data );
         tmp = tmp.next;
      }
      return list;
   }
 /**
   *  Returns a deep copy of the immutable list
   *  It uses a tail reference.
   *  Complexity: O(n)
   */
   public LinkedList<T> copy3(){
      LinkedList<T> twin = new LinkedList<T>();
      Node<T> tmp = head;
      if(head==null) return null;
      twin.head = new Node<T>(head.data, null);
      Node<T> tmpTwin = twin.head;
      while(tmp.next != null)
      {
         tmp = tmp.next;
         tmpTwin.next = new Node<T>(tmp.data, null);
         tmpTwin = tmpTwin.next;
      }

      return twin;
   }

 /*
  *
  *  The Node class
  *
  */
   private static class Node<T>
   {
      private T data;
      private Node<T> next;

      public Node(T data, Node<T> next)
      {
         this.data = data;
         this.next = next;
      }
   }

 /*
  *
  *  The Iterator class
  *
  */

   public Iterator<T> iterator() {
      return new LinkedListIterator();
   }

   private class LinkedListIterator  implements Iterator<T> {
      private Node<T> nextNode;

      public LinkedListIterator() {
         nextNode = head;
      }

      public boolean hasNext(){
         return nextNode != null;
      }

      public T next(){
         if (!hasNext()) throw new NoSuchElementException();
         T res = nextNode.data;
         nextNode = nextNode.next;
         return res;
      }

      public void remove() { throw new UnsupportedOperationException(); }
   }



//   Include the main() for testing and debugging 


   public static void main(String[] args)
   {
      LinkedList<String> list = new LinkedList <String>();
      list.addFirst("p");
      list.addFirst("a");
      list.addFirst("e");
      list.addFirst("h");
      System.out.println(list);

		LinkedList<String> twin = list.copy3();
      System.out.println(twin);

      System.out.println(list.get(0));
//		System.out.println(list.get(4));   //exception

      list.addLast("s");
      Iterator itr = list.iterator();
      while(itr.hasNext())
         System.out.print(itr.next() + " ");
      System.out.println();

      for(Object x : list)
         System.out.print(x + " ");
      System.out.println();

      list.insertAfter("e", "ee");
      System.out.println(list);
      System.out.println(list.getLast());

      list.insertBefore("h", "yy");
      System.out.println(list);

      list.remove("p");
      System.out.println(list);
	}
}
