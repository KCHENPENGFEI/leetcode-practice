package bit;

/**
 * @author chenpengfei
 * @date 2020/7/19 6:00 下午
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 */
public class HammingWeight191 {
    public int hammingWeight(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            cnt += n & 1;
            n >>>= 1;
        }
        return cnt;
    }
}
