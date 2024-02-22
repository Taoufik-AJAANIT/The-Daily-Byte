package main.java.trees.binaryTree;

public class BinaryTrees<T extends Comparable<T>> {
    public Node find(T value, Node<T> root) {
        if (root == null) return null;
        int cmp = value.compareTo(root.value);
        if (cmp == 0) return root;
        if (cmp < 0) {
            return find(value, root.left);
        }
        return find(value, root.right);
    }
}
