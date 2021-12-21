import java.util.HashMap;
import java.util.Map;

// 10.正则表达式匹配
public class isMatch {
    Map<String, Boolean> memo;
    public boolean isMatch(String s, String p) {
        memo = new HashMap<>();
        return dp(s, 0, p, 0);
    }

    // dp代表p[j...]是否能匹配s[i...]
    private boolean dp(String s, int i, String p, int j) {
        int m = s.length();
        int n = p.length();
        // base case
        if (j == n) {
            return i == m;
        }
        // base case
        if (i == m) {
            if ((n - j) % 2 == 1) {
                return false;
            }

            for (; j + 1 < n; j += 2) {
                if (p.charAt(j+1) != '*') {
                    return false;
                }
            }
            return true;
        }

        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean res = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j + 1 < n && p.charAt(j+1) == '*') {
                res = dp(s, i + 1, p, j) || dp(s, i, p, j + 2);
            } else {
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            if (j + 1 < n && p.charAt(j+1) == '*') {
                res = dp(s, i, p, j + 2);
            } else {
                return false;
            }
        }
        memo.put(key, res);
        return res;
    }
}
