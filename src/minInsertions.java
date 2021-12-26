// 1312.让字符串成为回文串的最小插入次数
public class minInsertions {
    public int minInsertions(String s) {
        int n = s.length();
        // dp[i][j]的含义是s[i..j]的插入最小次数是多少
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i+1][j]) + 1;
                }
            }
        }

        return dp[0][n-1];
    }
}
