package Sort_and_Search.DFS;

import java.util.ArrayList;
import java.util.List;

public class LC320_Generalized_Abbreviation {
    // "a" -> "a1"
    // "a" -> "a",1 -> "a",2 -> "a2x",0 -> "a2x",1
    //time: O(2^n) 树上的DFS
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        dfs(word, res, new StringBuilder(), 0, 0);
        return res;
    }
    private void dfs(String word, List<String>res, StringBuilder sb, int idx, int count) {
        int len = sb.length();
        if (idx == word.length()) {
            if (count != 0) {
                sb.append(count);
                res.add(sb.toString());
                sb.setLength(len);
            } else {
                res.add(sb.toString());
            }
            return;
        }
        //add count: regard this char as number, and count + 1
        dfs(word, res, sb, idx + 1, count + 1);
        //add word: keep the original char
        if (count != 0) {
            sb.append(count);
        }
        sb.append(word.charAt(idx));
        dfs(word, res, sb, idx + 1, 0);
        sb.setLength(len);
    }
}
