package main.java.trees.binaryTree;

import main.java.linkedlists.LinkedList;

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

    public Node lowestCommonAncestorBST(Node<Integer> root, int num1, int num2) {
        if (root.value <= Math.max(num1, num2) && root.value >= Math.min(num1, num2)) {
            return root;
        } else if (root.value > Math.max(num1, num2)) {
            return lowestCommonAncestorBST(root.left, num1, num2);
        } else {
            return lowestCommonAncestorBST(root.right, num1, num2);
        }
    }

    public Node lowestCommonAncestorBT(Node<T> root, Node<T> p, Node<T> q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        Node left = lowestCommonAncestorBT(root.left, p, q);
        Node right = lowestCommonAncestorBT(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;

    }

    public Node sortedArrayToBinarySearchTree(int[] array) {
        Node root = new Node(null);
        sortedArrayToBinarySearchTreeRec(array, 0, array.length - 1, root);
        return root;

    }

    public Node sortedArrayToBinarySearchTreeRec(int[] array, int start, int end, Node node) {
        int mid = start + ((end - start) / 2);
        node.value = array[mid];
        if (start == end) return node;
        if (mid > start) {
            node.left = sortedArrayToBinarySearchTreeRec(array, start, mid - 1, new Node(null));
        }
        if (mid < end) {
            node.right = sortedArrayToBinarySearchTreeRec(array, mid + 1, end, new Node(null));
        }
        return node;
    }
}
