package Others;

import java.util.HashSet;
import java.util.Set;

public class Two_Sum_Unique_Pairs {
    /**
     * Given an int array nums and an int target, find how many unique pairs in the array such that their sum is equal to target. Return the number of pairs.
     *
     * Example 1:
     *
     * Input: nums = [1, 1, 2, 45, 46, 46], target = 47
     * Output: 2
     * Explanation:
     * 1 + 46 = 47
     * 2 + 45 = 47
     * Example 2:
     *
     * Input: nums = [1, 1], target = 2
     * Output: 1
     * Explanation:
     * 1 + 1 = 2
     * Example 3:
     *
     * Input: nums = [1, 5, 1, 5], target = 6
     * Output: 1
     * Explanation:
     * [1, 5] and [5, 1] are considered the same.
     * Related problems:
     * */
    public static int uniquePairs(int[] nums, int target){
        //cc
        Set<Integer> set = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        int res = 0;
        for (int n : nums) {
            if (set.contains(target - n) && !seen.contains(n)) {
                res++;
                seen.add(n);
                seen.add(target - n);
            } else if (!set.contains(n)) {
                set.add(n);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{1, 1, 2, 45, 46, 46};
        int target1 = 47;
        int[] test2 = new int[]{5, 5, 1, 5};
        int result = uniquePairs(test1,47);
        System.out.print(result);
    }
}
