// 53.最大字序和
public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int dp_0 = nums[0];
        int dp_1;
        int res = dp_0;
        for (int i = 1; i < n; i++) {
            dp_1 = Math.max(nums[i], dp_0 + nums[i]);
            dp_0 = dp_1;
            res = Math.max(res, dp_1);
        }

        return res;
    }
}
