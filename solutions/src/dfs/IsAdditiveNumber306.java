package dfs;

/**
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 * */
public class IsAdditiveNumber306 {
    boolean flag = false;
    public static void main(String[] args) {
        String num = "101";
        IsAdditiveNumber306 isAdditiveNumber306 = new IsAdditiveNumber306();
        System.out.println(isAdditiveNumber306.isAdditiveNumber1(num));
    }
    public boolean isAdditiveNumber(String num) {
        return dfs(num, num.length(), 0, 0, 0, 0);
    }

    public boolean isAdditiveNumber1(String num) {
        trackback(0, num, num.length(), 0, 0, 0);
        return flag;
    }

    // 回溯法思路其实和dfs十分类似
    private void trackback(int start, String num, int len, long sum, long pre, int k) {
        if (start == len) {
            if (k > 2) {
                // 成立
                flag = true;
            }
            return;
        }
        if (flag) {
            return;
        }
        for (int i = start; i < len; i++) {
            long cur = fetchCurValue(num, start, i);
            // 数字无效直接break
            if (cur < 0) {
                break;
            }
            // 因为是排序的所以可以直接break
            if (sum < cur && k >= 2) {
                break;
            }
            if (sum > cur && k >= 2) {
                continue;
            }
            trackback(i + 1, num, len, cur + pre, cur, k + 1);
        }
    }

    /**
     * @param num    原始字符串
     * @param len    原始字符串长度
     * @param idx    当前处理下标
     * @param sum    前面的两个数字之和
     * @param pre    前一个数字
     * @param k      当前是处理的第几个数字
     */
    private boolean dfs(String num, int len, int idx, long sum, long pre, int k) {
        if (idx == len) {
            return k > 2;
        }
        for (int i = idx; i < len; i++) {
            long cur = fetchCurValue(num, idx, i);
            // 剪枝：无效数字
            if (cur < 0) {
                continue;
            }
            // 剪枝：当前数字不等于前面两数之和
            if (k >= 2 && cur != sum) {
                continue;
            }
            if (dfs(num, len, i + 1, pre + cur, cur, k + 1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取 l ~ r 组成的有效数字
     */
    private long fetchCurValue(String num, int l, int r) {
        if (l < r && num.charAt(l) == '0') {
            return -1;
        }
        long res = 0;
        while (l <= r) {
            res = res * 10 + num.charAt(l++) - '0';
        }
        return res;
    }
}
