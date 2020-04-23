package Others;

public class Min_Moves_to_Obtain_String {
    public int solution(String s) {
        if (s == null || s.length() < 3) return 0;
        int res = 0;
        int count = 1;
        int i = 0;
        for (i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                res += (count / 3);
                count = 1;
            }
        }
        //i = s.length()
        if (s.charAt(i) == s.charAt(i - 1)) {
            res += (count / 3);
        }
        return res;
    }
}

//baaaaaaaaaab
//baa*aa*aa*ab
//baa*aa*aa*aab