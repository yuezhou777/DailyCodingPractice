package Array_and_String;

import java.util.ArrayList;
import java.util.List;

//参考448
//O(n),O(1)
public class LC442_Find_All_Duplicates_in_an_Array {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur - 1] < 0) {
                res.add(cur);
            }
            nums[cur - 1] *= -1;
        }
        return res;
    }
}
