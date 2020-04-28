package Sort_and_Search.Sort.SortingTemplate;

public class SelectionSort {
    public void selectionSort(int[] arr, int target) {
        if (arr == null || arr.length <= 1) return;

        for (int i = 0; i < arr.length - 1; i++) { //不需要走到最后一位
            int curSmallestIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[curSmallestIndex]) {
                    curSmallestIndex = j;
                }
            }
            swap(arr, i, curSmallestIndex);
        }
    }

    private void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
