import java.util.Arrays;

// 1024.视频拼接
public class videoStitching {
    public int videoStitching(int[][] clips, int time) {
        if (time == 0) return 0;
        int n = clips.length;

        Arrays.sort(clips, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int res = 0;
        int currentEnd = 0;
        int nextEnd = 0;
        int i = 0;
        while (i < n && clips[i][0] <= currentEnd) {
            while (i < n && clips[i][0] <= currentEnd) {
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }
            res++;
            currentEnd = nextEnd;
            if (currentEnd >= time) return res;
        }

        return -1;
    }
}