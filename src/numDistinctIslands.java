import java.util.HashSet;

// 694.不同的岛屿数量
public class numDistinctIslands {
    int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        HashSet<String> islands = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, 666);
                    islands.add(sb.toString());
                }
            }
        }
        return islands.size();
    }

    void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        if (grid[i][j] == 0) return;
        grid[i][j] = 0;
        sb.append(dir).append(',');
        dfs(grid, i - 1, j, sb, 1); // 上
        dfs(grid, i, j - 1, sb, 3);  // 左
        dfs(grid, i + 1, j, sb, 2);    // 下
        dfs(grid, i, j + 1, sb, 4);    // 右
        sb.append(-dir).append(',');
    }
}
