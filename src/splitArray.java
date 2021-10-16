// 410.分割数组的最大值
public class splitArray {
    public int splitArray(int[] nums, int m) {
        int left = getMax(nums);
        int right = getSum(nums);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int n = split(nums, mid);
            if (n == m) {
                right = mid - 1;
            } else if (n > m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 将最大值作为限制条件，返回可以分成几个子数组
    public int split(int[] nums, int max) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > max) {
                count++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return count;
    }

    public int getMax(int[] nums) {
        int max = 0;
        for (int n: nums) {
            max = Math.max(max, n);
        }
        return max;
    }

    public int getSum(int[] nums) {
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        return sum;
    }
}
