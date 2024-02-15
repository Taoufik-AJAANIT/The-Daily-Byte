package main.java.linkedlists;

import java.util.ArrayList;

public class LinkedList<T> {
    public Node<T> head;
    public void add(T value, int index) throws Exception {
        Node<T> node = new Node<T>(value);
        addNode(node, index);
    }

    public T popFirst(){
        if(head != null){
            T value = head.value;
            head = head.next;
            return value;
        }
        return null;
    }

    public void addNode(Node<T> node, int index) throws Exception {
        if (index == 0) {
            node.next = head;
            this.head = node;
        } else {
            Node<T> previous = get(index - 1);
            node.next = previous.next;
            previous.next = node;
        }
    }

    public void addFirst(T value) throws Exception {
        this.add(value, 0);
    }

    public void addLast(T value) throws Exception {
        this.add(value, size());
    }

    public Node<T> get(int index) throws Exception {
        Node current = head;
        int position = 0;
        while (position < index && current != null){
            current = current.next;
            position++;
        }
        return current;
    }

    public T[] toArray() {
        ArrayList<T> result = new ArrayList<>();
        Node<T> current = head;
        while (current != null) {
            result.add(current.value);
            current = current.next;
        }
        return (T[]) result.toArray();
    }

    @Override
    public boolean equals(Object linkedList) {
        if (!(linkedList instanceof LinkedList)) {
            return false;
        }
        try {
            if (this.size() != ((LinkedList<T>) linkedList).size()) return false;
            Node<T> aIterator = head;
            Node<T> bIterator = ((LinkedList<T>) linkedList).get(0);
            while (aIterator.value == bIterator.value) {
                aIterator = aIterator.next;
                bIterator = bIterator.next;
                if (aIterator == null && bIterator == null) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<T> current = head;
        while (current != null){
            result.append(" " + current.value);
            current = current.next;
        }
        return result.toString();
    }

    int size(){
        Node<T> current = head;
        int size = 0;
        while (current != null){
            size++;
            current = current.next;
        }
        return size;
    }

    void clear(){
        head = null;
    }
}
