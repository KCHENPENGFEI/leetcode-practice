package dp;

/**
 * @author chenpengfei
 * @date 2020/7/31 11:08 上午
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 * 做法：定义dp[i][j]为s1[0...i]和s2[0...j]的最长公共子串的长度
 * 那么有以下转移方程
 * if (s1[i] == s2[j]) {
 *     dp[i][j] = dp[i - 1][j - 1] + 1;
 * }
 * else {
 *     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
 * }
 *
 */
public class LongestCommonSubsequence1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int[][] dp = new int[text1.length()][text2.length()];
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = chars1[i] == chars2[j]? 1: 0;
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = text2.substring(0, j + 1).contains(String.valueOf(chars1[i]))? 1: 0;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = text1.substring(0, i + 1).contains(String.valueOf(chars2[j]))? 1: 0;
                    continue;
                }
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }

    public int longestCommonSubsequence1(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
