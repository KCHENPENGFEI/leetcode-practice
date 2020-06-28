package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenpengfei
 * @date 2020/6/24 10:42 下午
 */
public class NumberOfArithmeticSlices413 {
    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length;
        if (len < 3) {
            return 0;
        }
        int[] diff = new int[len];
        diff[0] = 0;
        for (int i = 1; i < len; i++) {
            diff[i] = A[i] - A[i - 1];
        }
        List<Integer> list = new ArrayList<>();
        int max = 0;
        int i = 0, j = 0;
        while (j < len) {
            if (j != len - 1) {
                if (i == j && diff[i] != diff[i + 1]) {
                    i++;
                    j++;
                }
                else if (i == j && diff[i] == diff[i + 1]) {
                    j++;
                }
                else if (i != j && diff[j] == diff[j + 1]) {
                    j++;
                }
                else {
                    max = Math.max(max, j - i + 2);
                    list.add(j - i + 2);
                    j++;
                    i = j;
                }
            }
            else {
                if (i != j) {
                    int ll = 0;
                    if (i == 0) {
                        ll = j - i + 1;
                    }
                    else {
                        ll = j - i + 2;
                    }
                    max = Math.max(max, ll);
                    list.add(ll);
                }
                j++;
            }
        }
        if (max < 3) {
            return 0;
        }
        System.out.println(max);
        int[] dp = helper(max);
        int ans = 0;
        for (int num: list) {
            ans += dp[num];
        }
        return ans;
    }

    private int[] helper(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 0;
        result[2] = 0;
        result[3] = 1;
        for (int i = 4; i <= n; i++) {
            result[i] = (i - 1) * (i - 2) / 2;
        }
        return result;
    }
}
