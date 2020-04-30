package Sort_and_Search.Sort.SortingTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time: split: O(n)
//      merge: O(nlogn) n次遍历logn层
//Total: O(nlogn)
public class MergeSort {
    public static void main(String[] args){
        List<Integer> arr = Arrays.asList(1, 9, 8, 5, 3, 100, -2, 1, 10);
        MergeSort mergesort = new MergeSort();
        List<Integer> res = mergesort.mergeSort(arr);
        System.out.println(res);

        int[] arr2 = {1, 9, 8, 5, 3, 100, -2, 1, 10};
        int[] res2 = mergesort.mergeSort(arr2);
        System.out.println(Arrays.toString(res2));
    }

    //Space: 每次新建一个array向上return，是O(nlogn)
    public List<Integer> mergeSort(List<Integer> arr) {
        if (arr == null || arr.size() <= 1) {
            return arr;
        }
        return mergeSort(arr, 0, arr.size() - 1);
    }

    private List<Integer> mergeSort(List<Integer> arr, int left, int right) {
        //base case
        List<Integer> resList = new ArrayList<>();
        if (left == right) {
            resList.add(arr.get(left));
            return resList;
        }
        int mid = left + (right - left) / 2;
        List<Integer> leftRes = mergeSort(arr, left, mid);
        List<Integer> rightRes = mergeSort(arr, mid + 1, right);
        return merge(leftRes, rightRes);
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> list = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < left.size() && p2 < right.size()) {
            if (left.get(p1) <= right.get(p2)) {
                list.add(left.get(p1++));
            } else {
                list.add(right.get(p2++));
            }
        }

        while (p1 < left.size()) {
            list.add(left.get(p1++));
        }
        while (p2 < right.size()) {
            list.add(right.get(p2++));
        }
        return list;
    }

    //Space:O(n) 每次reuse都是复用同一块helper array
    public int[] mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int[] helper = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, helper);
        return arr;
    }

    private void mergeSort(int[] arr, int left, int right, int[] helper) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, helper);
        mergeSort(arr, mid+ 1, right, helper);
        merge(arr, left, mid, right, helper);
    }

    private void merge(int[] arr, int left, int mid, int right, int[] helper) {
        int p1 = left;
        int p2 = mid + 1;
        int curIdx = left;
        for (int i = left; i <= right; i++) {
            helper[i] = arr[i];
        }
        while (p1 <= mid && p2 <= right) {
            if (helper[p1] <= helper[p2]) {
                arr[curIdx++] = helper[p1++];
            } else {
                arr[curIdx++] = helper[p2++];
            }
        }
        while (p1 <= mid) {
            arr[curIdx++] = helper[p1++];
        }
        while (p2 <= right) {
            arr[curIdx++] = helper[p2++];
        }
    }
}
