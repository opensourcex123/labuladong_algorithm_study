import java.util.Arrays;

// 213.打家劫舍II
public class robII {
    int[][] memo;
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        memo = new int[n][n];
        for (int[] me : memo) {
            Arrays.fill(me, -1);
        }
        return Math.max(dp(nums, 0, n - 2), dp(nums, 1, n - 1));
    }

    private int dp(int[] nums, int start, int end) {
        if (start > end) return 0;
        if (memo[start][end] != -1) return memo[start][end];

        int res = Math.max(dp(nums, start + 1, end), dp(nums, start + 2, end) + nums[start]);
        memo[start][end] = res;
        return res;
    }
}

