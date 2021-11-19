import java.util.Arrays;

// 253.会议室II
public class minMeetingRooms {
    int minMeetingRooms(int[][] meetings) {
        int n = meetings.length;
        int[] begin = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            begin[i] = meetings[i][0];
            end[i] = meetings[i][1];
        }

        Arrays.sort(begin);
        Arrays.sort(end);

        int count = 0;
        int res = 0, i = 0, j = 0;

        while (i < n && j < n) {
            if (begin[i] < end[i]) {
                count++;
                i++;
            } else {
                j++;
                count--;
            }

            res = Math.max(res, count);
        }

        return res;
    }
}
