package Others;

import java.util.HashMap;
import java.util.Map;

public class Numbers_With_Equal_Digit_Sum {
    public int solution(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int res = -1;
        Map<Integer, Integer> dict = new HashMap<>(); // DigitSum : ElementSum
        for (int i = 0; i < arr.length; i++) {
            int digitSum = DigitSum(arr[i]);
            if (!dict.containsKey(digitSum)) {
                dict.put(DigitSum(digitSum), arr[i]);
            } else {
                res = Math.max(res, dict.get(digitSum) + arr[i]);
                dict.put(digitSum, Math.max(dict.get(digitSum), arr[i]));
            }
        }
        return res;
    }

    private int DigitSum(int n) {
        n = Math.abs(n);
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}
