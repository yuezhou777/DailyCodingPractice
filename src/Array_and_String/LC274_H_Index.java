package Array_and_String;

public class LC274_H_Index {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] bucket = new int[len + 1];
        for (int n : citations) {
            if (n >= len) {
                bucket[len]++;
            } else {
                bucket[n]++;
            }
        }

        int res = 0;
        for (int i = len; i >= 0; i--) {
            res += bucket[i];
            if (res >= i) {
                return i;
            }
        }

        return 0;
    }
}
