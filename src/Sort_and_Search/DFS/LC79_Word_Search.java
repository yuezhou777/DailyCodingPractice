package Sort_and_Search.DFS;

public class LC79_Word_Search {
    //without visited arr[][]
    int row, col;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return false;
        row = board.length;
        col = board[0].length;
        for (int i = 0; i< row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int idx, int i, int j) {
        if (idx == word.length()) return true;
        if (i < 0 || i >= row || j < 0 || j >= col) return false;
        if (board[i][j] == word.charAt(idx++)) {
            char temp = board[i][j];
            board[i][j] = '#';
            boolean res = dfs(board, word, idx, i + 1, j) || dfs(board, word, idx, i, j + 1)
                    || dfs(board, word, idx, i - 1, j) || dfs(board, word, idx, i, j - 1);
            board[i][j] = temp;
            return res;
        }
        return false;
    }

    //with visited arr[][]
    public static int[][] DIRECTIONS = {{1, 0},{0, -1},{-1, 0},{0, 1}};
    public boolean exist2(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return false;
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i< row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, word, visited, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int idx, int i, int j) {
        //success
        if (idx == word.length()) return true;
        //fail
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || word.charAt(idx) != board[i][j] || visited[i][j]) return false;

        visited[i][j] = true;
        idx++;
        boolean res = false;
        for (int[] direction : DIRECTIONS) {
            int x = i + direction[0];
            int y = j + direction[1];
            res = dfs(board, word, visited, idx, x, y);
            if (res) {
                break;
            }
        }
        visited[i][j] = false;
        return res;
    }
}
