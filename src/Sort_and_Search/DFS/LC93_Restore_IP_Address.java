package Sort_and_Search.DFS;

import java.util.ArrayList;
import java.util.List;

public class LC93_Restore_IP_Address {
    //4 part: 每个part 长度为1-3，取值为0-255
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        dfs(s, res, new StringBuilder(), 0, 0);
        return res;
    }

    private void dfs(String s, List<String> res, StringBuilder sb, int idx, int part) {
        if (idx == s.length() && part == 4) {
            sb.setLength(sb.length() - 1); //最后进入dfs时已经在sb末尾append了一个"."
            res.add(sb.toString());
            return;
        }
        if (idx == s.length() || part > 4) return;
        for(int l = 1; l <= 3; l++) { //2 25 255
            if (idx + l > s.length()) break;
            String str = s.substring(idx, idx + l); // [idx, idx + l - 1];
            //loop(l == 1): val == 2, dfs("55255")
            //loop(l == 2): val == 25, dfs("5255")
            //loop(l == 3): val == 255, dfs("255")
            int val = Integer.valueOf(str);
            //check valid
            if (val >= 0 && val <= 255) {
                int len = sb.length();
                sb.append(val + "."); //这里必须是string"."， 如果是char'.'的话就会ascII码和int val相加
                dfs(s, res, sb, idx + l, part + 1);
                //永远记住：backtracking 成对出现
                sb.setLength(len);
            }
            if (val == 0) break; // 02. xxx这种invalid, 剪掉，这是一个很重要的技巧！
        }
    }
}
