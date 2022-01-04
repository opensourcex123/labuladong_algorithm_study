import java.util.Arrays;

// 吃葡萄 https://www.nowcoder.com/questionTerminal/14c0359fb77a48319f0122ec175c9ada
// 通过构造三角形，尽量平分葡萄数量
public class eatGrapes {
    long solution(long a, long b, long c) {
        long[] nums = new long[]{a, b, c};

        Arrays.sort(nums);
        long sum = a + b + c;

        if (nums[0] + nums[1] > nums[2]) {
            return (sum + 2) / 3;
        } else if (2 * (nums[0] + nums[1]) < nums[2]) {
            return (nums[2] + 1) / 2;
        }

        return (sum + 2) / 3;
    }
}
