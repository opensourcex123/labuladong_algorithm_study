// 45.跳跃游戏II
public class jump {
    public int jump(int[] nums) {
        int n = nums.length;
        int far = 0;
        int end = 0;
        int jump = 0;

        for (int i = 0; i < n - 1; i++) {
            far = Math.max(i + nums[i], far);

            if (end == i) {
                jump++;
                end = far;
            }
        }

        return jump;
    }
}
