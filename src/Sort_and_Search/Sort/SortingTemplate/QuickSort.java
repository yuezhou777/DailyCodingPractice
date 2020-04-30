package Sort_and_Search.Sort.SortingTemplate;

import java.util.Arrays;
import java.util.Random;

//time complexity
//O(nlgn) --> O(n^2)
//space complexity
//O(lgn) --> O(n);
public class QuickSort{
    public static void main(String[] args){
        int[] arr = new int[]{1, 9, 8, 5, 3, 100, -2, 1, 10};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private Random random = new Random();

    public int[] quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int left = 0;
        int right = arr.length - 1;
        int pivotIndex = partition(arr, left, right);//找出第一层的pivot index
        //分组各自递归寻找pivot index
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);
        return arr;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;//base case
        int pivotIndex = partition(arr, left, right);//找出第一层的pivot index
        //分组各自递归寻找pivot index
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);
    }

    //分区(随机选一个pivot并找到它在数组中正确的index)
    private int partition(int[] arr, int left, int right) {
        //1.防止over flow 2.防止遇到排好序的数组时产生worse case(最差情况)
        int pivotIndex = left + random.nextInt(right - left + 1);
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, right);//将pivot放到最右边，便于其他元素做大小比较
        pivotIndex = right;
        int l = left, r = right - 1;
        while (l <= r) {
            if (arr[l] < pivot) {
                l++;
            } else if (arr[r] >= pivot) {
                r--;
            } else {//arr[l]>=pivot&&arr[r]<pivot
                swap(arr, l, r);
                l++;
                r--;
            }
        }
        swap(arr, l, pivotIndex);//将pivot换到正确的位置
        return l;
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
