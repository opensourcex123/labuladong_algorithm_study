import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 18.四数之和
public class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<List<Integer>> track = threeSum(nums, i + 1, target - nums[i]);
            for (List<Integer> tra : track) {
                tra.add(nums[i]);
                res.add(tra);
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        }

        return res;
    }

    public List<List<Integer>> threeSum(int[] nums, int start, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = start; i < n; i++) {
            List<List<Integer>> track = twoSum(nums, i + 1, target-nums[i]);

            for (List<Integer> tra : track) {
                tra.add(nums[i]);
                res.add(tra);
            }

            while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        int n = nums.length;
        int lo = start;
        int hi = n - 1;
        List<List<Integer>> res = new ArrayList<>();

        while (lo < hi) {
            int left = nums[lo];
            int right = nums[hi];
            if (left + right < target) {
                while (lo < hi && nums[lo] == left) lo++;
            } else if (left + right > target) {
                while (lo < hi && nums[hi] == right) hi--;
            } else {
                List<Integer> track = new ArrayList<>();
                track.add(left);
                track.add(right);
                res.add(track);
                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;
            }
        }

        return res;
    }
}
