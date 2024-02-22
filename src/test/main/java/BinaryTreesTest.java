package test.main.java;

import main.java.trees.binaryTree.BinaryTrees;
import main.java.trees.binaryTree.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreesTest {
    private BinaryTrees binaryTrees;
    @BeforeEach
    void setUp(){
        this.binaryTrees = new BinaryTrees();
    }

    @Test
    @DisplayName("Find Value")
    void find(){
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

}