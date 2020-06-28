package dp;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * */
public class ClimbStairs70 {
    public int climbStairs(int n) {
        long a = 1L;
        long b = 1L;
        long sum;
        for (int i = 1; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return (int) a;
    }
}
