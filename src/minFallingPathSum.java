import java.util.Arrays;

// 931.下降路径最小和
public class minFallingPathSum {
    int [][] memo;
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        int m = matrix.length;
        memo = new int[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], 66666);
        }

        for (int j = 0; j < m; j++) {
            res = Math.min(res, dp(matrix, m - 1, j));
        }
        return res;
    }

    private int dp(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 99999;
        }
        if (i == 0) return matrix[0][j];
        if (memo[i][j] != 66666) return memo[i][j];
        memo[i][j] = matrix[i][j] + min(dp(matrix, i - 1, j - 1), dp(matrix, i - 1, j), dp(matrix, i - 1, j + 1));
        return memo[i][j];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
