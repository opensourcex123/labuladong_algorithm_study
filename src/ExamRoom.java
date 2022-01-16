import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

// 855.考场就坐
public class ExamRoom {
    private Map<Integer, int[]> startMap;
    private Map<Integer, int[]> endMap;
    private TreeSet<int[]> pq;
    private int N;

    public ExamRoom(int n) {
        this.N = n;
        startMap = new HashMap<>();
        endMap = new HashMap<>();
        pq = new TreeSet<>((a, b) -> {
            int disA = distance(a);
            int disB = distance(b);
            if (disA == disB) {
                return b[0] - a[0];
            }
            return disA - disB;
        });
        addInterval(new int[] {-1, N});
    }

    private void removeInterval(int[] intv) {
        pq.remove(intv);
        startMap.remove(intv[0]);
        endMap.remove(intv[1]);
    }

    private void addInterval(int[] intv) {
        pq.add(intv);
        startMap.put(intv[0], intv);
        endMap.put(intv[1], intv);
    }

    private int distance(int[] intv) {
        int x = intv[0];
        int y = intv[1];
        if (x == -1) {
            return y;
        }
        if (y == N) {
            return N - 1 - x;
        }
        return (y - x) / 2;
    }

    public int seat() {
        int[] longest = pq.last();
        int x = longest[0];
        int y = longest[1];
        int seat;
        if (x == -1) {
            seat = 0;
        } else if (y == N) {
            seat = N - 1;
        } else {
            seat = (y - x) / 2 + x;
        }

        int[] left = new int[] {x, seat};
        int[] right = new int[] {seat, y};
        removeInterval(longest);
        addInterval(left);
        addInterval(right);
        return seat;
    }

    public void leave(int p) {
        int[] left = endMap.get(p);
        int[] right = startMap.get(p);

        int[] longest = new int[] {left[0], right[1]};
        removeInterval(left);
        removeInterval(right);
        addInterval(longest);
    }
}
