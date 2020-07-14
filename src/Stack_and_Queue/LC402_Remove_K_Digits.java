package Stack_and_Queue;

import java.util.Stack;

public class LC402_Remove_K_Digits {
    // monotone stack
    // https://www.cnblogs.com/grandyang/p/8887985.html
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && c < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }

        //post processing
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.setLength(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}
