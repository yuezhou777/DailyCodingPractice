package Sort_and_Search.BinarySearch;
/**
 * Given an integer array sorted in ascending order, write a function to search target in nums.  If target exists, then return its index, otherwise return -1.
 * However, the array size is unknown to you. You may only access the array using an ArrayReader interface, where ArrayReader.get(k) returns the element of the array at index k (0-indexed).
 *
 * You may assume all integers in the array are less than 10000, and if you access the array out of bounds, ArrayReader.get will return 2147483647.
 */

public class LC702_Search_in_a_Sorted_Array_of_Unknown_Size {
//    public int search(ArrayReader reader, int target) {
//        //edge case
//        if (reader == null) return -1;
//        int sta = 0;
//        int end = 1;
//        while (reader.get(end) != Integer.MAX_VALUE) {
//            sta = end;
//            end *= 2;
//        }
//
//        while (sta <= end) {
//            int mid = sta + (end - sta) / 2;
//            if (reader.get(mid) != Integer.MAX_VALUE && reader.get(mid) == target) {
//                return mid;
//            } else if (reader.get(mid) != Integer.MAX_VALUE && reader.get(mid) < target) {
//                sta = mid + 1;
//            } else { //reader.get(mid) == Integer.MAX_VALUE || reader.get(mid) > target
//                end = mid - 1;
//            }
//        }
//    }
}
