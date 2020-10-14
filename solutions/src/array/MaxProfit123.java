package array;

/**
 * @author chenpengfei
 * @date 2020/8/2 11:02 上午
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）.
 * 做法：定义dp[i][j][k]为第i天，做了j次交易【买】，手上是否持有股票的收益大小
 */
public class MaxProfit123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int max_k = 2;
        // 因为有做了0，1，2次交易，所以K维度应该设置成3
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= max_k; k++) {
                if (i - 1 == -1) {
                    // 初始化，第一天不持有股票，收益都为0
                    dp[i][k][0] = 0;
                    // 初始化，第一天持有股票，收益都为-prices[i]
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                // 第i天不持有股票，要么就是上一天也不持有股票，要么就是上一天持有股票，然后卖了
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                // 第i天持有股票，要么就是上一天持有股票，要么就是上一天不持有股票，然后买入，这里是k-1，因为买入股票就是新的一次交易了
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        // 穷举了 n × max_k × 2 个状态，正确。
        return dp[n - 1][max_k][0];
    }

    // 重写练习
    public int maxPro(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        int[][][] dp = new int[n][3][2];
        for (int i = 0; i < n; i++) {
            // 初始化
            for (int k = 1; k < 3; k++) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                }
                else {
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                }
            }
        }
        return dp[n - 1][2][0];
    }

}
