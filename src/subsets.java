import java.util.ArrayList;
import java.util.List;

// 78.子集
public class subsets {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> track = new ArrayList<>();
        dfs(nums, 0, track);
        return res;
    }

    void dfs(int[] nums, int start, List<Integer> track) {
        res.add(new ArrayList(track));  // 不能直接写track
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            dfs(nums, i + 1, track);
            track.remove(track.size() - 1);
        }
    }
}
