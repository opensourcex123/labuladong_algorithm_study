import java.util.HashMap;

// 659.分割数组为连续子序列
public class isPossible {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> need = new HashMap<>();

        for (int v : nums) {
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }

        for (int v : nums) {
            if (freq.get(v) == 0) continue;

            if (need.containsKey(v) && need.get(v) > 0) {
                freq.put(v, freq.get(v) - 1);
                need.put(v, need.get(v) - 1);
                need.put(v + 1, need.getOrDefault(v + 1, 0) + 1);
            } else if (freq.getOrDefault(v, 0) > 0 && freq.getOrDefault(v + 1, 0) > 0 && freq.getOrDefault(v + 2, 0) > 0) {
                freq.put(v, freq.get(v) - 1);
                freq.put(v + 1, freq.get(v + 1) - 1);
                freq.put(v + 2, freq.get(v + 2) - 1);
                need.put(v + 3, need.getOrDefault(v + 3, 0) + 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
