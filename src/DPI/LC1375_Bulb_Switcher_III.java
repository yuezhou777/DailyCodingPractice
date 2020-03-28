package DPI;

public class LC1375_Bulb_Switcher_III {
    public int numTimesAllBlue(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int res = 0;
        int right = 0;
        for (int i = 0; i < arr.length; i++) {
            right = Math.max(right, arr[i]);
            if (i + 1 == right) {
                res++;
            }
        }
        return res;
    }
}
//   2,1,3,5,4
// i 4
// arr[i] 4
// right 5
// res 3

// 1 2 3 4 5
// 0 1 2 3 4
