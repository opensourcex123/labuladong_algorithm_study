import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 514.自由之路
public class findRotateSteps {
    // 泛型的类型一定要明确
    HashMap<Character, ArrayList<Integer>> charToIndex;
    int[][] memo;
    public int findRotateSteps(String ring, String key) {
        int m = ring.length();
        int n = key.length();
        charToIndex = new HashMap<Character, ArrayList<Integer>>();

        memo = new int[m][n];
        for (int[] me: memo) {
            Arrays.fill(me, 0);
        }

        for (int i = 0; i < ring.length(); i++) {
            char ch = ring.charAt(i);
            charToIndex.putIfAbsent(ch, new ArrayList<>());
            charToIndex.get(ch).add(i);

        }

        return dp(ring, 0, key, 0);
    }

    // dp函数表示当圆盘指向ring[i]时，输入字符串key[j..]需要dp（）操作
    private int dp(String ring, int i, String key, int j) {
        if (j == key.length()) return 0;

        if (memo[i][j] != 0)  return memo[i][j];

        int n = ring.length();
        int res = Integer.MAX_VALUE;
        for (int k : charToIndex.get(key.charAt(j)))
        {
            int delta = Math.abs(k - i);
            delta = Math.min(delta, n - delta);
            int subPro = dp(ring, k, key, j + 1);
            res = Math.min(res, 1 + delta + subPro);
        }
        memo[i][j] = res;
        return res;
    }
}
