package unknown;

/**
 * @author chenpengfei
 * @date 2020/7/18 3:32 下午
 */
public class Fib10_1 {
    public int fib(int n) {
        return fib1(n);
    }
    public int fib2(int n) {
        int a = 0;
        int b = 1;
        int sum;
        for (int i = 1; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public int fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
