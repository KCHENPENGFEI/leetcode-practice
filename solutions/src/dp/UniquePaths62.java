package dp;

public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        // 直接数学计算，但是数值溢出
        // if (m == 0 || n == 0) {
        //     return 0;
        // }
        // return helper(Math.min(m - 1, n - 1), m + n - 2);
        // dp动态规划
        // 保证m <= n
        if (m > n) {
            int tmp = n;
            n = m;
            m = tmp;
        }
        long[][] dp = new long[n + 1][n + 1];
        // 初始化
        for (int i = 0; i < n + 1; i++) {
            // dp[i][0] = 0;
            dp[0][i] = 0;
            dp[1][i] = 1;
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = i; j < n + 1; j++) {
                // 初始化
                if (i == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 1) {
                    dp[i][i] = 1;
                    continue;
                }
                if (i == j) {
                    dp[i][j] = 2 * dp[i - 1][j];
                }
                else {
                    dp[i][j] = (i + j - 2) * dp[i][j - 1] / (j - 1);
                }
            }
        }
        return (int) dp[m][n];
    }

    private int helper(int x, int y) {
        if (y == 0) {
            return 0;
        }
        // if (x == 0) {
        //     return 1;
        // }
        int a = 1;
        int b = 1;
        for (int i = 1; i <= x; i++) {
            a = a * (y - i + 1);
            b = b * i;
        }
        return a / b;
    }
}
