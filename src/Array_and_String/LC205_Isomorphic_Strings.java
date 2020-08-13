package Array_and_String;

public class LC205_Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] dic = new int[256];
        int[] arr = new int[256];
        for (int i = 0; i < s.length(); i++) {
            int s_idx = (int)s.charAt(i);
            int t_idx = (int)t.charAt(i);
            if (dic[s_idx] != 0) {
                if (dic[s_idx] != t_idx) {
                    return false;
                }
            } else {
                if (arr[t_idx] == 0) {
                    dic[s_idx] = t_idx;
                    arr[t_idx] = 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /*
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (!map.containsKey(sc)) {
                if (!set.contains(tc)) {
                    map.put(sc, tc);
                    set.add(tc);
                } else {
                    return false;
                }
            } else {
                if (map.get(sc) != tc) {
                    return false;
                }
            }
        }

        return true;
    }
    */
}
