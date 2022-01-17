import java.util.ArrayList;

// 392.判断子序列
public class isSubsequence {
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();

        ArrayList<Integer>[] index = new ArrayList[256];
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            if (index[c] == null) {
                index[c] = new ArrayList<>();
            }
            index[c].add(i);
        }

        int j = 0;
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (index[c] == null) return false;
            int pos = left_bound(index[c], j);
            if (pos == index[c].size()) return false;
            j = index[c].get(pos) + 1;
        }

        return true;
    }

    private int left_bound(ArrayList<Integer> arr, int target) {
        int lo = 0;
        int hi = arr.size();

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target > arr.get(mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}
