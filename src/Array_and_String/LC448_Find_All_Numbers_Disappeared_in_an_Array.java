package Array_and_String;

import java.util.ArrayList;
import java.util.List;

//参考442
//O(n),O(1)
public class LC448_Find_All_Numbers_Disappeared_in_an_Array {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur - 1] > 0) {
                nums[cur - 1] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
