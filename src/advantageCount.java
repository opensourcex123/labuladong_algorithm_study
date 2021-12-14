import java.util.Arrays;
import java.util.PriorityQueue;

// 870.优势洗牌
public class advantageCount {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // 优先级队列，可以排序的队列
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(
                (int[] pair1, int[] pair2) -> pair2[1] - pair1[1]
        );

        for (int i = 0; i < n; i++) {
            maxpq.offer(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);

        int left = 0;
        int right = n - 1;
        int[] res = new int[n];

        while (!maxpq.isEmpty()) {
            int[] pairs = maxpq.poll();
            int i = pairs[0];
            int maxVal = pairs[1];

            if (maxVal < nums1[right]) {
                res[i] = nums1[right];
                right--;
            } else {
                res[i] = nums1[left];
                left++;
            }
        }

        return res;
    }
}
