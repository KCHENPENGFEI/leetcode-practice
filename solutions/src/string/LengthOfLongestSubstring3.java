package string;

/**
 * @author chenpengfei
 * @date 2020/7/4 9:40 上午
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s.length() == 0) {
            return 0;
        }
        else if (s.length() == 1) {
            return 1;
        }
        else {
            int i = 0;
            int j = 1;
            while (i < s.length() && j < s.length()) {
                if (s.substring(i, j).indexOf(s.charAt(j)) != -1) {
                    max = Math.max(j - i, max);
                    String save = s.substring(i, j);
                    // i要移动到重复元素的后面一位
                    i = i + save.indexOf(s.charAt(j)) + 1;
                }
                j++;
            }
            // 最后当j超过范围时候检测
            max = Math.max(j - i, max);
            return max;
        }
    }
}
