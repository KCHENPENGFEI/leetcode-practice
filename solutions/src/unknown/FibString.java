package unknown;

/**
 * @author chenpengfei
 * @date 2020/7/18 4:14 下午
 */
public class FibString {

    public static void main(String[] args) {
        int n = 135;
        int k = 6749;
        System.out.println(FibString.solution(n, k));
    }
    public static int solution(int n, int k) {
        long[] dp = new long[n + 1];
        dp[0] = 0L;
        if (n < 3) {
            if (k > 1) {
                return -1;
            }
            if (n == 1) {
                return 0;
            }
            if (n == 2) {
                return 1;
            }
        }
        dp[1] = 1L;
        dp[2] = 1L;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        if (k > dp[n]) {
            return -1;
        }
        int res = solve(k, dp, n);
        return res;
    }

    public static int solve(long k, long[] dp, int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        // int len = dp[n];
        // int preLen1 = dp[n - 1];
        long preLen2 = dp[n - 2];
        if (k <= preLen2) {
            return solve(k, dp, n - 2);
        } else {
            return solve(k - preLen2, dp, n - 1);
        }
    }
}
