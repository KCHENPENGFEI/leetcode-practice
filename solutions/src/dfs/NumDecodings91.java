package dfs;

/**
 * @author chenpengfei
 * @date 2020/7/4 11:02 下午
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 做法一: dfs遍历，超时
 */
public class NumDecodings91 {
    int ans = 0;
    public int numDecodings(String s) {
        dfs(0, s, s.length());
        return ans;
    }

    public void dfs(int start, String s, int len) {
        if (start == len) {
            ans++;
            return;
        }
        for (int i = start; i < start + 2; i++) {
            if (i == start && s.charAt(i) == '0') {
                break;
            }
            if (i >= len) {
                break;
            }
            int num = trans(start, i, s);
            if (num >= 1 && num <= 26) {
                dfs(i + 1, s, len);
            }
        }
    }

    public int trans(int i, int j, String s) {
        return Integer.parseInt(s.substring(i, j + 1));
    }
}
