package test.main.java;

import main.java.linkedlists.LinkedList;
import main.java.linkedlists.LinkedLists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListsTest {
    private LinkedLists linkedLists;

    @BeforeEach
    void setUp() {
        this.linkedLists = new LinkedLists();
    }

    @Test
    @DisplayName("Merge Linked Lists")
    void merge() throws Exception {
        LinkedList<Integer> a = new LinkedList();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);

        LinkedList<Integer> b = new LinkedList();
        b.addLast(4);
        b.addLast(5);
        b.addLast(6);

        LinkedList<Integer> result = new LinkedList();
        result.addLast(1);
        result.addLast(2);
        result.addLast(3);
        result.addLast(4);
        result.addLast(5);
        result.addLast(6);
        assertEquals(result, this.linkedLists.merge(a, b));

        LinkedList<Integer> c = new LinkedList();
        c.addLast(1);
        c.addLast(3);
        c.addLast(5);

        LinkedList<Integer> d = new LinkedList();
        d.addLast(2);
        d.addLast(4);
        d.addLast(6);

        LinkedList<Integer> result2 = new LinkedList();
        result2.addLast(1);
        result2.addLast(2);
        result2.addLast(3);
        result2.addLast(4);
        result2.addLast(5);
        result2.addLast(6);
        assertEquals(result2, this.linkedLists.merge(c, d));

        LinkedList<Integer> e = new LinkedList();
        e.addLast(4);
        e.addLast(4);
        e.addLast(7);

        LinkedList<Integer> f = new LinkedList();
        f.addLast(1);
        f.addLast(5);
        f.addLast(6);
        LinkedList<Integer> result3 = new LinkedList();
        result3.addLast(1);
        result3.addLast(4);
        result3.addLast(4);
        result3.addLast(5);
        result3.addLast(6);
        result3.addLast(7);
        assertEquals(result3, this.linkedLists.merge(e, f));
    }

    @Test
    @DisplayName("Remove Nth to Last Node")
    void removeNth() throws Exception {
        LinkedList<Integer> a = new LinkedList();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        LinkedList<Integer> result1 = new LinkedList();
        result1.addLast(1);
        result1.addLast(2);
        assertEquals(result1, this.linkedLists.removeNth(a, 1));

        LinkedList<Integer> b = new LinkedList();
        b.addLast(1);
        b.addLast(2);
        b.addLast(3);
        LinkedList<Integer> result2 = new LinkedList();
        result2.addLast(1);
        result2.addLast(3);
        assertEquals(result2, this.linkedLists.removeNth(b, 2));

        LinkedList<Integer> result3 = new LinkedList();
        result3.addLast(2);
        result3.addLast(3);
        LinkedList<Integer> c = new LinkedList();
        c.addLast(1);
        c.addLast(2);
        c.addLast(3);
        assertEquals(result3, this.linkedLists.removeNth(c, 3));
    }

    @Test
    @DisplayName("Remove Value")
    void removeValue() throws Exception {
        LinkedList<Integer> a = new LinkedList();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        LinkedList<Integer> result1 = new LinkedList();
        result1.addLast(1);
        result1.addLast(2);
        assertEquals(result1, this.linkedLists.removeValue(a, 3));

        LinkedList<Integer> b = new LinkedList();
        b.addLast(8);
        b.addLast(1);
        b.addLast(1);
        b.addLast(4);
        b.addLast(12);
        LinkedList<Integer> result2 = new LinkedList();
        result2.addLast(8);
        result2.addLast(4);
        result2.addLast(12);
        assertEquals(result2, this.linkedLists.removeValue(b, 1));
        LinkedList<Integer> c = new LinkedList();
        c.addLast(7);
        c.addLast(12);
        c.addLast(2);
        c.addLast(9);
        LinkedList<Integer> result3 = new LinkedList();
        result3.addLast(12);
        result3.addLast(2);
        result3.addLast(9);
        assertEquals(result3, this.linkedLists.removeValue(c, 7));
    }

    @Test
    @DisplayName("Find Middle Element")
    void findMiddleElement() throws Exception {
        LinkedList<Integer> a = new LinkedList();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        assertEquals(2, this.linkedLists.findMiddleElement(a));
        LinkedList<Integer> b = new LinkedList();
        b.addLast(1);
        b.addLast(2);
        b.addLast(3);
        b.addLast(4);
        assertEquals(3, this.linkedLists.findMiddleElement(b));
        LinkedList<Integer> c = new LinkedList();
        c.addLast(1);
        assertEquals(1, this.linkedLists.findMiddleElement(c));
    }

    @Test
    @DisplayName("Contains Cycle")
    void containsCycle() throws Exception {
        LinkedList<Integer> a = new LinkedList();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        a.get(2).next = a.get(0);
        assertTrue(this.linkedLists.containsCycle(a));
        LinkedList<Integer> b = new LinkedList();
        b.addLast(1);
        b.addLast(2);
        b.addLast(3);
        assertFalse(this.linkedLists.containsCycle(b));
        LinkedList<Integer> c = new LinkedList();
        c.addLast(1);
        c.get(0).next = c.get(0);
        assertTrue(this.linkedLists.containsCycle(c));
    }
    @Test
    @DisplayName("Contains Cycle Fast Slow")
    void containsCycleTwoPointers() throws Exception {
        LinkedList<Integer> a = new LinkedList();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        a.get(2).next = a.get(0);
        assertTrue(this.linkedLists.containsCycleTwoPointers(a));
        LinkedList<Integer> b = new LinkedList();
        b.addLast(1);
        b.addLast(2);
        b.addLast(3);
        assertFalse(this.linkedLists.containsCycleTwoPointers(b));
        LinkedList<Integer> c = new LinkedList();
        c.addLast(1);
        c.get(0).next = c.get(0);
        assertTrue(this.linkedLists.containsCycleTwoPointers(c));
    }
}