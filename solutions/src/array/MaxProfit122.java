package array;

/**
 * @author chenpengfei
 * @date 2020/7/3 4:04 下午
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 */
public class MaxProfit122 {
    // 从第二个数开始遍历，只要prices[i] > prices[i - 1]就把收益加上
    public int maxProfit1(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) {
                profit += tmp;
            }
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int profit = 0;
        int buyIndex = -1;
        int sellIndex = -1;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (prices[i] < prices[i + 1]) {
                    // 买入
                    buyIndex = i;
                }
            }
            else if (i == len - 1){
                if (prices[i] > prices[i - 1]) {
                    // 卖出
                    // 一定要手上有股票的时候才能卖出
                    if (buyIndex != -1) {
                        sellIndex = i;
                        profit += prices[sellIndex] - prices[buyIndex];
                        buyIndex = -1;
                    }
                }
            }
            else {
                if (prices[i] <= prices[i - 1] && prices[i] < prices[i + 1]) {
                    // 买入
                    // 一定要手上没股票的才能买入
                    if (buyIndex == -1) {
                        buyIndex = i;
                    }
                }
                else if (prices[i] > prices[i - 1] && prices[i] >= prices[i + 1]) {
                    // 卖出
                    // 一定要手上有股票的时候才能卖出
                    if (buyIndex != -1) {
                        sellIndex = i;
                        profit += prices[sellIndex] - prices[buyIndex];
                        buyIndex = -1;
                    }
                }
            }
        }
        return profit;
    }
}
