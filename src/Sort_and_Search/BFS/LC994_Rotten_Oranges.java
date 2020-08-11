package Sort_and_Search.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LC994_Rotten_Oranges {
    class Solution {
        //思路; 先找到烂橘子的数量，数量为橘子总数或为0则返回0
        //     把烂橘子都入列，进行BFS
        //     BFS - 层级遍历，每一层计算一次时间
        public int orangesRotting(int[][] grid) {
            int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
            Queue<Point> queue = new LinkedList<>();
            int total = 0, rotNum = 0, time = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1 || grid[i][j] == 2) {
                        total++;
                    }
                    if (grid[i][j] == 2) {
                        queue.offer(new Point(i,j));
                    }
                }
            }
            if (total == 0) return 0;

            while (!queue.isEmpty() && rotNum < total) {
                int size = queue.size();
                rotNum += size;
                if (rotNum == total) {
                    return time;
                }
                for (int i = 0; i < size; i++) {
                    Point cur = queue.poll();
                    for (int[] direction : directions) {
                        int newX = cur.x + direction[0];
                        int newY = cur.y + direction[1];
                        if (isValid(grid, newX, newY)) {
                            queue.offer(new Point(newX, newY));
                            grid[newX][newY] = 2;
                        }
                    }
                }
                time++;
            }

            return -1;
        }

        public boolean isValid (int[][] grid, int x, int y) {
            return (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1);
        }
    }

    class Point {
        int x;
        int y;
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
