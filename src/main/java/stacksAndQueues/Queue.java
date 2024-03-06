package main.java.stacksAndQueues;
import main.java.linkedlists.Node;

public class Queue<T> {
    Node<T> head;
    Node<T> tail;
    public int size;

    public T peek() {
        if (this.head != null) {
            return this.head.value;
        }
        return null;
    }

    public T remove() {
        if (this.head != null) {
            T value = this.head.value;
            this.head = this.head.next;
            this.size--;
            return value;
        }
        return null;
    }

    public void add(T item) {
        Node<T> tail = new Node<>(item);
        if (this.head == null) {
            this.tail = tail;
            this.head = tail;
        } else {
            this.tail.next = tail;
            this.tail = tail;
        }
        this.size++;
    }

    public boolean isEmpty() {
        return head == null;
    }

}
