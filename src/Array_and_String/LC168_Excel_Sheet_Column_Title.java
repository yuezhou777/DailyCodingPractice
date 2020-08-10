package Array_and_String;

public class LC168_Excel_Sheet_Column_Title {
    public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)(n % 26 + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}

