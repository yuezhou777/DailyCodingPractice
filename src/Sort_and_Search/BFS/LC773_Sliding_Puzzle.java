package Sort_and_Search.BFS;

import java.util.*;

//思路：BFS，用String储存每一步状态，在更新状态时转化为数组再转化为String给他怼回去
//这样不仅解决2X3,可以扩展到5x5
class LC773_Sliding_Puzzle {
    public int slidingPuzzle(int[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return -1;
        int row = board.length;
        int col = board[0].length;
        String start = boardToString(board, row, col);
        String goal = boardToString(row, col);

        //Begin BFS
        int steps = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(goal)) {
                    return steps;
                }
                for (String state : getNewState(cur, row, col)) {
                    if (!visited.contains(state)) {
                        visited.add(state);
                        queue.offer(state);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private List<String> getNewState(String cur, int row, int col) {
        List<String> res = new ArrayList<>();
        String[] curState = cur.substring(0, cur.length() - 1).split(",");
//        for (String str : curState) {
//            System.out.println("当前状态" + str);
//        }
        int index = 0;
        for (int i = 0; i < curState.length; i++) {
            if (curState[i].equals("0")) {
                index = i;
            }
        }

        int curRow = index / col;
        int curCol = index % col;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] direction : directions) {
            int newRow = curRow + direction[0];
            int newCol = curCol + direction[1];
            if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col) {
                int zeroIndex = newRow * col + newCol;
                String[] temp = curState.clone();
                temp[index] = temp[zeroIndex];
                temp[zeroIndex] = "0";
                StringBuilder sb = new StringBuilder();
                for (String str : temp) {
                    sb.append(str).append(",");
                }
                //System.out.println("新String" + sb.toString());
                res.add(sb.toString());
            }
        }
        return res;
    }

    private String boardToString(int[][] board, int row, int col) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sb.append(board[i][j]).append(",");
            }
        }
        return sb.toString();
    }

    private String boardToString(int row, int col) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < row * col; i++) {
            sb.append(i).append(",");
        }
        sb.append(0).append(",");
        return sb.toString();
    }
}