package Sort_and_Search.BFS;

import java.util.*;

public class LC417_Pacific_Atlantic_Water_Flow {
    private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] self, boolean[][] another, List<List<Integer>> res) {
        int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            //record answer
            if (another[curRow][curCol]) {
                res.add(Arrays.asList(curRow, curCol));
            }
            for (int[] dir : dirs) {
                int newRow = cur[0] + dir[0];
                int newCol = cur[1] + dir[1];
                if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length
                        && matrix[newRow][newCol] >= matrix[curRow][curCol] && !self[newRow][newCol]) {
                    queue.offer(new int[]{newRow, newCol});
                    self[newRow][newCol] = true;
                }
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return new ArrayList<>();
        int row = matrix.length; int col = matrix[0].length;
        List<List<Integer>> res = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        //for each point on pacific, find if it can flow upward using bfs
        for (int i = 0; i < row; i++) {
            queue.offer(new int[]{i, 0});
            pacific[i][0] = true;
        }
        for (int j = 1; j < col; j++) {
            queue.offer(new int[]{0, j});
            pacific[0][j] = true;
        }
        bfs(matrix, queue, pacific, atlantic, res);
        //for each point on pacific, find if it can flow upward using bfs
        for (int i = 0; i < row; i++) {
            queue.offer(new int[]{i, col - 1});
            atlantic[i][col - 1] = true;
        }
        for (int j = 0; j < col - 1; j++) {
            queue.offer(new int[]{row - 1, j});
            atlantic[row - 1][j] = true;
        }
        bfs(matrix, queue, atlantic, pacific, res);

        return res;
    }
}
