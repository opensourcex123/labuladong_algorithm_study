import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 739.每日温度，单调栈
public class dailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0 ; i--) {
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }
            res[i] = s.isEmpty() ? 0 : s.peek() - i;
            s.push(i);
        }
        return res;
    }
}
