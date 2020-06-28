package unknown;

/**
 * @author chenpengfei
 * @date 2020/6/26 6:41 下午
 */
public class MyAtoi8 {
    public int myAtoi(String str) {
        str = str.trim();
        int len = str.length();
        boolean negitive = false;
        if (len == 0) {
            return 0;
        }
        if (str.charAt(0) == '-') {
            negitive = true;
            str = str.substring(1, len);
        }
        else if (str.charAt(0) == '+') {
            str = str.substring(1, len);
        }
        else if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            ;
        }
        else {
            return 0;
        }
        while (str.startsWith("0")) {
            str = str.substring(1);
        }
        int j = str.length();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                j = i;
                break;
            }
        }
        if (j > 10) {
            return negitive? Integer.MIN_VALUE: Integer.MAX_VALUE;
        }
        long result = 0;
        long a = 1;
        for (int i = 0; i < j; i++) {
            int x = j - i - 1;
            result += a * (long) (str.charAt(x) - '0');
            if (!negitive && result >= (long) Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            else if (negitive && result >= (long) Integer.MAX_VALUE + 1) {
                return Integer.MIN_VALUE;
            }
            a *= 10;
        }
        return negitive? (int) -result: (int) result;
    }
}
