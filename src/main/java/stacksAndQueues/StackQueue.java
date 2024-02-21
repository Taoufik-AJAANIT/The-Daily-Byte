package main.java.stacksAndQueues;

public class StackQueue<T> {
    private Stack<T> stack;
    private Stack<T> transitionStack;

    public StackQueue(){
        this.stack = new Stack<>();
        this.transitionStack = new Stack<>();
    }
    public void push(T item) throws Exception {
        while (!stack.isEmpty()){
            transitionStack.push(stack.pop());
        }
        stack.push(item);
        while (!transitionStack.isEmpty()){
            stack.push(transitionStack.pop());
        }
    }
    public T pop(){
        return stack.pop();
    }

    public T peek(){
        return stack.peek();
    }
}
