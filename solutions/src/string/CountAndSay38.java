package string;

/**
 * @author chenpengfei
 * @date 2020/7/5 1:14 上午
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 *
 * 注意：整数序列中的每一项将表示为一个字符串。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 *
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 *
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 *
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 *
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 *
 */
public class CountAndSay38 {
    public String countAndSay(int n) {
        String base = "1";
        int cnt = 1;
        while (cnt != n)  {
            base = parse(base);
            cnt++;
        }
        return base;
    }

    public String parse(String s) {
        int len = s.length();
        if (len == 1) {
            return "11";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 1;
        while (j < len) {
            if (s.charAt(j) != s.charAt(i)) {
                int quantity = j - i;
                sb.append(quantity)
                        .append(s.charAt(i));
                i = j;
            }
            j++;
        }
        sb.append(j - i)
                .append(s.charAt(i));
        return sb.toString();
    }
}
