package DPII;

public class LC221_Maximal_Square {
    public static int maximalSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;

        for (int i = 0; i < row; i++) {
            max = Math.max(max, matrix[i][0]);
        }
        for (int i = 0; i < col; i++) {
            max = Math.max(max, matrix[0][i]);
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]) + 1;
                    max = Math.max(max, matrix[i][j]);
                }
            }
        }

        return max * max;
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;

        if (matrix[0][0] == '1') {
            dp[0][0] = 1;
            max = 1;
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
            max = Math.max(dp[i][0], max);
        }
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
            max = Math.max(dp[0][i], max);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max * max;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1,0,1,0,0},
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,0,0,1,0}
        };
        System.out.println(maximalSquare(matrix1));

        int[][] matrix2 = {
                {1,0,1,0,0},
        };
        System.out.println(maximalSquare(matrix2));
    }
}
