package Sort_and_Search.BinarySearch;
/*
    This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascendin` g from top to bottom.
    Example:

    Consider the following matrix:

    [
      [1,   4,  7, 11, 15],
      [2,   5,  8, 12, 19],
      [3,   6,  9, 16, 22],
      [10, 13, 14, 17, 24],
      [18, 21, 23, 26, 30]
    ]
*/
//Time: O(m + n) : for every iteration, either row or col is decremented/incremented exactly once.
//Space: O(1)
public class LC240_Search_a_2D_Matrix_II {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }else if (matrix[row][col] < target) {
                row++;
            } else { // (matrix[row][col] > target)
                col--;
            }
        }

        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col <= matrix[0].length - 1) {
            if (matrix[row][col] == target) {
                return true;
            }else if (matrix[row][col] < target) {
                col++;
            } else { // (matrix[row][col] > target)
                row--;
            }
        }

        return false;
    }
}
