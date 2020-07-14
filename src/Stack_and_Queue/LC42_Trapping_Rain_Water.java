package Stack_and_Queue;

public class LC42_Trapping_Rain_Water {
    // size = size(left_Max, right_Max) - duplicates
    // monotone stack -> 2 pointers
    // https://www.cnblogs.com/grandyang/p/8887985.html
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if (leftMax <= rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }

        return res;
    }
}
