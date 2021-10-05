import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 503.下一个更大元素II
public class nextGreaterElementsII {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n =nums.length;
        int[] res = new int[n];
        for (int i = 2 * n - 1; i >= 0 ; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i % n]) {
                s.pop();
            }
            res[i % n] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i % n]);
        }
        return res;
    }
}
