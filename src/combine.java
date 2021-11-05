import java.util.ArrayList;
import java.util.List;

// 77.组合
public class combine {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0) return res;
        List<Integer> track = new ArrayList<>();
        dfs(n, k, 1, track);
        return res;
    }

    void dfs(int n, int k, int start, List<Integer> track) {
        if (track.size() == k) {
            res.add(new ArrayList(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.add(i);
            dfs(n, k, i + 1, track);
            track.remove(track.size() - 1);
        }
    }
}
