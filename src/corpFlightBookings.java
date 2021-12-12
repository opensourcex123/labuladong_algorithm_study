import java.util.Arrays;

// 1109.航班预定统计
public class corpFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        Arrays.fill(res, 0);
        Difference diff = new Difference(res);
        for (int[] booking : bookings) {
            diff.increment(booking[0]-1, booking[1]-1, booking[2]);
        }

        return diff.res();
    }
}
