import java.util.Arrays;

// 1288.删除被覆盖区间
public class removeCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int left = intervals[0][0];
        int right = intervals[0][1];

        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] intv = intervals[i];
            if (left <= intv[0] && right >= intv[1]) {
                res++;
            } else if (right >= intv[0] && right <= intv[1]) {
                right = intv[1];
            } else if (right < intv[0]) {
                left = intv[0];
                right = intv[1];
            }
        }

        return intervals.length - res;
    }
}
