package dp;

/**
 * 打家劫舍
 *
 * 注意两种动态规划不同的dp定义和写法
 * */
public class Rob198 {
    public int rob(int[] nums) {
        return rob2(nums);
    }

    public int rob1(int[] nums) {
        // 动态规划
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 定义dp[i]为偷了第i间房时，此时最大的数额（一定偷了第i间）
            // 方程为dp[i] = nums[i] + max(dp[i - 2], dp[i - 3])
            if (i == 0 || i == 1) {
                dp[i] = nums[i];
            }
            else if (i == 2) {
                dp[i] = nums[i] + dp[0];
            }
            else {
                dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
            }
        }
        // 由于可能不一定会偷到最后一间房，可能最后偷的是倒数第二间，所以返回两者的最大值
        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }

    public int rob2(int[] nums) {
        // 动态规划2
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 定义dp[i]为偷到第i间房子时候，此时的最大数值（可能没有偷第间）
            // dp[i] = max(nums[i] + dp[i - 2], dp[i - 1])
            if (i == 0) {
                dp[i] = nums[i];
            }
            else if (i == 1) {
                dp[i] = Math.max(nums[i], dp[i - 1]);
            }
            else {
                dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
            }
        }
        return dp[nums.length - 1];
    }
}
