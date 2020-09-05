package Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value.
 * Your task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible. Return a list of ids of selected elements. If no pair is possible, return an empty list.
 *
 *Example 2:
 *
 * Input:
 * a = [[1, 3], [2, 5], [3, 7], [4, 10]]
 * b = [[1, 2], [2, 3], [3, 4], [4, 5]]
 * target = 10
 *
 * Output: [[2, 4], [3, 2]]
 *
 * Explanation:
 * There are two pairs possible. Element with id = 2 from the list `a` has a value 5, and element with id = 4 from the list `b` also has a value 5.
 * Combined, they add up to 10. Similarily, element with id = 3 from `a` has a value 7, and element with id = 2 from `b` has a value 3.
 * These also add up to 10. Therefore, the optimal pairs are [2, 4] and [3, 2].
 * */
public class Optimal_Utilization {
    //at most 2 res
    /**
    private static List<List<Integer>> getTargetSumIds(int[][] a, int[][] b, int target) {
        Arrays.sort(a, (x, y) -> x[1] - y[1]);
        Arrays.sort(b, (x, y) -> x[1] - y[1]);
        //add possible solutions into heap
        PriorityQueue<Point> pq = new PriorityQueue<Point>((x, y) -> (x.sum - y.sum));
        int low = 0;
        int high = a.length - 1;
        while (low < b.length && high >= 0) {
            int sum = a[high][1] + b[low][1];
            if (sum <= target) {
                pq.offer(new Point(high, low, sum));
                low++;
            } else {
                high--;
            }
        }

        //pick top 1 or 2 solutions
        List<List<Integer>> res = new ArrayList<>();

    }

    public static void main(String[] args) {
        int[][] a1 = { { 1, 2 }, { 2, 4 }, { 3, 6 } };
        int[][] b1 = { { 1, 2 } };
        int target1 = 7;
        System.out.println("----------Expected Output: [[2, 1]]-------------");
        System.out.println(getTargetSumIds(a1, b1, target1));// Output: [[2, 1]]
        System.out.println("----------Expected Output:  [[2, 4], [3, 2]]-------------");
        int[][] a2 = { { 1, 3 }, { 2, 5 }, { 3, 7 }, { 4, 10 } };
        int[][] b2 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
        int target2 = 10;
        System.out.println(getTargetSumIds(a2, b2, target2));// Output: [[2, 4], [3, 2]]
        System.out.println("----------Expected Output: [[3, 1]]-------------");
        int[][] a3 = { { 1, 8 }, { 2, 7 }, { 3, 14 } };
        int[][] b3 = { { 1, 5 }, { 2, 10 }, { 3, 14 } };
        int target3 = 20;
        System.out.println(getTargetSumIds(a3, b3, target3));// Output: [[3, 1]]
        System.out.println("----------Expected Output: [[1, 3], [3, 2]]-------------");
        int[][] a4 = { { 1, 8 }, { 2, 15 }, { 3, 9 } };
        int[][] b4 = { { 1, 8 }, { 2, 11 }, { 3, 12 } };
        int target4 = 20;
        System.out.println(getTargetSumIds(a4, b4, target4));// Output: [[1, 3], [3, 2]]

    }
    */
}
class Point {
    int id1;
    int id2;
    int sum;
    Point(int id1, int id2, int sum){
        this.id1 = id1;
        this.id2 = id1;
        this.sum = sum;
    }
}
