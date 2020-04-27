package Sort_and_Search.BinarySearch;

//Input: citations = [0,1,3,5,6]
//Output: 3
public class LC275_HIndex_II {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;

        int len = citations.length;
        int left = 0;
        int right = len - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] == len - mid) {
                return len - mid;
            } else if (citations[mid] < len - mid) {
                left = mid;
            } else {
                right = mid;
            }
        }

        // once jump out, always check start & end
        if (citations[left] >= len - left) return len - left;
        if (citations[right] >= len - right) return len - right;
        return 0;
    }
}
