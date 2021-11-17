import java.util.Arrays;
import java.util.Comparator;

// 区间调度问题，选择结束时间最早的
public class intervalSchedule {
    int count;
    int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) return 0;

        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int x_end = intvs[0][1];
        count = 1;
        for (int[] interval : intvs) {
            int start = interval[0];
            if (start >= x_end) {
                count++;
                x_end = interval[1];
            }
        }

        return count;
    }
}
