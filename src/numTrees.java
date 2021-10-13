// 96.不同的二叉搜索树
public class numTrees {
    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    public int count(int low, int high) {
        if (low > high) return 1;


        if (memo[low][high] != 0) return memo[low][high];
        int res = 0;
        for (int mid = low; mid <= high; mid++) {
            int left = count(low, mid - 1);
            int right = count(mid + 1, high);
            res += left * right;
        }
        memo[low][high] = res;
        return res;
    }
}
