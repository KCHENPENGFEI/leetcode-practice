package array;

import java.util.Arrays;

/**
 * @author chenpengfei
 * @date 2020/6/24 9:52 下午
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 */
public class FindLHS594 {
    public int findLHS(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int i = 0, j = 1;
        int maxLen = 0;
        while (j < nums.length) {
            if (nums[j] - nums[i] == 1) {
                j++;
                maxLen = Math.max(maxLen, j - i);
            }
            else if (nums[j] - nums[i] > 1){
                i++;
            }
            else {
                j++;
            }
        }
        return maxLen;
    }
}
