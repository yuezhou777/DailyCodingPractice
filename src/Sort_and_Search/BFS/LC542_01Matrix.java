package Sort_and_Search.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//O(m*n)
//O(2*m*n)
//优化SpaceO(m*n) 可用dp
public class LC542_01Matrix {
    public static int[][] DIRECTIONS = new int[][] {
            {1, 0},
            {0, -1},
            {-1, 0},
            {0, 1}
    };

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return null;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] distance = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            for (int[] direction : DIRECTIONS) {
                int newRow = curRow + direction[0];
                int newCol = curCol + direction[1];
                if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col
                        && matrix[newRow][newCol] == 1 && distance[newRow][newCol] == 0) {
                    queue.offer(new int[] {newRow, newCol});
                    distance[newRow][newCol] = distance[curRow][curCol] + 1;
                }
            }
        }

        return distance;
    }

    //DP
    public int[][] updateMatrix2(int[][] matrix) {
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
