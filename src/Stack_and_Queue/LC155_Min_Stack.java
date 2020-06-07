package Stack_and_Queue;

import java.util.Stack;

public class LC155_Min_Stack {
    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    //  正常的stack和专门存储最小值的minStack

    public  LC155_Min_Stack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(!minStack.isEmpty()) {
            int min = minStack.peek();
            if(x <= min) {
                minStack.push(x);
            }
        }else {
            minStack.push(x);
        }
    }

    public void pop() {
        int x = stack.pop();
        if(x == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
