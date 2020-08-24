package dp;

import java.util.List;

/**
 * @author chenpengfei
 * @date 2020/7/5 10:22 上午
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 做法: 定义dp[i]为字符串下标为i时，是否满意足题意，那么有
 * dp[j] = dp[i] && wordDict.contains(s.substring(i + 1, j + 1))就是说入如果dp[i]是true，那么i-j之间的单词
 * 如果在wordDict中那么dp[j]就位true
 */
public class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 动态规划定义dp[i]为当数组下标为i时，是否满足题意
        int len = s.length();

        boolean[] dp = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (wordDict.contains(s.substring(0, i + 1))) {
                dp[i] = true;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j + 1, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len - 1];
    }
}
