package Sort_and_Search.BinarySearch;

public class LC153_Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        // mind edge case: when can we finish in advance?
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) return nums[left];

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return nums[left] < nums[right] ? nums[left] : nums[right];
    }
}
