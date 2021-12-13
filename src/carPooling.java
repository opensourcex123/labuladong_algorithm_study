// 1094.拼车
public class carPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] res = new int[1001];
        Difference diff = new Difference(res);
        for (int[] trip: trips) {
            diff.increment(trip[1], trip[2] - 1, trip[0]);
        }
        res = diff.res();
        for (int re : res) {
            if (re > capacity) return false;
        }
        return true;
    }
}
