package bit;

/**
 * @author chenpengfei
 * @date 2020/7/19 5:55 下午
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 * char和int是一样的，都是用亦或进行操作
 */
public class FindTheDifference389 {
    public char findTheDifference(String s, String t) {
        // 使用亦或
        char res = 0;
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i) ^ t.charAt(i);
        }
        res ^= t.charAt(t.length() - 1);
        return res;
    }
}
