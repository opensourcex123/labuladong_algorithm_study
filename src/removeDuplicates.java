// 26.删除有序数组中的重复项
public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow, fast;
        slow = fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
