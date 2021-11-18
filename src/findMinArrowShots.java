import java.util.Arrays;
import java.util.Comparator;

// 452.用最少数量的箭引爆气球
public class findMinArrowShots {
    int count;
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        int x_end = points[0][1];
        count = 1;

        for (int[] point : points) {
            int start = point[0];
            if (start > x_end) {
                count++;
                x_end = point[1];
            }
        }

        return count;
    }
}
