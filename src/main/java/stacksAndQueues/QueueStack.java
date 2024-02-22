package main.java.stacksAndQueues;

public class QueueStack<T> {
    private Queue<T> queue;
    public QueueStack(){
        this.queue = new Queue<>();
    }
    public void push(T item) throws Exception {
        int size = queue.size;
        queue.add(item);
        for (int i = 0; i < size; i++){
            queue.add(queue.remove());
        }
    }
    public T pop(){
        return queue.remove();
    }

    public T peek(){
        return queue.peek();
    }
}
