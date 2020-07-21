package dp;

/**
 * @author chenpengfei
 * @date 2020/7/20 2:49 下午
 * codancer来到了一栋大楼前，现在他要上楼。
 *
 *
 * 如果codancer从第x层走楼梯到第y层(y>x)，那么他所花费的时间是a[x]+a[x+1]+…+a[y]；
 *
 *
 * 如果他从x层坐电梯到第y层，那么他所花费的时间是c+(b[x]+b[x+1]+…+b[y])，因为他等电梯的时间为c。
 *
 *
 * 现在codancer想知道从第1层到第n层需要最少需要多长时间？
 *
 * 做法：构造一个dp数组，长度为n，高度为2，第一行代表的是如果从上一层到这一层走楼梯花费的最小时间
 * 第二行代表的是如果从上一层到这一层坐电梯花费的最小时间
 * dp数组更新的时候就是按照从这一层去上一层是否要坐电梯即可。
 */
public class CodancerUpstairs {
    public long solution(int n, int c, int[] a, int[] b) {
        int[][] dp = new int[2][n];
        // 初始化
        dp[0][0] = 0;
        dp[1][0] = c;
        for (int i = 1; i <= n - 1; i++) {
            // 如果走楼梯
            dp[0][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + a[i - 1];
            // 如果坐电梯（如果之前不在电梯里面那么需要加上等待时间）
            dp[1][i] = Math.min(dp[0][i - 1] + c, dp[1][i - 1]) + b[i - 1];
        }
        return Math.min(dp[0][n - 1], dp[1][n - 1]);
    }
}
