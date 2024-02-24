package main.java.trees.binaryTree;


import main.java.linkedlists.LinkedList;

import java.sql.PreparedStatement;

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

    public LinkedList toSortedLinkedList(Node<T> root) throws Exception {
        if (root == null) return null;
        LinkedList result = new LinkedList();
        return toSortedLinkedListRecc(root, result);

    }

    private LinkedList toSortedLinkedListRecc(Node<T> root, LinkedList result) throws Exception {
        if (root == null) return result;
        toSortedLinkedListRecc(root.left, result);
        result.addLast(root.value);
        toSortedLinkedListRecc(root.right, result);
        return result;
    }

    public Node lowestCommonAncestor(Node<Integer> root, int num1, int num2) {
        if (root.value <= Math.max(num1, num2) && root.value >= Math.min(num1, num2)) {
            return root;
        } else if (root.value > Math.max(num1, num2)) {
            return lowestCommonAncestor(root.left, num1, num2);
        } else {
            return lowestCommonAncestor(root.right, num1, num2);
        }
    }
}
