package dp;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * */
public class MinPathSum64 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
                else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
