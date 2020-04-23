package BinarySearch;

//Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
public class LC162_Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid - 1] < nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[left] < nums[right] ? right : left;
    }
}
