package Sort_and_Search.BinarySearch;

/*
    Example 1:
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4

    Example 2:
    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1

     /
    /|
   l m/
     /

     /
    /
   l  /
     /
     m
  */
public class LC33_Search_in_Rotated_Sorted_Array {
    public int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[left] == target) return left;
            if (arr[right] == target) return right;
            if (arr[left] < arr[mid]) {
                if (arr[left] < target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // arr[left] > arr[mid]
                if (arr[mid] < target && target < arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
