import java.util.HashMap;
import java.util.Map;

// 560.和为K的子数组
public class subarraySum {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // 前缀和-》次数
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int res = 0;
        int pre_i = 0;
        for (int num : nums) {
            pre_i += num;
            int pre_j = pre_i - k;
            if (preSum.containsKey(pre_j)) {
                res += preSum.get(pre_j);
            }
            preSum.put(pre_i, preSum.getOrDefault(pre_i, 0) + 1);
        }

        return res;
    }
}
