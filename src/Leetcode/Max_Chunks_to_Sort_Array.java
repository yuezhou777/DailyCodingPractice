package Leetcode;

import java.util.Arrays;

public class Max_Chunks_to_Sort_Array { //Like 769
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        int res = 0;
        int diff = 0;
        for (int i = 0; i < arr.length; i++) {
            diff += (arr[i] - sorted[i]);
            if (diff == 0) {
                res ++;
            }
        }

        return res;
    }
}
