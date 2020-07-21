package Sort_and_Search.DFS;

import java.util.ArrayList;
import java.util.List;

public class LC22_Generate_Parentheses {
    /*
    delta = *(l) - *(r)
        at the end, delta == 0;
        in the middle, delta >= 0;
        当多种括号对应匹配时不适用

             {}
         (        )  <-这一支可以剪了
     ((   ()   )(   ))    + prune ：左括号只能在<n个时加，右括号只能在右括号<左括号时加

     => 答案出在层数2n时 -> left so far + right so far == n

*/
    public List<String> generateParenthesis(int n) {
        if (n < 1) return null;
        List<String> res = new ArrayList<>();
        dfs(res, n, 0, 0, new StringBuilder());
        return res;
    }

    private void dfs(List<String> res, int n, int l, int r, StringBuilder sb) {
        //success
        if (l + r == 2 * n && l == r) {
            res.add(sb.toString());
            return;
        }
        //fail
        if (l + r == 2 * n) return;

        int len = sb.length();
        if (l < n) {
            sb.append('(');
            dfs(res, n, l + 1, r, sb);
            sb.setLength(len);
            //sb.deleteCharAt(sb.length() - 1);
        }

        if (r < l) {
            sb.append(')');
            dfs(res, n, l, r + 1, sb);
            sb.setLength(len);
            //sb.deleteCharAt(sb.length() - 1);
        }
    }
}
