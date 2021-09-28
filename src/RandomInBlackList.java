import java.util.HashMap;
import java.util.Map;

// 710.黑名单中的随机数
public class RandomInBlackList {
    Map<Integer, Integer> mapping;
    int sz;
    public RandomInBlackList(int n, int[] blacklist) {
        mapping = new HashMap<>();
        sz = n - blacklist.length;
        for (int b : blacklist) {
            mapping.put(b, 666);
        }
        int last = n - 1;
        for (int b : blacklist) {
            if (b >= sz) continue;
            while (mapping.containsKey(b)) last--;
            mapping.put(b, last);
            last--;
        }
    }

    public int pick() {
        int index = (int) (Math.random() * sz);
        if (mapping.containsKey(index)) {
            return mapping.get(index);
        }
        return index;
    }
}
