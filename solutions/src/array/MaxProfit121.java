package array;

/**
 * @author chenpengfei
 * @date 2020/7/3 3:27 下午
 */
public class MaxProfit121 {
    // 最常规的解法，每次循环的时候记录下最低价，然后判断后面卖出的价格是否合适
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int res = 0;

        // 表示在当前位置之前的最小值，假设修正法（打擂台法）
        // minVal代表已经遍历过的数组中最小的元素，这个元素就可以作为买入时间
        int minVal = prices[0];
        // 注意：这里从 1 开始
        for (int i = 1; i < len; i++) {
            res = Math.max(res, prices[i] - minVal);
            minVal = Math.min(minVal, prices[i]);
        }
        return res;
    }

    // 动态规划做法，dp[i][j]代表第i天持股和不持股的最大收益，j = 0代表不持股，j = 1代表持股
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0：用户手上不持股所能获得的最大利润，特指卖出股票以后的不持股，非指没有进行过任何交易的不持股
        // 1：用户手上持股所能获得的最大利润

        // 注意：因为题目限制只能交易一次，因此状态只可能从 1 到 0，不可能从 0 到 1
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }
}
