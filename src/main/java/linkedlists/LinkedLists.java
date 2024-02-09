package main.java.linkedlists;

public class LinkedLists {
    public LinkedList merge(LinkedList<Integer> a, LinkedList<Integer> b) {
        try {
            LinkedList result = new LinkedList();
            Node<Integer> aIterator = a.get(0);
            Node<Integer> bIterator = b.get(0);
            while (aIterator != null && bIterator != null) {
                if (aIterator.value <= bIterator.value) {
                    result.addLast(aIterator.value);
                    aIterator = aIterator.next;
                }else {
                    result.addLast(bIterator.value);
                    bIterator = bIterator.next;
                }
            }
            if (aIterator == null) {
                while (bIterator != null){
                    result.addLast(bIterator.value);
                    bIterator = bIterator.next;
                }
            } else if (bIterator == null) {
                while (aIterator != null){
                    result.addLast(aIterator.value);
                    aIterator = aIterator.next;
                }
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
