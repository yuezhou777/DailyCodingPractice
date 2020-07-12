package Stack_and_Queue;

import java.util.Stack;

public class LC20_Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || stack.peek() != c) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
