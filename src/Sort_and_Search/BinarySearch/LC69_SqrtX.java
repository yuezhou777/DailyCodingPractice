package Sort_and_Search.BinarySearch;

public class LC69_SqrtX {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x < 4) return 1;

        int left = 2;
        int right = x / 2;
        long multi = 0;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            multi = (long) mid * mid;
            if (multi == x) {
                return mid;
            } else if (multi < x) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
