package dp;

import java.util.Arrays;

/**
 * @author chenpengfei
 * @date 2020/7/18 1:35 下午
 * 经典动态规划凑硬币问题
 */
public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1? -1: dp[amount];
    }
}
