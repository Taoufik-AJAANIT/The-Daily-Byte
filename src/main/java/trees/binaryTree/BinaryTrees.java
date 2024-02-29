package main.java.trees.binaryTree;

import main.java.HashMaps;
import main.java.linkedlists.LinkedList;

import java.util.HashMap;

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

    public boolean identicalTrees(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 != null && root2 != null) {
            return root1.value == root2.value
                    && identicalTrees(root1.left, root2.left)
                    && identicalTrees(root1.right, root2.right);
        }
        return false;
    }

    public int minimumDifference(Node<Integer> root) {
        if (root == null) return Integer.MAX_VALUE;
        int leftDifference = root.left != null ? root.value - ((Integer) root.left.value) : Integer.MAX_VALUE;
        int rightDifference = root.right != null ? ((Integer) root.right.value) - root.value : Integer.MAX_VALUE;
        return Math.min(Math.min(Math.min(leftDifference, rightDifference), minimumDifference(root.left)), minimumDifference(root.right));


    }

    public int[] mode(Node<Integer> root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> max = new HashMap<>();
        max.put(-1, 0);
        modeRecc(root, map, max);
        return  max.entrySet()
                .stream()
                .map(entry -> entry.getKey())
                .mapToInt(i -> i)
                .toArray();
    }

    public void modeRecc(Node<Integer> root, HashMap<Integer, Integer> map, HashMap<Integer, Integer> max) {
        if (root == null) return;
        map.put(root.value, map.getOrDefault(root.value, 0) + 1);
        if ((int) max.values().toArray()[0] < map.get(root.value)) {
            max.clear();
            max.put(root.value, map.get(root.value));
        }
        modeRecc(root.left, map, max);
        modeRecc(root.right, map, max);
    }
}
