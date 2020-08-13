package DPI;

public class LC256_Paint_House {
    //dp
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        for (int i = 1; i < n; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        return Math.min(Math.min(costs[n - 1][0], costs[n - 1][1]), costs[n - 1][2]);
    }

    //dfs + memo
    /*
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        HashMap<String, Integer> map = new HashMap<>();
        return Math.min(Math.min(dfs(costs, map, 0, 0), dfs(costs, map, 0, 1)), dfs(costs, map, 0, 2));
    }

    private int dfs(int[][] cost, HashMap<String, Integer> map, int idx, int color) {
        String key = getKey(idx, color);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int total = cost[idx][color];
        if (idx == cost.length - 1) {
            return total;
        } else if (color == 0) {
            total += Math.min(dfs(cost, map, idx + 1, 1), dfs(cost, map, idx + 1, 2));
        } else if (color == 1) {
            total += Math.min(dfs(cost, map, idx + 1, 0), dfs(cost, map, idx + 1, 2));
        } else if (color == 2) {
            total += Math.min(dfs(cost, map, idx + 1, 0), dfs(cost, map, idx + 1, 1));
        }
        map.put(key, total);
        return total;
    }

    private String getKey(int idx, int color) {
        return String.valueOf(idx) + ":" + String.valueOf(color);
    }
    */
}
