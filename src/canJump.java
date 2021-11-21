// 55.跳跃游戏
public class canJump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int far = 0;

        for (int i = 0; i < n - 1; i++) {
            far = Math.max(far, i + nums[i]);

            if (far == i) return false;
        }

        return far >= n - 1;
    }
}
