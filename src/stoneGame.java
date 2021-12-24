// 877.石子游戏
class Pair {
    int fir;
    int sec;
    Pair(int fir, int sec) {
        this.fir = fir;
        this.sec = sec;
    }
}
public class stoneGame {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        // dp[i][j].fir的意思是，[i,j]区间上的石头先手获得的最高分
        // dp[i][j].sec的意思是，[i,j]区间上的石头后手获得的最高分
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int left = piles[i] + dp[i+1][j].sec;
                int right = piles[j] + dp[i][j-1].sec;

                if (left > right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i+1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j-1].fir;
                }
            }
        }
        Pair res = dp[0][n-1];
        return res.fir - res.sec > 0;
    }
}
