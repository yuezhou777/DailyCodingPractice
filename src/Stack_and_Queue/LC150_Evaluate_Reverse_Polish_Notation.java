package Stack_and_Queue;

import java.util.Stack;

//O(N)
//O(N)
public class LC150_Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens) {
            if(s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }else if(s.equals("-")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 - num2);
            }else if(s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }else if(s.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 / num2);
            }else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop() ;
    }

}
