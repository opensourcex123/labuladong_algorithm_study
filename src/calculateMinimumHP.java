import java.util.Arrays;

// 174.地下城游戏
public class calculateMinimumHP {
    int[][] memo;
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        memo = new int[m][n];
        for (int[] me: memo) {
            Arrays.fill(me, -1);
        }

        return dp(dungeon, 0, 0);
    }

    // dp(i,j)代表从dungeon(i,j)开始到右下角的最小生命值
    private int dp(int[][] dungeon, int i, int j) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        if (i == m - 1 && j== n - 1) {
            return dungeon[i][j] >= 0 ? 1:-dungeon[i][j] + 1;
        }

        if (i == m || j == n) {
            return Integer.MAX_VALUE;
        }

        if (memo[i][j] != -1) return memo[i][j];

        int res = Math.min(
                dp(dungeon, i + 1, j),
                dp(dungeon, i, j + 1)
        ) - dungeon[i][j];
        memo[i][j] = res > 0 ? res : 1;
        return memo[i][j];
    }
}
