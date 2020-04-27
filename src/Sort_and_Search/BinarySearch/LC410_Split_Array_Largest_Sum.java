package Sort_and_Search.BinarySearch;

public class LC410_Split_Array_Largest_Sum {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) return -1;

        int sum = 0;
        int max = 0;
        for (int num: nums) {
            sum += num;
            if (num > max) {
                max = num;
            }
        }
        if (m == 1) return sum;

        int left = max;
        int right = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPartWithSum(nums, mid, m)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canPartWithSum(int[] nums, int target, int m) {
        int count = 1;
        int curSum = 0;
        for (int num : nums) {
            curSum += num;
            if (curSum > target) {
                count++;
                curSum = num;
                if (count > m) {
                    return false;
                }
            }
        }

        return true;
    }
}
