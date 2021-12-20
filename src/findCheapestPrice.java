import java.util.*;

// 787.K站中转内最便宜的航班
public class findCheapestPrice {
    Map<Integer, List<int[]>> indegree;
    int src;
    int dst;
    int[][] memo;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        this.src = src;
        this.dst = dst;
        indegree = new HashMap<>();

        memo = new int[n][k+2];
        for (int[] arr : memo) {
            Arrays.fill(arr, -888);
        }

        for (int[] f : flights) {
            int from = f[0];
            int to = f[1];
            int price = f[2];
            indegree.putIfAbsent(to, new LinkedList<>());
            indegree.get(to).add(new int[]{from, price});
        }

        return dp(dst, k + 1);
    }

    // 到target，最多走k步（k条边）花的最少的钱数
    private int dp(int target, int k) {
        if (target == src) return 0;
        if (k == 0) return -1;
        if (memo[target][k] != -888) return memo[target][k];

        int res = Integer.MAX_VALUE;
        if (indegree.containsKey(target)) {
            for (int[] v : indegree.get(target)) {
                int from = v[0];
                int price = v[1];
                int subPro = dp(from, k - 1);
                if (subPro != -1) {
                    res = Math.min(res, subPro + price);
                }
            }
        }
        memo[target][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[target][k];
    }
}
