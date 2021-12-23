// 312.戳气球
public class maxCoins {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] points = new int[n+2];
        points[0] = points[n+1] = 1;
        for (int i = 1; i < n + 1; i++) {
            points[i] = nums[i-1];
        }
        // dp[i][j]代表着戳破区间(i,j)的气球的最大得分
        // 假设k为(i,j)之间最后一个戳破的气球
        int[][] dp = new int[n+2][n+2];

        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[k] * points[i] * points[j]);
                }
            }
        }
        return dp[0][n+1];
    }
}
