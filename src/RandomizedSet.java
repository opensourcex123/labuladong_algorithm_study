import java.util.*;

// 388.常数时间插入、删除和获取随机元素
public class RandomizedSet {
    List<Integer> nums;
    Map<Integer, Integer> valToIndex;
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList();
        valToIndex = new HashMap();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        valToIndex.put(val, nums.size());
        nums.add(nums.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        int lastElement = nums.get(nums.size() - 1);
        int index = valToIndex.get(val);
        nums.set(index, lastElement);
        valToIndex.put(lastElement, index);
        nums.remove(nums.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
