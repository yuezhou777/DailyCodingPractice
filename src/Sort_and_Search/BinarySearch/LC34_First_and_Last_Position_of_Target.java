package Sort_and_Search.BinarySearch;

public class LC34_First_and_Last_Position_of_Target {
    //s1: 2次bs：logn + logn = O(logn)
    //s2: 先找到1st or last position，比如l在1st, 再用r指针从l开始往右找last logn + n = O(n), lr左闭右开区间
    //    不过看情况，depends on 最大重复次数，如果最大重复次数固定，n可以看做常量
    public int[] searchRange(int[] nums, int target) {
        //edge case
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        //find first
        int[] res = new int[2];
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else { //nums[mid] >= target;
                right = mid;
            }
        }
        if (nums[left] == target) { //why check left first? 3 3 3 3 3 4 5 6
            res[0] = left;
        } else if (nums[right] == target) {
            res[0] = right;
        } else {
            res[0] = -1;
        }

        //find last
        left = 0;
        right = nums.length - 1;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[right] == target) { //why check right first?
            res[1] = right;
        } else if (nums[left] == target) {
            res[1] = left;
        } else {
            res[1] = -1;
        }

        return res;
    }
}
