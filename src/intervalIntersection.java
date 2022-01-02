import java.util.ArrayList;
import java.util.List;

// 986.区间列表的交集
public class intervalIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int[] a = firstList[i];
            int[] b = secondList[j];

            if (b[1] >= a[0] && a[1] >= b[0]) {
                res.add(new int[]
                        {Math.max(a[0], b[0]), Math.min(a[1], b[1])}
                );
            }

            if (b[1] < a[1]) {
                j++;
            } else {
                i++;
            }
        }

        return res.toArray(new int[res.size()][2]);
    }
}
