import java.util.HashMap;

// 1.两数之和
public class twoSumII {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            int other = target - nums[i];
            if (index.containsKey(other) && index.get(other) != i) {
                return new int[]{i, index.get(other)};
            }
        }
        return new int[]{-1, -1};
    }
}
