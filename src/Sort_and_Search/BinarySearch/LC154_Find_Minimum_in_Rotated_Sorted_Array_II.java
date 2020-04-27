package Sort_and_Search.BinarySearch;

public class LC154_Find_Minimum_in_Rotated_Sorted_Array_II {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) return nums[left];

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[right] == nums[mid]) {
                right--;
            } else if (nums[left] < nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return nums[left] < nums[right] ? nums[left] : nums[right];
    }
}
