package main.java.stacksAndQueues;

public class QueueStack<T> {
    private Queue<T> queue;
    private Queue<T> transitionQueue;

    public QueueStack(){
        this.queue = new Queue<>();
        this.transitionQueue = new Queue<>();
    }
    public void push(T item) throws Exception {
        while (!queue.isEmpty()){
            transitionQueue.add(queue.remove());
        }
        queue.add(item);
        while (!transitionQueue.isEmpty()){
            queue.add(transitionQueue.remove());
        }
    }
    public T pop(){
        return queue.remove();
    }

    public T peek(){
        return queue.peek();
    }
}
