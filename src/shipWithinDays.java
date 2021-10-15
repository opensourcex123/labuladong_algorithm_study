// 1011.在D天内送达包裹的能力
public class shipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        if (weights.length == 0) return -1;
        int left = 0;
        int right = 0;
        for (int w: weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) == days) {
                right = mid - 1;
            } else if (f(weights, mid) > days) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // x是运载能力，返回的是天数，运载能力和天数的函数，运载能力越高，天数越短
    public int f(int[] weights, int x) {
        int d = 0;
        for (int i = 0; i < weights.length; ) {
            int cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) break;
                else cap -= weights[i];
                i++;
            }
            d++;
        }
        return d;
    }
}
