package Sort_and_Search.DFS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139_Word_Break {
    //1. backtracking O(2^n)
    //leetcode 用指针追踪分割子字符串的位置，把每个substring compare to dict, use hashset to optimize dict
    //TLE
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
        Set<String> wordSet = new HashSet<>(wordDict);
        return dfs(s, wordSet, 0);
    }

    private boolean dfs(String s, Set<String> wordSet, int idx) {
        if (idx == s.length()) return true;
        for (int i = idx + 1; i <= s.length(); i++) {
            if (wordSet.contains(s.substring(idx, i))) {
                if (dfs(s, wordSet, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    //2. backtracking + mem O(n)
    //mem[idx] = [idx, len) => t/f
    public boolean wordBreak2(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
        Set<String> wordSet = new HashSet<>(wordDict);
        return dfs(s, wordSet, 0, new Boolean[s.length()]);
    }

    private boolean dfs(String s, Set<String> wordSet, int idx, Boolean[] mem) {
        if (idx == s.length()) return true;
        if (mem[idx] != null) return mem[idx];
        for (int i = idx + 1; i <= s.length(); i++) {
            if (wordSet.contains(s.substring(idx, i))) {
                if (dfs(s, wordSet, i, mem)) {
                    mem[idx] = true;
                    return true;
                }
            }
        }
        mem[idx] = false; //成对出现
        return false;
    }

    //3. DP
    // leetcode_
    //         i
    // j->
    // tffftffft
    //O(n^2)
    public boolean wordBreak3(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    //4.DP: bottom up
    public boolean wordBrea4(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[len] = true;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j <= len; j++) {
                if (dp[j] && wordDict.contains(s.substring(i,j))) {
                    dp[i] = true;
                }
            }
        }
        return dp[0];
    }
}
