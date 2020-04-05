package Array_and_String;

public class LC48_Rotate_Image {
    //S1: By Place
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int len = matrix.length;
        helper(matrix, 0, len);
    }

    private void helper(int[][] matrix, int start, int size) {
        if (size <= 1) return;

        for (int i = 0; i < size - 1; i++) {
            int temp = matrix[start][start + i];
            matrix[start][start + i] = matrix[start + size - 1 - i][start];
            matrix[start + size - 1 - i][start] = matrix[start + size - 1][start + size - 1 - i];
            matrix[start + size - 1][start + size - 1 - i] = matrix[start + i][start + size - 1];
            matrix[start + i][start + size - 1] = temp;
        }

        helper(matrix, start + 1, size - 2);
    }


    //S2: Digonal + Vertical Flip
    public void rotate2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int len = matrix.length;
        for (int i = 0; i < len; i++) { //Digonal
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < len; i++) { //Vertical
            for (int j = 0; j < len / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j - 1];
                matrix[i][len - j - 1] = temp;
            }
        }
    }
}

class Other_Rotate {

    public static void counterDiagonal(int[][] matrix) { //   /
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][len - i - 1];
                matrix[len - j - 1][len - i - 1] = temp;
            }
        }
    }

    public static void horizontal(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - i - 1][j];
                matrix[len - i - 1][j] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,  2,  3,  4,  5},
                {6,  7,  8,  9,  10},
                {11, 12, 13, 14, 15} ,
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        counterDiagonal(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
