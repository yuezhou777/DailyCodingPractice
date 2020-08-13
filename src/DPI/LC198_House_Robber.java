package DPI;

public class LC198_House_Robber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int pre = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = temp;
        }
        return cur;
    }

    /*
    Let us denote that:

    f(k) = Largest amount that you can rob from the first k houses.
    Ai = Amount of money at the ith house.

    Let us look at the case n = 1, clearly f(1) = A1.

    Now, let us look at n = 2, which f(2) = max(A1, A2).

    For n = 3, you have basically the following two options:

    Rob the third house, and add its amount to the first house's amount.

    Do not rob the third house, and stick with the maximum amount of the first two houses.

    Clearly, you would want to choose the larger of the two options at each step.

    Therefore, we could summarize the formula as following:

    f(k) = max(f(k – 2) + Ak, f(k – 1))
    */
}
