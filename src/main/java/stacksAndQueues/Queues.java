package main.java.stacksAndQueues;

public class Queues {
    Queue<Integer> queue;
    private static int size = 3;
    private int sum;
    private int count;
    private int[] window;

    public Queues() {
        this.queue = new Queue<>();
        this.window = new int[size];

    }

    public int ping(int tmp) throws Exception {
        while (!queue.isEmpty() && tmp - queue.peek() > 3000) {
            queue.remove();
        }
        queue.add(tmp);
        return queue.size;
    }

    public int next(int val) throws Exception {
        if (this.queue.size == size) {
            int element = this.queue.remove();
            this.sum = this.sum - element;
        }
        queue.add(val);
        this.sum = this.sum + val;
        return this.sum / queue.size;
    }


    //    using circular array
    public int next1(int val) {
        int index = count % size;
        count++;
        sum = sum - window[index];
        sum = sum + val;
        window[index] = val;
        return sum / Math.min(size, count);
    }
}
