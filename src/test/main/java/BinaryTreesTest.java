package test.main.java;

import main.java.linkedlists.LinkedList;
import main.java.trees.binaryTree.BinaryTrees;
import main.java.trees.binaryTree.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreesTest {
    private BinaryTrees binaryTrees;

    @BeforeEach
    void setUp() {
        this.binaryTrees = new BinaryTrees();
    }

    @Test
    @DisplayName("Find Value")
    void find() {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(4);
        assertEquals(root.left, this.binaryTrees.find(1, root));


        Node root2 = new Node(7);
        root2.left = new Node(5);
        root2.right = new Node(9);
        root2.right.left = new Node(8);
        root2.right.right = new Node(10);
        assertEquals(root2.right, this.binaryTrees.find(9, root2));


        Node root3 = new Node(8);
        root3.left = new Node(6);
        root3.right = new Node(9);
        assertEquals(null, this.binaryTrees.find(7, root3));
    }

    @Test
    @DisplayName("Convert Binary Search Tree to Sorted Linked List")
    void toSortedLinkedList() throws Exception {
        Node root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(6);
        LinkedList<Integer> a = new LinkedList();
        a.addLast(1);
        a.addLast(5);
        a.addLast(6);
        assertEquals(a, this.binaryTrees.toSortedLinkedList(root));


        Node root2 = new Node(5);
        root2.left = new Node(2);
        root2.right = new Node(9);
        root2.left.left = new Node(1);
        root2.left.right = new Node(3);

        LinkedList<Integer> b = new LinkedList();
        b.addLast(1);
        b.addLast(2);
        b.addLast(3);
        b.addLast(5);
        b.addLast(9);
        assertEquals(b, this.binaryTrees.toSortedLinkedList(root2));


        Node root3 = new Node(5);
        root3.right = new Node(6);

        LinkedList<Integer> c = new LinkedList();
        c.addLast(5);
        c.addLast(6);
        assertEquals(c, this.binaryTrees.toSortedLinkedList(root3));
    }

    @Test
    @DisplayName("Lowest Common Ancestor")
    void lowestCommonAncestor() throws Exception {
        Node root = new Node(7);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(5);
        root.right = new Node(9);

        assertEquals(root, this.binaryTrees.lowestCommonAncestor(root, 1, 9));

        Node root2 = new Node(8);
        root2.left = new Node(3);
        root2.left.left = new Node(2);
        root2.left.right = new Node(6);
        root2.right = new Node(9);

        assertEquals(root2.left, this.binaryTrees.lowestCommonAncestor(root2, 2, 6));

        Node root3 = new Node(8);
        root3.left = new Node(6);
        root3.right = new Node(9);

        assertEquals(root3, this.binaryTrees.lowestCommonAncestor(root3, 6, 8));

    }

}