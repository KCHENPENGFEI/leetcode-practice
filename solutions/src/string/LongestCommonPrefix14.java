package string;

/**
 * @author chenpengfei
 * @date 2020/7/5 1:30 上午
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for (String s: strs) {
            result = both(result, s);
        }
        return result;
    }

    public String both(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(len1, len2); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                sb.append(s1.charAt(i));
            }
            else {
                break;
            }
        }
        return sb.toString();
    }
}
