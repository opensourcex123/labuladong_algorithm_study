import java.util.PriorityQueue;
import java.util.Random;

// 215.数组中的第K个最大元素
public class findKthLargest {
    public int findKthLargest(int[] nums, int k) {
//        优先级队列解决问题
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//
//        for (int n: nums) {
//            pq.offer(n);
//
//            if (pq.size() > k) {
//                pq.poll();
//            }
//        }
//
//        return pq.peek();
//      快速选择解决问题，使用快速排序的partition函数
        shuffle(nums);
        int lo = 0;
        int hi = nums.length - 1;
        k = nums.length - k;

        while (lo <= hi) {
            int p = partition(nums, lo, hi);
            if (p > k) {
                hi = p - 1;
            } else if (p < k) {
                lo = p + 1;
            } else {
                return nums[p];
            }
        }

        return -1;
    }

    private int partition(int[] nums, int lo, int hi) {
        if (lo == hi) return lo;
        int i = lo;
        int j = hi + 1;
        int pivort = nums[i];

        while (true) {
            while (nums[++i] < pivort) {
                if (i == hi) break;
            }
            while (nums[--j] > pivort) {
                if (j == lo) break;
            }
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, j, lo);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void shuffle(int[] nums) {
        int n = nums.length;
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }
}
