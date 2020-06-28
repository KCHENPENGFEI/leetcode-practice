package trackback;

/**
 * 计算各个位数不同的数字个数
 * 思路1: 回溯法进行搜索，要注意的是以0开头的时候会出现重复数字，解决办法是当0开头时候直接跳过判断
 * 然后在最后结果加上1(加入0这个数字)
 * 思路2: 数学计算法,也是动态规划法,1位数字不重复有10个，2位数字不重复的有9*9个，3位数字不重复的有9*9*8个(数学排列组合)
 *
 *
 * */
public class CountNumbersWithUniqueDigits357 {
    int result = 0;

    public static void main(String[] args) {
        CountNumbersWithUniqueDigits357 countNumbersWithUniqueDigits357 = new CountNumbersWithUniqueDigits357();
//        System.out.println(countNumbersWithUniqueDigits357.countNumbersWithUniqueDigits(3));
        System.out.println(countNumbersWithUniqueDigits357.countNumbersWithUniqueDigits1(3));
    }
    public int countNumbersWithUniqueDigits(int n) {
        StringBuilder track = new StringBuilder();
        trackback(track, n);
        return result + 1;
    }

    public int countNumbersWithUniqueDigits1(int n) {
        for (int i = 1; i <= Math.min(n, 10); i++) {
            result += dp(i);
        }
        return result;
    }

    public int dp(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        if (n == 2) {
            return 81;
        }
        if (n > 10) {
            n = 10;
        }
        int a = (11 - n) * dp(n - 1);
        return a;
    }


    public void trackback(StringBuilder track, int n) {
        if (track.length() == n) { return; }
        for (int i = 0; i < 10; i++) {
            if (track.length() == 0 && i == 0) {
                continue;
            }
            if (track.indexOf(String.valueOf(i)) == -1) {
                track.append(i);
                result++;
                trackback(track, n);
                track.deleteCharAt(track.length() - 1);
            }
        }
    }
}
