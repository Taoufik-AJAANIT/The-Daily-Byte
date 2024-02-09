package main.java.linkedlists;

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
}






