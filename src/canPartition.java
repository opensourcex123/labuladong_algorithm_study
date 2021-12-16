// 416.分割等和子集
public class canPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        // dp[i][j] 代表当背包容量为j时，前i个数能否装满背包
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[n][sum];
    }
}
