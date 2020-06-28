package dp;

import java.util.Arrays;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 做法: 类似于凑硬币，定义dp[i]是数字i最少的完全平方数和的个数, 则dp[i] = min(dp[i - 1], dp[i - 4], dp[i - 9], ...) + 1
 * */
public class NumSquares279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int max = (int) Math.sqrt(i);
            for (int j = 1; j <= max; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
