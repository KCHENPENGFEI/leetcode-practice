package dp;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 做法: 我们定义dp[i][j]为以(i, j)为右下角能形成最大正方形的面积
 * 状态转移方程式dp(i, j) = (sqrt(min(dp(i - 1, j), dp(i, j - 1), dp(i - 1, j - 1))) + 1)^2
 * */
public class MaximalSquare221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int max = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 初始化
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                }
                else {
                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    }
                    else {
                        int min = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                        double maxSqrt = Math.sqrt(min) + 1;
                        dp[i][j] = (int) (maxSqrt * maxSqrt);
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
