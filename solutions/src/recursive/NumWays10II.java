package recursive;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 做法1: 如果使用递归做法将会造成很多的重复计算，比如计算f(n - 1)和f(n)时，都会重新计算n - 2以下所有的结果
 * 做法2: 所以本题采用动态规划，f(n) = f(n - 1) + f(n - 2)，反复更新f(n - 1)和f(n - 2)就可以得到f(n)
 *
 * 求余运算规则： 设正整数 x, y, p, 求余符号为⊙, 则有 (x + y) ⊙ p = (x ⊙ p + y ⊙ p) ⊙ p。
 *
 * */
public class NumWays10II {
    public static void main(String[] args) {
        NumWays10II numWays10II = new NumWays10II();
        System.out.println(numWays10II.numWays(40));
    }
    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
