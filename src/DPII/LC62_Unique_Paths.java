package DPII;

import java.util.Arrays;

public class LC62_Unique_Paths {
    public int uniquePaths(int m, int n) {
        //cc
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, 1);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

}