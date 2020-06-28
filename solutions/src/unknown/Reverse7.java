package unknown;

/**
 * @author chenpengfei
 * @date 2020/6/25 7:22 下午
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 如果翻转后越界，返回0
 */
public class Reverse7 {

    // 利用StringBuilder将数字进行翻转
    public int reverse1(int x) {
        boolean flag = false;
        long lx = x;
        if (lx < 0) {
            lx = -lx;
            flag = true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(lx);
        sb.reverse();
        String s = sb.toString();
        if (flag) {
            s = "-" + s;
        }
        long reverse = Long.parseLong(s);
        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reverse;
    }
}
