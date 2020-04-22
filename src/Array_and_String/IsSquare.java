package Array_and_String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsSquare {
    public static boolean isSquare (int[] nums) {
        if (nums == null || nums.length <= 3) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int edge = 0;
        for (int num : nums) {
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (sum % 4 != 0) {
            return false;
        } else {
            edge = sum / 4;
        }

        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            int curSum = edge;
            for (int j = nums.length - 1; j >= 0; j--) {
                if (map.containsKey(nums[j]) && nums[j] <= curSum) {
                    curSum -= nums[j];
                    if (map.get(nums[j]) == 1) {
                        map.remove(nums[j]);
                    } else {
                        map.put(nums[j], map.get(nums[j]) - 1);
                    }
                }
            }
            if (curSum != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2};
        int[] arr2 = {3,3,3,3,4};
        System.out.println(isSquare(arr));
        System.out.println(isSquare(arr2));
    }

}
