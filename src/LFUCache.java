import java.util.HashMap;
import java.util.LinkedHashSet;

// 460.LFU缓存
public class LFUCache {
    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer, Integer> keyToFreq;
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    int cap;
    int minFreq;
    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        minFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;

        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (this.cap <= 0) return;

        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }

        // 不存在，需要插入
        // 未满和已满
        if (this.cap <= keyToVal.size()) {
            removeMinFreqKey();
        }

        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        // 如果存在重复的key，不会重新放入
        freqToKeys.putIfAbsent(1, new LinkedHashSet<Integer>());
        freqToKeys.get(1).add(key);

        this.minFreq = 1;
    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);

        keyToFreq.put(key, freq + 1);

        freqToKeys.get(freq).remove(key);


        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);

        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (freq == minFreq) {
                this.minFreq++;
            }
        }
    }

    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);

        int deletedKey = keyList.iterator().next();
        keyToVal.remove(deletedKey);
        keyToFreq.remove(deletedKey);

        keyList.remove(deletedKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
        }
    }
}
