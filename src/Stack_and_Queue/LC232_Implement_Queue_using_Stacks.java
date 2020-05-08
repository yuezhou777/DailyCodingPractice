package Stack_and_Queue;

import java.util.Stack;

public class LC232_Implement_Queue_using_Stacks {
    // Implement the following operations of a queue using stacks.
}

class MyQueue <T> { //Remember: announce generic in the class signature

    private Stack<T> stackIn;
    private Stack<T> stackOut;
    private int size;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
        size = 0;
    }

    /** Push element x to the back of queue. */
    public void offer(T val) { // int val
        stackIn.push(val); //Boxing
        size++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public T poll() {
        move();
        if (stackOut.isEmpty()) {
            return null;
        } else {
            size--;
            return stackOut.pop();
        }
    }

    /** Get the front element. */
    public T peek() {
        move();
        return stackOut.isEmpty() ? null : stackOut.peek();
    }

    // 因为poll和peek大部分操作一样，所以可以用helper()单独写出来，而且用private
    private void move() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return size == 0;
    }
}
