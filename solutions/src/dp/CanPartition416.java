package dp;

import java.util.Arrays;

/**
 * @author chenpengfei
 * @date 2020/7/18 12:54 下午
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 等同于0-1背包问题
 */
public class CanPartition416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int half = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][half + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = false;
                }
                else {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][half];
    }
}
