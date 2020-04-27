package Sort_and_Search.BinarySearch;
/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

        Integers in each row are sorted from sta to end.
        The first integer of each row is greater than the last integer of the previous row.
        Example 1:

        Input:
        matrix = [
        [1,   3,  5,  7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
        ]
        target = 3
        Output: true

 */
public class LC74_Search_a_2D_Matrix {
    //S1: primitive 2 times binary search (1st largest smaller=)
    //logm + logn → 引申 UnknownSize Position of Target, 一维劈成m个n size二维数组, 先把每个m[0]拿出来，确定在哪个chunk里， O(max(m, n))

    //S2:
    //O(logmn)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;

        int row = matrix.length;
        int col = matrix[0].length;
        int sta = 0;
        int end = row * col - 1;
        while (sta <= end) {
            int mid = sta + (end - sta) / 2;
            int cur = matrix[mid / col][mid % col];
            if (cur == target) {
                return true;
            } else if (cur < target) {
                sta = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}
