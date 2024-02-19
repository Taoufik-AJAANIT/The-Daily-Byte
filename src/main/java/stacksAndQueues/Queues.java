package main.java.stacksAndQueues;

public class Queues {
    Queue<Integer> queue;

    public Queues() {
        this.queue = new Queue<>();

    }

    public int ping(int tmp) throws Exception {
        while (!queue.isEmpty() && tmp - queue.peek() > 3000) {
            queue.remove();
        }
        queue.add(tmp);
        return queue.size;
    }
}
