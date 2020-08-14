package Array_and_String.Spiral_Rotate_Matrix;

import java.util.ArrayList;
import java.util.List;

public class LC54_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            for (int i = ++top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (top > bottom) break;
            for (int i = --right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            if (right < left) break;
            for (int i = --bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }

        return res;
    }
}
