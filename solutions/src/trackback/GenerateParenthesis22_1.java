package trackback;

import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis22_1 {
    List<String> result = new LinkedList<>();

    public static void main(String[] args) {
        GenerateParenthesis22_1 generateParenthesis22_1 = new GenerateParenthesis22_1();
        System.out.println(generateParenthesis22_1.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        trackback(sb, n, 0, 0);
        return result;
    }

    public void trackback(StringBuilder track, int n, int left, int right) {
        // List<Character> choose = new ArrayList<>(Arrays.asList('(', ')'));
        if (left == n && right == n) {
            // 结束
            result.add(track.toString());
            return;
        }
        if (left < right) {
            return;
        }
        if (left < n) {
            trackback(track.append('('), n, left + 1, right);
            track.deleteCharAt(track.length() - 1);
        }
        if (right < n) {
            trackback(track.append(')'), n, left, right + 1);
            track.deleteCharAt(track.length() - 1);
        }
    }
}
