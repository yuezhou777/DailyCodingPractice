package Sort_and_Search.DFS;

public class LC10_Regular_Expression_Matching {
    //*可以match搜索过程中的0或多个字符，这里就会分叉，所以用dfs可以
    //44题wildcard matching用的是greedy
    //DFS no pruning
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        return dfs(s, 0, p, 0);
    }

    private boolean dfs(String s, int idxS, String p, int idxP) {
        int lenS = s.length();
        int lenP = p.length();
        if (idxP == lenP) { //基于p判断cc: p为空的话，s必须为空
            if (idxS == lenS) {
                return true;
            }
        } else if (idxP == lenP - 1 || p.charAt(idxP + 1) != '*') { //indP == lenP - 1: s:aa, p:a
            if (idxS < lenS && (
                    s.charAt(idxS) == p.charAt(idxP) || p.charAt(idxP) == '.'
            )) {
                return dfs(s, idxS + 1, p, idxP + 1);
            } else {
                return false;
            }
        } else {
            int i = idxS - 1; //s:aab, p:c*a*b
            while (i < lenS && (
                    i < idxS || s.charAt(i) == p.charAt(idxP) || p.charAt(idxP) == '.'
            )) {
                if (dfs(s, i + 1, p, idxP + 2)) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    //DFS pruning
    //pruning 是2倍DP时间复杂度：top down + bottom up
    public boolean isMatch2(String s, String p) {
        if (s == null || p == null) return false;
        Boolean[][] mem = new Boolean[s.length() + 1][p.length() + 1]; //boundry is len + 1 beacuse in dfs() idxS is likely to be lenS
        return dfs(s, 0, p, 0, mem);
    }

    private boolean dfs(String s, int idxS, String p, int idxP, Boolean[][] mem) {
        if (mem[idxS][idxP] != null) return mem[idxS][idxP];
        int lenS = s.length();
        int lenP = p.length();
        if (idxP == lenP) { //基于p判断cc: p为空的话，s必须为空
            return idxS == lenS;
        } else if (idxP == lenP - 1 || p.charAt(idxP + 1) != '*') { //indP == lenP - 1: s:aa, p:a
            if (idxS < lenS && (
                    s.charAt(idxS) == p.charAt(idxP) || p.charAt(idxP) == '.'
            )) {
                mem[idxS][idxP] = dfs(s, idxS + 1, p, idxP + 1, mem);
            } else {
                mem[idxS][idxP] = false;
                return false;
            }
        } else {
            int i = idxS - 1; //s:aab, p:c*a*b
            while (i < lenS && (
                    i < idxS || s.charAt(i) == p.charAt(idxP) || p.charAt(idxP) == '.'
            )) {
                if (dfs(s, i + 1, p, idxP + 2, mem)) {
                    mem[idxS][idxP] = true;
                    return true;
                }
                i++;
            }
            mem[idxS][idxP] = false;
        }
        return mem[idxS][idxP];
    }
}
