package Sort_and_Search.BinarySearch;
/*
        Input: nums = [2,5,6,0,0,1,2], target = 3
        Output: false
        Follow up:

        This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
        Would this affect the run-time complexity? How and why?

        The only difference is the duplicated case if we have arr[left] == arr[mid] or arr[right] = arr[mid]
        Just move the left and right correspondingly, The rest logic is the same as Rotated Sorted Array.

        __/ _     -- /--
        l   m      m   r

        The time complexity here is O(n) for the worst case, where all the elements are duplicate
*/
public class LC81_Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] arr, int target) {
        if (arr == null || arr.length == 0) return false;

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return true;
            if (arr[left] == target) return true;
            if (arr[right] == target) return true;

            if (arr[left] == arr[mid]) {
                left++;
            } else if (arr[right] == arr[mid]) {
                right--;
            } else if (arr[left] < arr[mid]) {
                if (arr[left] < target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (arr[mid] < target && target < arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}
