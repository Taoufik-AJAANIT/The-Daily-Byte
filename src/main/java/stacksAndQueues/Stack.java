package main.java.stacksAndQueues;

import main.java.linkedlists.LinkedList;

public class Stack<T> {
    LinkedList<T> list;

    Stack() {
        this.list = new LinkedList<>();
    }

    public T pop() {
        return this.list.popFirst();
    }

    public void push(T item) throws Exception {
        this.list.addFirst(item);
    }

    public boolean isEmpty(){
        return this.list.size() == 0;
    }
}
