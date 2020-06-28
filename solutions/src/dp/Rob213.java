package dp;

import java.util.Arrays;

/**
 * 打家劫舍2
 * 做法: 分两种情况，一种是不偷第一家，一种是不偷最后一家，然后选择这个结果中的最大值
 * */
public class Rob213 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(dp(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                dp(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int dp(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            }
            else if (i == 1) {
                dp[i] = Math.max(dp[i - 1], nums[i]);
            }
            else {
                dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
            }
        }
        return dp[nums.length - 1];
    }
}
