import java.util.ArrayList;
import java.util.List;

// 22.括号生成
public class generateParenthesis {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return null;
        List<String> res = new ArrayList<>();
        StringBuilder track = new StringBuilder();
        dfs(n, n, track, res);
        return res;
    }

    // 一个「合法」括号组合的左括号数量一定等于右括号数量，这个很好理解。
    // 对于一个「合法」的括号字符串组合 p，必然对于任何 0 <= i < len(p) 都有：子串 p[0..i] 中左括号的数量都大于或等于右括号的数量。
    void dfs(int left, int right, StringBuilder track, List<String> res) {
        if (right < left) return;
        if (left < 0 || right < 0) return;
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }

        track.append("(");
        dfs(left - 1, right, track, res);
        track.deleteCharAt(track.length() - 1);

        track.append(")");
        dfs(left, right - 1, track, res);
        track.deleteCharAt(track.length() - 1);
    }
}
