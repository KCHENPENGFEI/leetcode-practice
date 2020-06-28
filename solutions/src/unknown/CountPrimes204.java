package unknown;

import java.util.Arrays;

/**
 * @author chenpengfei
 * @date 2020/6/25 10:09 上午
 *
 * 统计所有小于非负整数 n 的质数的数量。
 * 做法: 如果i是素数，那么2i、3i、4i、...肯定不是质数，通过这种方式进行排除
 */
public class CountPrimes204 {
    int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrim[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                count++;
            }
        }

        return count;
    }
}
