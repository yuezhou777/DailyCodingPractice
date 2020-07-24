package Sort_and_Search.DFS;

import java.util.ArrayList;
import java.util.List;

public class LC282_Expression_Add_Operators {
    //参考ip address那道题，每1 12 123为一段进行分隔做dfs
    //分隔时有3个叉：+ - *
    //再参考calculator实现* 优先级高的算法，具体做法是不用栈的one-pass操作：
    //2 + 3 - 4 * 5
    //(2 + 3 - 4) + (-4) * 5
    //sum - lastVal + lastVal * curVal
    /*
    for (拼数) {
        if (拼 is valid) {
            dfs(..)
        }
    }
    */
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num.equals("2147483648")) return res;
        dfs(num, target, res, new StringBuilder(), 0, 0, 0);
        return res;
    }

    private void dfs(String s, int target, List<String> res, StringBuilder sb, int start, int sum, int lastVal) {
        if (start == s.length() && sum == target) {
            res.add(sb.toString());
            return;
        }
        if (start == s.length()) return;
        int val = 0;
        for (int i = start; i < s.length(); i++) {
            int len = sb.length();
            val = val * 10 + (s.charAt(i) - '0');
            if (len > 0) {
                //+
                sb.append("+" + val);
                dfs(s, target, res, sb, i + 1, sum + val, val);
                sb.setLength(len);
                //-
                sb.append("-" + val);
                dfs(s, target, res, sb, i + 1, sum - val, -val);
                sb.setLength(len);
                //*
                sb.append("*" + val);
                dfs(s, target, res, sb, i + 1, sum - lastVal + lastVal * val, lastVal * val);
                sb.setLength(len);
            } else { //len == 0
                sb.append(val);
                dfs(s, target, res, sb, i + 1, sum + val, val);
                sb.setLength(len);
            }
            if (val == 0) break; //s:"02"
        }
    }
}
