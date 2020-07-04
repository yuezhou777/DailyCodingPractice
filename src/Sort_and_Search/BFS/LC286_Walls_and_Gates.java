package Sort_and_Search.BFS;

import java.util.LinkedList;
import java.util.Queue;

//O(m*n)
//O(m*n)
public class LC286_Walls_and_Gates {
    public static final int INF = Integer.MAX_VALUE;
    public static final int OBS = -1;
    public static final int GATE = 0;
    public static final int[][] DIRECTIONS = new int[][] {
            {0, 1},
            {-1, 0},
            {0, -1},
            {1, 0}
    };

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        int row = rooms.length;
        int col = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == GATE) {
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
                if (!valid(rooms, newRow, newCol)) continue;
                rooms[newRow][newCol] = rooms[curRow][curCol] + 1;
                queue.offer(new int[] {newRow, newCol});
            }
        }
    }

    private boolean valid(int[][] rooms, int row, int col) {
        if (row < 0 || row >= rooms.length || col < 0 ||
                col >= rooms[0].length || rooms[row][col] != INF) {
            return false;
        }
        return true;
    }
}
