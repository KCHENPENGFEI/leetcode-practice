package dp;

import java.util.LinkedList;

/**
 * @author chenpengfei
 * @date 2020/6/26 12:07 下午
 */
public class LongestValidParentheses32 {

    // 使用栈处理
    public int longestValidParentheses1(String s) {
        assert s != null;
        if (s.length() < 2) {
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int max = 0;

        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                // 先把上一个'('弹出来
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                else {
                    max = Math.max(max, (i - stack.peek()));
                }
            }
        }
        return max;
    }

    /**
     * 使用动态规划，定义dp[i]为以i结尾能够形成的最长有效括号
     * */
    public int longestValidParentheses2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int max = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            if (chars[i] == ')') {
                if (chars[i - 1] == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                }
                else if (i - dp[i - 1] - 1 >= 0 && chars[i - dp[i - 1] - 1] == '(') {
                    dp[i] = (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
