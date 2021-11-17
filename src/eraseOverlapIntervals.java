import java.util.Arrays;
import java.util.Comparator;

// 435.无重叠区间
public class eraseOverlapIntervals {
    int count;
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int x_end = intervals[0][1];
        count = 1;
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start >= x_end) {
                count++;
                x_end = interval[1];
            }
        }

        return intervals.length - count;
    }
}
