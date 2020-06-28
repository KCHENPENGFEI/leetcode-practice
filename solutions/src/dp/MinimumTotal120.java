package dp;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 * 做法: 构建一个dp数组，只处理行数大于等于列数的dp元素
 * */
public class MinimumTotal120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 获取三角形底部长度
        int maxSize = triangle.size();
        if (maxSize == 0) {
            return 0;
        }
        if (maxSize == 1) {
            int trueSize = triangle.get(0).size();
            if (trueSize == 0) {
                return 0;
            }
        }
        int[][] dp = new int[maxSize][maxSize];
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                if (i == 0 && j == 0) {
                    // 处理第一个元素
                    dp[i][j] = triangle.get(i).get(j);
                }
                else if (j == 0) {
                    // 处理第一列元素
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j];
                }
                else if (i == j) {
                    // 处理对角线元素，就是三角形右边上的元素
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j - 1];
                }
                else if (i > j) {
                    // 处理三角形内部元素
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }
        int[] lastRow = dp[maxSize - 1];
        Arrays.sort(lastRow);
        return lastRow[0];
    }
}
