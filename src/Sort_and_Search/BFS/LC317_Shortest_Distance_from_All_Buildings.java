package Sort_and_Search.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LC317_Shortest_Distance_from_All_Buildings {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int row = grid.length; int col = grid[0].length;
        int[][] cost = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, cost, i, j);
                }
            }
        }
        //update minimum distance
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && cost[i][j] != 0) {
                    distance = Math.min(distance, cost[i][j]);
                }
            }
        }

        return distance == Integer.MAX_VALUE ? -1 : distance;
    }

    private void bfs(int[][] grid, int[][] cost, int i, int j) {
        int[][] directions = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        int row = grid.length; int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        //bfs
        int minDist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                cost[cur[0]][cur[1]] += minDist;
                for (int[] direction : directions) {
                    int newRow = cur[0] + direction[0];
                    int newCol = cur[1] + direction[1];
                    if (isValid(grid, visited, newRow, newCol)) {
                        queue.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            minDist++;
        }
        //deal with edge case: surrending 0 with all 2s
        for (int idxI = 0; idxI < row; idxI++) {
            for (int idxJ = 0; idxJ < col; idxJ++) {
                if (grid[idxI][idxJ] == 0 && !visited[idxI][idxJ]) {
                    grid[idxI][idxJ] = 2;
                }
            }
        }
    }

    private boolean isValid(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
                grid[i][j] == 1 || grid[i][j] == 2 || visited[i][j] == true) {
            return false;
        }
        return true;
    }
}
