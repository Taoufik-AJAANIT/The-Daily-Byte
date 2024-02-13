package main.java.linkedlists;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LinkedLists {
    public LinkedList merge(LinkedList<Integer> a, LinkedList<Integer> b) throws Exception {
        LinkedList result = new LinkedList();
        Node<Integer> aIterator = a.get(0);
        Node<Integer> bIterator = b.get(0);
        while (aIterator != null && bIterator != null) {
            if (aIterator.value <= bIterator.value) {
                result.addLast(aIterator.value);
                aIterator = aIterator.next;
            } else {
                result.addLast(bIterator.value);
                bIterator = bIterator.next;
            }
        }
        if (aIterator == null) {
            while (bIterator != null) {
                result.addLast(bIterator.value);
                bIterator = bIterator.next;
            }
        } else if (bIterator == null) {
            while (aIterator != null) {
                result.addLast(aIterator.value);
                aIterator = aIterator.next;
            }
        }
        return result;
    }

    public LinkedList removeNth(LinkedList input, int n) throws Exception {
        int position = 0;
        Node<Integer> iterator = input.get(0);
        Node<Integer> pointingBeforeITemToBeRemoved = null;

        while (iterator != null) {
            if (position == n) {
                pointingBeforeITemToBeRemoved = input.get(0);
                position++;
            } else if (position > n) {
                pointingBeforeITemToBeRemoved = pointingBeforeITemToBeRemoved.next;
            } else {
                position++;
            }
            iterator = iterator.next;
        }
        if (position == n && pointingBeforeITemToBeRemoved == null) {
            input.popFirst();
        } else if (pointingBeforeITemToBeRemoved == null) {
            throw new Exception();
        } else {
            pointingBeforeITemToBeRemoved.next = pointingBeforeITemToBeRemoved.next != null ? pointingBeforeITemToBeRemoved.next.next : null;
        }
        return input;
    }

    public LinkedList<Integer> removeValue(LinkedList<Integer> input, int value) throws Exception {
        Node<Integer> iterator = input.get(0);
        while (iterator != null && iterator.value == value) {
            input.popFirst();
            iterator = input.get(0);
        }
        while (iterator != null) {
            if (iterator.next != null && iterator.next.value == value) {
                iterator.next = iterator.next.next;
            } else {
                iterator = iterator.next;
            }
        }
        return input;

    }

    public int findMiddleElement(LinkedList<Integer> input) throws Exception {
        int increment = 0;
        Node<Integer> iteratorDouble = input.get(0);
        Node<Integer> iterator = input.get(0);
        while (iteratorDouble != null) {
            increment = increment + 1;
            iteratorDouble = iteratorDouble.next;
            if (increment == 2) {
                iterator = iterator.next;
                increment = 0;
            }
        }
        return iterator.value;
    }

    public boolean containsCycle(LinkedList<Integer> a) throws Exception {
        Map<Node<Integer>, Integer> map = new HashMap<>();
        Node<Integer> iterator = a.get(0);
        while (iterator != null) {
            if (map.get(iterator) != null) return true;
            map.put(iterator, 1);
            iterator = iterator.next;
        }
        return false;
    }
    public boolean containsCycleTwoPointers(LinkedList<Integer> a) throws Exception {
        Node<Integer> slow = a.get(0);
        Node<Integer> fast = a.get(0);
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}






