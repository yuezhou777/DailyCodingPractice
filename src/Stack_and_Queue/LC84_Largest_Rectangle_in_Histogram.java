package Stack_and_Queue;

import java.util.Stack;

public class LC84_Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i <= heights.length; i++) {
            int curHeight = i < heights.length ? heights[i] : 0;
            if (stack.isEmpty() || curHeight >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && curHeight < heights[stack.peek()]) {
                    int index = stack.pop();
                    int height = heights[index];
                    int size = 0;
                    if (stack.isEmpty()) {
                        size = i * height;
                    } else {
                        size = (i - stack.peek() - 1) * height;
                    }
                    res = Math.max(res, size);
                }
                stack.push(i);
            }
        }
        return res;
    }
}
