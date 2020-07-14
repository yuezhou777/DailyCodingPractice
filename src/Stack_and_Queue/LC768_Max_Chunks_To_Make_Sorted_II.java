package Stack_and_Queue;

import java.util.Stack;

public class LC768_Max_Chunks_To_Make_Sorted_II {
    /*
    对于整个数组的排序块，其 headhead 大小是从左到右递增的。
    例如：数组 [1,2,1,3,4,7,5,6][1,2,1,3,4,7,5,6]
    最多可划分为 [1|2,1|3|4|7,5,6][1∣2,1∣3∣4∣7,5,6] ，headhead 为 [1,2,3,4,7][1,2,3,4,7]。
    因此，若给数组尾部加入一个随机正整数 nn ，尾部的排序块更容易被合并（最先满足 num < headnum<head 。
    当 nn 值较小时（ << 前面多个排序块的 headhead ），则需按尾部到首部的顺序合并多个排序块。
    这种先入（首部到尾部添加排序块）后出（尾部到首部判断并合并排序块）的特性，让我们联想到使用 栈 保存排序块最大值 headhead。
    在遍历过程中，通过维护栈的 headhead 序列，实现排序块的动态更新。
*/
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || arr[i] >= stack.peek()) {
                stack.push(arr[i]);
            } else {
                int temp = stack.pop();
                while (!stack.isEmpty() && arr[i] < stack.peek()) {
                    stack.pop();
                }
                stack.push(temp);
            }
        }

        return stack.size();
    }
}
