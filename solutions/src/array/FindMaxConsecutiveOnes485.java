package array;

/**
 * @author chenpengfei
 * @date 2020/7/5 2:16 下午
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 */
public class FindMaxConsecutiveOnes485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = -1;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 && start == -1) {
                start = i;
            }
            else if (nums[i] == 0 && start != -1) {
                maxLen = Math.max(maxLen, i - start);
                start = -1;
            }
            if (i == nums.length - 1 && nums[i] == 1) {
                maxLen = Math.max(maxLen, i - start + 1);
            }
        }
        return maxLen;
    }
}
