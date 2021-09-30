// 283.移动零
public class moveZeroes {
    public void moveZeroes(int[] nums) {
        int p = removeElement.removeElement(nums, 0);
        for(; p < nums.length; p++) {
            nums[p] = 0;
        }
    }
}
