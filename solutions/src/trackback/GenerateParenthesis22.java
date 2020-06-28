package trackback;

import java.util.*;

/**
 * 思路有二: 本题中是将所有排列都算了出来，然后通过isValid进行筛选
 * 第二种思路是在for循环中进行剪枝，这样的速度会更快
 *
 * */
public class GenerateParenthesis22 {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        trackback(sb, n, n, n);
        return result;
    }

    public void trackback(StringBuilder track, int n, int left, int right) {
        if (track.length() == n * 2) {
            // 出口
            result.add(track.toString());
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            // 左括号还有，插入左括号
            track.append('(');
            trackback(track, n, left - 1, right);
            track.deleteCharAt(track.length() - 1);
        }
        if (right > 0) {
            // 右括号还有，插入右括号
            track.append(')');
            trackback(track, n, left, right - 1);
            track.deleteCharAt(track.length() - 1);
        }
    }
}
