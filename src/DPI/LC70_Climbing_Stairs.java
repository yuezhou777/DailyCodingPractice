package DPI;

public class LC70_Climbing_Stairs {
    //fib: 2 pointers
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int res = 0;
        int a = 1;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

    //dp
    /*
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    */

    //memo + dfs
    /*
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return dfs(n, memo);
    }

    private int dfs(int n, int[] memo) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (memo[n] > 0) return memo[n];
        memo[n] = dfs(n - 1, memo) + dfs(n - 2, memo);
        return memo[n];
    }
    */
}
