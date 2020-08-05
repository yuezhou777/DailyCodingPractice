package Sort_and_Search.DFS;

public class LC403_Frog_Jump {
    //这题不适合dp，但可以dfs + pruning
    //对于一些题来说，如果它的搜索状态是离散的，那它就不适合dp,因为dp在填值的时候必须是连续填值的


    //TLE
    public boolean canCrossTLE(int[] stones) {
        if (stones[1] - stones[0] > 1) return false;
        return dfs(stones, 0, 1);
    }

    private boolean dfs(int[] stones , int idx, int k) {
        int len = stones.length;
        if (idx == len - 1) {
            return true;
        }
        if (idx >= len) {
            return false;
        }
        for (int i = idx + 1; i < len; i++) {
            int dist = stones[i] - stones[idx];
            if (dist < k - 1) {
                continue;
            }
            if (dist > k + 1) {
                break;
            }
            if (dfs(stones, i, dist)) {
                return true;
            }
        }

        return false;
    }
}
