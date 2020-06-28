package dp;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 做法: 有障碍物的地方dp[i][j]直接变成0，要注意的是如果障碍物在第一行或者第一列那么障碍物以及后面的dp[i][j]都要变成0
 * */
public class UniquePathsWithObstacles63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        boolean inFirstRow = false;
        boolean inFirstCol = false;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        // 先做初始化
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1 || inFirstCol) {
                dp[i][0] = 0;
                inFirstCol = true;
            }
            else {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1 || inFirstRow) {
                dp[0][i] = 0;
                inFirstRow = true;
            }
            else {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
