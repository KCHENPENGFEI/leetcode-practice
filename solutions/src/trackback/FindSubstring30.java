package trackback;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author chenpengfei
 * @date 2020/6/25 5:22 下午
 */
public class FindSubstring30 {
    List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word", "good", "best"};
        FindSubstring30 findSubstring = new FindSubstring30();
        System.out.println(findSubstring.findSubstring(s, words));
    }
    public List<Integer> findSubstring(String s, String[] words) {
        int len = words.length;
        if (len == 0) {
            return new ArrayList<>();
        }
        StringBuilder sb = new StringBuilder();
        int wordLen = words[0].length();
        Set<Integer> set = new HashSet<>();
        trackback(sb, s, words, 0, len, wordLen, set);
        return ans;
    }

    public void trackback(StringBuilder track, String s, String[] words, int cnt, int n, int wordLen, Set<Integer> set) {
        Set<String> record = new HashSet<>();
        if (cnt == n) {
            String str = track.toString();
            int start = 0;
            while (s.indexOf(str, start) != -1) {
                int id = s.indexOf(str, start);
                ans.add(id);
                start = id + 1;
            }
            return;
        }
        if (!s.contains(track.toString())) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (set.contains(i)) {
                continue;
            }
            if (record.contains(words[i])) {
                continue;
            }
            track.append(words[i]);
            set.add(i);
            record.add(words[i]);
            trackback(track, s, words, cnt + 1, n, wordLen, set);
            track.delete(track.length() - wordLen, track.length());
            set.remove(i);
        }
    }
}
