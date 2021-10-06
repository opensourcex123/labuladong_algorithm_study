import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 239.滑动窗口最大值 单调队列解决问题
public class maxSlidingWindow {
    class MonotonicQueue {
        LinkedList<Integer> q = new LinkedList<>();
        public void push(int x) {
            while (!q.isEmpty() && q.getLast() < x) {
                q.pollLast();
            }
            q.addLast(x);
        }

        public int max() {
            return q.getFirst();
        }

        public void pop(int x) {
            if (x == q.getFirst()) q.pollFirst();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
