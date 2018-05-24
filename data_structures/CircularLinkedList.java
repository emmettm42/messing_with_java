package data_structures;
// Emmett Maloney
// Spring 2017

public class CircularLinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private Node<T> current;
    private int count; // total items in the list
    public CircularLinkedList<T> getCurrent;

    public CircularLinkedList() {
        first = null;
        last = null;
        current = null;
        count = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void step() {
        current = current.next;
    }

    public Node<T> getCurrent() {
        return current;
    }

    public void insert(T d) {
        Node<T> newNode = new Node(d);

        if (isEmpty()) {
            first = newNode;
            current = first;
        } else {
            current.next = newNode;
        }

        newNode.next = first;
        last = newNode;
        step();
        count++;
    }

    public boolean search(T d) {
        Node<T> search = first;
        int y = 0;

        while (search.data != d && y < count) {
            search = search.next;
            y++;
        }

        if (search.data == d) {
            System.out.println("Found the value: " + search.data);
            return true;
        } else {
            System.out.println("Value not found in list");
            return false;
        }

    }

    public void delete(T d) {
        Node<T> prev = first;
        Node<T> curr = first.next;
        int y = 0;

        while (y < count && curr.data != d) {
            prev = curr;
            curr = curr.next;
        }

        if (count == 1) {
            first = null;
            count--;
        } else {
            prev.next = curr.next;
            count--;
        }

    }


    public void displayList() {
        int x = 0;
        Node printer = first;

        while (x < count) {
            printer.toString();
            printer = printer.next;
            x++;
        }

    }

}
