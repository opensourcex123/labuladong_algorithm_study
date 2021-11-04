// 698.划分为k个相等的子集
public class canPartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int v : nums) sum += v;
        if (sum % k != 0) return false;
        int target = sum / k;
        boolean[] used = new boolean[nums.length];
        return dfs(k, 0, nums, 0, used, target);
    }

    boolean dfs(int k, int bucket, int[] nums, int start, boolean[] used, int target) {
        if (k == 0) return true;
        if (bucket == target) {
            return dfs(k - 1, 0, nums, 0, used, target);
        }

        for (int i = start; i < nums.length; i++) {
            if (bucket + nums[i] > target) continue;
            if (used[i]) continue;
            used[i] = true;
            bucket += nums[i];
            if (dfs(k, bucket, nums, i + 1, used, target)) {
                return true;
            }

            used[i] = false;
            bucket -= nums[i];
        }

        return false;
    }
}
