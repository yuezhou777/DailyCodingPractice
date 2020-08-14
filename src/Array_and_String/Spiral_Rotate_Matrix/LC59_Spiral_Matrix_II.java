package Array_and_String.Spiral_Rotate_Matrix;

public class LC59_Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return null;
        int[][] res = new int[3][4];
        int left = 0; int right = res[0].length - 1;
        int top = 0; int bottom = res.length - 1;
        int num = 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            for (int i = ++top; i <= bottom; i++) {
                res[i][right] = num++;
            }
            if (top > bottom) break;
            for (int i = --right; i >= left; i--) {
                res[bottom][i] = num++;
            }
            if (left > right) break;
            for (int i = --bottom; i >= top; i--) {
                res[i][left] = num++;
            }
            left++;
        }

        return res;
    }
}
