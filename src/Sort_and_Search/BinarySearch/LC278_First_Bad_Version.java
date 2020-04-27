package Sort_and_Search.BinarySearch;

public class LC278_First_Bad_Version {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (isBadVersion(start) == false) {
            return end;
        } else {
            return start;
        }
    }

    boolean isBadVersion(int x){
        return false;
    }
}

