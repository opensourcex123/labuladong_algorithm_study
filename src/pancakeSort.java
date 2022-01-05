import java.util.ArrayList;
import java.util.List;

// 969.煎饼排序
public class pancakeSort {
    List<Integer> res = new ArrayList<>();
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        sort(arr, n);
        return res;
    }

    private void sort(int[] arr, int n) {
        if (n == 1) return;

        int maxCake = 0;
        int maxCakeIndex = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxCake) {
                maxCake = arr[i];
                maxCakeIndex = i;
            }
        }

        // 将最大的饼翻到最上面
        reverse(arr, 0, maxCakeIndex);
        res.add(maxCakeIndex + 1);

        // 将所有的饼翻过来，这样最大的饼就在最下面了
        reverse(arr, 0, n - 1);
        res.add(n);

        sort(arr, n - 1);
    }

    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
