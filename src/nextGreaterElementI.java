import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 496.下一个更大元素I 单调栈解法
public class nextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums2.length];
        int[] ans = new int[nums1.length];
        for (int i = nums2.length - 1; i >= 0 ; i--) {
            while (!s.isEmpty() && s.peek() <= nums2[i]) {
                s.pop();
            }
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums2[i]);
        }
        for (int i = 0; i< nums2.length; i++) {
            map.put(nums2[i], res[i]);
        }
        for (int i = 0; i< nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
