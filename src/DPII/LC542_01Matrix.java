package DPII;

import java.util.Arrays;

public class LC542_01Matrix {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return null;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] distance = new int[row][col];
        for (int[] dis : distance) {
            Arrays.fill(dis, row * col);
        }


        //check for left and top
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    distance[i][j] = 0;
                } else {
                    if (i > 0) {
                        distance[i][j] = Math.min(distance[i][j], distance[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][j - 1] + 1);
                    }
                }
            }
        }
        //check for bottom and right
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    distance[i][j] = 0;
                } else {
                    if (i < row - 1) {
                        distance[i][j] = Math.min(distance[i][j], distance[i + 1][j] + 1);
                    }
                    if (j < col - 1) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][j + 1] + 1);
                    }
                }
            }
        }

        return distance;
    }
}
