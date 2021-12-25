// 651.四键键盘
public class maxA {
    public int maxA(int N) {
        // dp[n]代表有n次操作，屏幕上出现的最多的A的次数
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j-2] * (i - j + 1));
            }
        }
        return dp[N];
    }
}
