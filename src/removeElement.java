// 27.移除元素
public class removeElement {
    public int removeElement(int[] nums, int val) {
        int slow, fast;
        slow = fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
