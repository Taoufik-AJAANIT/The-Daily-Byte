package test.main.java;

import main.java.linkedlists.LinkedList;
import main.java.trees.binaryTree.BinaryTrees;
import main.java.trees.binaryTree.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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

    @Test()
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

    @Test()
    @DisplayName("Visible Values")
    void visibleValues() throws Exception {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        assertArrayEquals(new int[]{4, 2}, this.binaryTrees.visibleValues(root));

        Node root2 = new Node(7);
        root2.left = new Node(4);
        root2.right = new Node(9);
        root2.right.left = new Node(8);
        root2.right.right = new Node(9);
        root2.right.right.right = new Node(9);
        root2.left.left = new Node(1);
        root2.left.right = new Node(4);
        assertArrayEquals(new int[]{7, 4, 1, 9}, this.binaryTrees.visibleValues(root2));


    }

    @Test
    @DisplayName("Gather Levels Bottom Up")
    void gatherLevelsBottomUp() throws Exception {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        assertArrayEquals(new int[][]{{2, 7}, {4}}, this.binaryTrees.gatherLevelsBottomUp(root));

        Node root1 = new Node(2);
        root1.left = new Node(10);
        root1.right = new Node(15);
        root1.right.right = new Node(20);
        assertArrayEquals(new int[][]{{20}, {10, 15}, {2}}, this.binaryTrees.gatherLevelsBottomUp(root1));

        Node root3 = new Node(1);
        root3.left = new Node(9);
        root3.left.left = new Node(3);
        root3.right = new Node(32);
        root3.right.right = new Node(78);
        assertArrayEquals(new int[][]{{3, 78}, {9, 32}, {1}}, this.binaryTrees.gatherLevelsBottomUp(root3));

    }

    @Test
    @DisplayName("Zig Zag Traversal")
    void zigZagTraversal() throws Exception {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        assertArrayEquals(new int[][]{{1}, {3, 2}}, this.binaryTrees.zigZagTraversal(root));

        Node root1 = new Node(8);
        root1.left = new Node(2);
        root1.right = new Node(29);
        root1.right.right = new Node(9);
        root1.right.left = new Node(3);
        root1.left.right = new Node(10);
        root1.left.left = new Node(1);
        assertArrayEquals(new int[][]{{8}, {29, 2}, {1, 10, 3, 9}}, this.binaryTrees.zigZagTraversal(root1));

    }

    @Test
    @DisplayName("Gather Columns")
    void gatherColumns() throws Exception {
        Node root = new Node(8);
        root.left = new Node(2);
        root.right = new Node(29);
        root.right.left = new Node(3);
        root.right.right = new Node(9);
        assertArrayEquals(new int[][]{{2}, {8, 3}, {29}, {9}}, this.binaryTrees.gatherColumns(root));

        Node root1 = new Node(100);
        root1.left = new Node(53);
        root1.right = new Node(78);
        root1.right.right = new Node(20);
        root1.right.left = new Node(9);
        root1.left.right = new Node(3);
        root1.left.left = new Node(32);
        assertArrayEquals(new int[][]{{32}, {53}, {100, 3, 9}, {78}, {20}}, this.binaryTrees.gatherColumns(root1));

    }

    @Test
    @DisplayName("Calculate Depth")
    void calculateDepth(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        assertEquals(2, this.binaryTrees.calculateDepth(root));

        Node root2 = new Node(5);
        root2.left = new Node(1);
        root2.right = new Node(29);
        root2.right.left = new Node(4);
        root2.right.right = new Node(13);
        assertEquals(3, this.binaryTrees.calculateDepth(root2));

        Node root1 = new Node(100);
        root1.left = new Node(53);
        root1.right = new Node(78);
        root1.right.right = new Node(20);
        root1.right.left = new Node(9);
        root1.right.left.right = new Node(3);
        root1.right.left.left = new Node(32);
        assertEquals(4, this.binaryTrees.calculateDepth(root1));
    }

    @Test
    @DisplayName("Root to Leaf Paths")
    void rootToLeafPaths(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        assertArrayEquals(new String[]{"1->2", "1->3"}, this.binaryTrees.rootToLeafPaths(root));

        Node root2 = new Node(5);
        root2.left = new Node(1);
        root2.right = new Node(29);
        root2.right.left = new Node(4);
        root2.right.right = new Node(13);
        assertArrayEquals(new String[]{"5->1", "5->29->4", "5->29->13"}, this.binaryTrees.rootToLeafPaths(root2));
    }

    @Test
    @DisplayName("Root to Leaf Path Sum")
    void rootToLeafPathSum(){
        Node root = new Node(1);
        root.left = new Node(5);
        root.left.left = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(29);
        root.right.left = new Node(12);
        assertTrue(this.binaryTrees.rootToLeafPathSum(root, 15));

        Node root2 = new Node(104);
        root2.left = new Node(39);
        root2.right = new Node(31);
        root2.right.left = new Node(9);
        root2.right.right = new Node(10);
        root2.left.left = new Node(32);
        root2.left.right = new Node(1);
        assertTrue(this.binaryTrees.rootToLeafPathSum(root2, 175));

        Node root3= new Node(1);
        root3.left = new Node(5);
        root3.right = new Node(2);
        assertFalse(this.binaryTrees.rootToLeafPathSum(root3, 4));
    }

    @Test
    @DisplayName("Validate Tree")
    void validateBST(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        assertFalse(this.binaryTrees.validateBST(root));

        Node root2 = new Node(2);
        root2.left = new Node(1);
        root2.right = new Node(3);
        assertTrue(this.binaryTrees.validateBST(root2));
        Node root3 = new Node(5);
        root3.right = new Node(6);
        root3.right.left = new Node(3);
        root3.right.right = new Node(7);
        root3.left = new Node(4);
        assertFalse(this.binaryTrees.validateBST(root3));
    }

    @Test
    @DisplayName("Symmetrical Tree")
    void symetricalTree(){
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(1);
        assertTrue(this.binaryTrees.symetricalTree(root));

        Node root2 = new Node(1);
        root2.left = new Node(5);
        root2.left.right = new Node(7);
        root2.right = new Node(5);
        root2.right.right = new Node(7);
        assertFalse(this.binaryTrees.symetricalTree(root2));
    }
    @Test
    @DisplayName("Same Leaves")
    void sameLeaves(){
        Node root1a = new Node(1);
        root1a.left = new Node(1);
        root1a.right = new Node(3);

        Node root1b = new Node(7);
        root1b.left = new Node(1);
        root1b.right = new Node(2);
        assertFalse(this.binaryTrees.sameLeaves(root1a, root1b));


        Node root2a = new Node(8);
        root2a.left = new Node(2);
        root2a.right = new Node(29);
        root2a.right.left = new Node(3);
        root2a.right.right = new Node(9);

        Node root2b = new Node(8);
        root2b.left = new Node(2);
        root2b.left.left = new Node(2);
        root2b.right = new Node(29);
        root2b.right.left = new Node(3);
        root2b.right.left.left = new Node(3);
        root2b.right.right = new Node(9);
        assertTrue(this.binaryTrees.sameLeaves(root2a, root2b));

        Node root3a = new Node(1);
        root3a.left = new Node(2);

        Node root3b = new Node(2);
        root3b.left = new Node(2);
        assertTrue(this.binaryTrees.sameLeaves(root3a, root3b));

    }
}