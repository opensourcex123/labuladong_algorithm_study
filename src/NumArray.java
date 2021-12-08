// 303.区域和检索-数组不可变
// 前缀和问题
public class NumArray {
    int[] preSum;
    public NumArray(int[] nums) {
        preSum = new int[nums.length];
        preSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) return preSum[right];
        else return preSum[right] - preSum[left - 1];
    }
}
