package DPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC119_Pascals_Triangle_II {
        /*
    1
    1 1
    1 2 1
    1 3 3 1
    1 4 6 4 1
    */

    //1 3 1 0
    public List<Integer> getRow2(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i; j > 0; j--) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return Arrays.asList(dp);
    }

    //1 3 1   a=1 b=2
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int a = 1;
        int b = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 1; j < i + 1; j++) {
                if (j == i) {
                    res.add(1);
                } else {
                    b = res.get(j);
                    res.set(j, a + b);
                    a = b;
                }
            }
        }
        return res;
    }
}
