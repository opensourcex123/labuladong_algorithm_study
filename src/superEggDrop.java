// 887.鸡蛋掉落
public class superEggDrop {
    public int superEggDrop(int k, int n) {
        // dp[k][m] = n现在的定义是，有k个鸡蛋，扔m次，最多能检验n层楼
        int[][] dp = new int[k+1][n+1];
        int m = 0;
        while (dp[k][m] < n) {
            m++;
            for (int i = 1; i <= k; i++) {
                dp[i][m] = dp[i][m-1] + dp[i-1][m-1] + 1;
            }
        }
        return m;
    }

    // // k个鸡蛋，n层楼的最小操作次数,这个方法会超时
    // private int dp(int k, int n) {
    //     if (k == 1) return n;
    //     if (n == 0) return 0;
    //     if (memo[k][n] != -1) return memo[k][n];

    //     int res = Integer.MAX_VALUE;
    //     for (int i = 1; i <= n; i++) {
    //         res = Math.min(res,
    //         Math.max(dp(k - 1, i - 1),
    //         dp(k, n - i)) + 1);
    //     }
    //     memo[k][n] = res;
    //     return res;
    // }
}
