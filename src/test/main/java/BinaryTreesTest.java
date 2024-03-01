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
    @DisplayName("Lowest Common Ancestor Binary Search Tree")
    void lowestCommonAncestorBST() throws Exception {
        Node root = new Node(7);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(5);
        root.right = new Node(9);

        assertEquals(root, this.binaryTrees.lowestCommonAncestorBST(root, 1, 9));

        Node root2 = new Node(8);
        root2.left = new Node(3);
        root2.left.left = new Node(2);
        root2.left.right = new Node(6);
        root2.right = new Node(9);

        assertEquals(root2.left, this.binaryTrees.lowestCommonAncestorBST(root2, 2, 6));

        Node root3 = new Node(8);
        root3.left = new Node(6);
        root3.right = new Node(9);

        assertEquals(root3, this.binaryTrees.lowestCommonAncestorBST(root3, 6, 8));

    }

    @Test
    @DisplayName("Lowest Common Ancestor Binary  Tree")
    void lowestCommonAncestorBT() throws Exception {
        Node root = new Node(7);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(5);
        root.right = new Node(9);

        assertEquals(root, this.binaryTrees.lowestCommonAncestorBT(root, root.left.left, root.right));

        Node root2 = new Node(8);
        root2.left = new Node(3);
        root2.left.left = new Node(2);
        root2.left.right = new Node(6);
        root2.right = new Node(9);

        assertEquals(root2.left, this.binaryTrees.lowestCommonAncestorBT(root2, root2.left.left, root2.left.right));

        Node root3 = new Node(8);
        root3.left = new Node(6);
        root3.right = new Node(9);

        assertEquals(root3, this.binaryTrees.lowestCommonAncestorBT(root3, root3.left, root3));

    }

    @Test
    @DisplayName("Identical Trees")
    void identicalTrees() throws Exception {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);

        Node root2 = new Node(2);
        root2.left = new Node(1);
        root2.right = new Node(3);

        assertTrue(this.binaryTrees.identicalTrees(root, root2));

        Node root3 = new Node(1);
        root3.right = new Node(9);
        root3.right.right = new Node(18);
        Node root4 = new Node(1);
        root4.left = new Node(9);
        root4.left.right = new Node(18);

        assertFalse(this.binaryTrees.identicalTrees(root3, root4));

        Node root5 = new Node(2);
        root5.right = new Node(1);
        root5.left = new Node(3);
        Node root6 = new Node(2);
        root6.left = new Node(1);
        root6.right = new Node(3);

        assertFalse(this.binaryTrees.identicalTrees(root5, root6));


    }

    @Test
    @DisplayName("Minimum Difference")
    void minimumDifference() throws Exception {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        assertEquals(1, this.binaryTrees.minimumDifference(root));

        Node root2 = new Node(29);
        root2.left = new Node(17);
        root2.left.left = new Node(1);
        root2.right = new Node(50);
        root2.right.left = new Node(42);
        root2.right.right = new Node(59);
        assertEquals(8, this.binaryTrees.minimumDifference(root2));

        Node root3 = new Node(2);
        root3.right = new Node(100);

        assertEquals(98, this.binaryTrees.minimumDifference(root3));

    }

    @Test
    @DisplayName("Mode")
    void mode() throws Exception {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(2);
        assertEquals(2, this.binaryTrees.mode(root));

        Node root2 = new Node(7);
        root2.left = new Node(4);
        root2.left.left = new Node(1);
        root2.left.right = new Node(4);
        root2.right = new Node(9);
        root2.right.left = new Node(8);
        root2.right.right = new Node(9);
        root2.right.right.right = new Node(9);
        assertEquals(9, this.binaryTrees.mode(root2));

    }

    @Test
    @DisplayName("Gather Levels")
    void gatherLevels() throws Exception {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        assertArrayEquals(new int[][]{{4}, {2, 7}}, this.binaryTrees.gatherLevels(root));

        Node root1 = new Node(2);
        root1.left = new Node(10);
        root1.right = new Node(15);
        root1.right.right = new Node(20);
        assertArrayEquals(new int[][]{{2}, {10, 15}, {20}}, this.binaryTrees.gatherLevels(root1));

        Node root3 = new Node(1);
        root3.left = new Node(9);
        root3.left.left = new Node(3);
        root3.right = new Node(32);
        root3.right.right = new Node(78);
        assertArrayEquals(new int[][]{{1}, {9, 32}, {3, 78}}, this.binaryTrees.gatherLevels(root3));

    }

    @Test
    @DisplayName("Max Value in Each Level")
    void maxValueInEachLevel() throws Exception {
        Node root = new Node(2);
        root.left = new Node(10);
        root.right = new Node(15);
        root.right.right = new Node(20);
        assertArrayEquals(new int[]{2, 15, 20}, this.binaryTrees.maxValueInEachLevel(root));

        Node root2 = new Node(1);
        root2.left = new Node(5);
        root2.right = new Node(6);
        root2.right.right = new Node(7);
        root2.left.left = new Node(5);
        root2.left.right = new Node(3);
        assertArrayEquals(new int[]{1, 6, 7}, this.binaryTrees.maxValueInEachLevel(root2));


    }

}