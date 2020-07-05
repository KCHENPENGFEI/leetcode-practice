package unknown;

/**
 * @author chenpengfei
 * @date 2020/7/4 10:09 上午
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 拆出尽可能多的3
 */
public class IntegerBreak343 {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int cnt = 0;
        while (n >= 3) {
            n -= 3;
            cnt++;
        }
        if (n == 0) {
            return (int) Math.pow(3, cnt);
        }
        else if (n == 1) {
            cnt--;
            return (int) Math.pow(3, cnt) * 4;
        }
        else {
            return (int) Math.pow(3, cnt) * 2;
        }
    }
}
