package Sort_and_Search.DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC301_Remove_Invalid_Parentheses {
    /*
open = *(l) - *(r)
    at the end, open should == 0;
    in the middle, open should >= 0;
    当多种括号对应匹配时不适用
*/
    public List<String> removeInvalidParentheses(String s) {
        //List<String> res = new ArrayList<>();
        Set<String> res = new HashSet<>(); //"()())()" idx = 3,4位置去掉后结果都是"()()()"所以要去重
        if (s == null || s.length() == 0) {
            res.add("");
            new ArrayList<String>(res);
        }

        int rmL = 0; //check how many ( and ) we need to remove
        int rmR = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                rmL++;
            } else if (c == ')') {
                if (rmL > 0) {
                    rmL--;
                } else {
                    rmR++;
                }
            }
        }
        dfs(res, chars, 0, rmL, rmR, 0, new StringBuilder());
        return new ArrayList<String>(res);
    }

    private void dfs(Set<String> res, char[] s, int idx, int rmL, int rmR, int open, StringBuilder sb) {
        if (idx == s.length && rmL == 0 && rmR == 0 && open == 0) {
            res.add(sb.toString());
            return;
        }
        if (idx == s.length || rmL < 0 || rmR < 0 || open < 0) return; //open < 0: 出现了")("这种情况

        int len = sb.length();
        char c = s[idx];
        if (c == '(') {
            //remove
            dfs(res, s, idx + 1, rmL - 1, rmR, open,  sb);
            //keep
            sb.append('(');
            dfs(res, s, idx + 1, rmL, rmR, open + 1, sb);
            sb.setLength(len);
        } else if (c == ')') {
            //remove
            dfs(res, s, idx + 1, rmL, rmR - 1, open, sb);
            //keep
            sb.append(')');
            dfs(res, s, idx + 1, rmL, rmR, open - 1, sb);
            sb.setLength(len);
        } else {
            sb.append(c);
            dfs(res, s, idx + 1, rmL, rmR, open, sb);
            sb.setLength(len);
        }
    }

    //follow up求任意一个解，可用stack
    //从左到右遍历删右括号，
    //从右往左遍历删左括号，碰见) delta+1, ( delta-1
}
