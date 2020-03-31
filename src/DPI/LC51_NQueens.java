package DPI;

import java.util.ArrayList;
import java.util.List;

/*
    Input: 4
    Output: [
     [".Q..",  // Solution 1
      "...Q",
      "Q...",
      "..Q."],

     ["..Q.",  // Solution 2
      "Q...",
      "...Q",
      ".Q.."]
    ]

    n = 4
    queens[] : [1,3,0,2]

    time: O(n^n)
    space: O(n)
*/
public class LC51_NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) return res;
        helper(res, new int[n], 0);
        return res;
    }

    public void helper(List<List<String>> res, int[] queens, int level) {
        if (level == queens.length) { //null层
            addSolution(res, queens);
            return; // 记住
        }
        for (int i = 0; i < queens.length; i++) {
            queens[level] = i;
            if (isValid(queens,level)) {
                helper(res, queens, level + 1);
            }
        }
    }
    public boolean isValid(int[] queens, int level) {
        for (int i = 0; i < level; i++) {
            if (queens[i] == queens[level]) {
                return false;
            } else if (Math.abs(queens[level] - queens[i]) == Math.abs(i - level)) {
                return false;
            }
        }

        return true;
    }

    public void addSolution(List<List<String>> res, int[] queens) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0;j < queens.length; j++) {
                if (queens[i] == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
    }
}
