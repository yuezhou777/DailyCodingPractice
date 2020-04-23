package BinarySearch;

public class LC35_Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        class Solution {
            public int searchInsert(int[] nums, int target) { //smallest larger element
                if (nums == null || nums.length == 0) return -1;
                int left = 0;
                int right = nums.length - 1;
                while (left + 1 < right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] <= target) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                }

                //if exist, should be left or right
                //if not exist, if less than left: if left > 0 , left - 1;
                //                                 if left = 0 , left
                //if not exist, if larger than right: right + 1;
                ////if not exist, if left < x < right: right
                if (nums[left] == target) return left;
                if (nums[left] > target) return left > 0 ? left - 1 : 0;
                if (nums[left] < target && target <= nums[right]) {
                    return right;
                } else {
                    return right + 1;
                }
            }
        }
    }
}
