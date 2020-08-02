package array;

/**
 * @author chenpengfei
 * @date 2020/8/2 2:14 下午
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 做法: 套用模板定义dp[i][j][k]为第i天做了j次交易，是否持有股票情况下的最大收益
 * 因为本题中交易次数是+infinity所以只需要定义dp[i][k]即可，由于存在冷冻期，所以dp方程为
 * dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i])
 * 要注意的是对于i = 0和i = 1情况下是特殊情况进行判断// 看注释
 *
 */
public class MaxProfit309 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                // i = 0时候只有两种情况
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            }
            else if (i == 1) {
                // i = 1时候需要判断一下i = 0时候是否已经购入股票
                // 0是i = 0时候没有买入, dp[i - 1][1] + prices[i]是i = 0时候买入了
                dp[i][0] = Math.max(0, dp[i - 1][1] + prices[i]);
                // dp[i - 1][1]是在i = 1时候没有卖出， -prices[i]是i = 1时买入
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
            else {
                // 通用的dp模板
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }
        }
        return dp[n - 1][0];
    }
}
