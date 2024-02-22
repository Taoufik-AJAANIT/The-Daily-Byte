package main.java.trees.binaryTree;

public class Node<T extends Comparable<T>> {
    public Node left;
    public Node right;
    public T value;

    public Node(T value) {
        this.value = value;
    }
}
