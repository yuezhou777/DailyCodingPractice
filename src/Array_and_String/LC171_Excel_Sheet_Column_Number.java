package Array_and_String;

public class LC171_Excel_Sheet_Column_Number {
    //LC171
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) return -1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'A' + 1;
            res = res * 26 + cur;
        }
        return res;
    }
}
