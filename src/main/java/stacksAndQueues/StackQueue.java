package main.java.stacksAndQueues;

public class StackQueue<T> {
    private Stack<T> stack;

    public StackQueue() {
        this.stack = new Stack<>();
    }

    public void push(T item) throws Exception {
        if(stack.size() == 0){
            stack.push(item);
            return ;
        }
        T latsItem = stack.pop();
        this.push(item);
        stack.push(latsItem);
    }

    public T pop() {
        return stack.pop();
    }

    public T peek(){
       return stack.peek();
    }
}
