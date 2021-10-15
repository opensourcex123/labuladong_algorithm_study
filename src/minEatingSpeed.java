// 875.爱吃香蕉的珂珂
public class minEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 0) return -1;
        int left = 1;
        int right = 1000000000;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (f(piles, mid) == h) {
                right = mid - 1;
            } else if (f(piles, mid) > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int f(int[] piles, int x) {
        int hours = 0;
        for (int i = 0; i <= piles.length - 1; i++) {
            hours += piles[i] / x;
            if (piles[i] % x > 0) hours++;
        }
        return hours;
    }
}
