package binarySearch;

/**
 * @author chenpengfei
 * @date 2020/6/26 3:03 下午
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c。
 */
public class JudgeSquareSum633 {
    public boolean judgeSquareSum1(int c) {
        int max = (int) Math.floor(Math.sqrt(c));
        int i = 0;
        int j = max;
        while (i <= j) {
            if ((i * i + j * j) < c) {
                i++;
            }
            else if ((i * i + j * j) > c) {
                j--;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum2(int c) {
        int max = (int) Math.sqrt(c);
        for (int a = 0; a <= max; a++) {
            // 可以优化一下循环
            int b = find(c - a * a, 0, max);
            if (b != -1) {
                return true;
            }
        }
        return false;
    }

    public int find(int y, int l, int r) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid * mid < y) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        if (l * l == y) {
            return l;
        }
        return -1;
    }
}
