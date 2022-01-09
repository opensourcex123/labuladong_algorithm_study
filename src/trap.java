// 42.接雨水
public class trap {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int l_max = 0;
        int r_max = 0;
        while (left < right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);

            if (l_max > r_max) {
                res += r_max - height[right];
                right--;
            } else {
                res += l_max - height[left];
                left++;
            }
        }

        return res;
    }
}
