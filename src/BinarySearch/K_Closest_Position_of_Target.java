package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class K_Closest_Position_of_Target {
    public int findClosest(int[] arr, int target) {
        //edge case
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid;
            } else if (arr[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }

        return Math.abs(arr[left] - target) < Math.abs(arr[right] - target) ? left : right;
    }
    //Input: [1,2,3,4,5], k=2, x=3
    //Output: [2,3]
    //clarify: 1.k 和 len关系， 2.有tie取小，3.出界
    public int[] findKClosestElement(int[] arr, int target, int K) {
        if (arr == null || arr.length < K) return null;
        int[] res = new int[K];
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid;
            } else { //arr[mid] >= target
                right = mid;
            }
        }

        for (int i = 0; i < K; i++) {
            if (right >= arr.length || left >= 0 && Math.abs(arr[left] - target) <= Math.abs(arr[right] - target)) {
                res[i] = arr[left--];
            } else {
                res[i] = arr[right++];
            }
        }

        Arrays.sort(res);
        return res;
    }
}
