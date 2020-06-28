package trackback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation0808 {
    public static void main(String[] args) {
        String S = "eqq";
        Permutation0808 permutation0808 = new Permutation0808();
        System.out.println(Arrays.toString(permutation0808.permutation(S)));
    }
    List<String> resList = new ArrayList<>();
    public String[] permutation(String S) {
        List<Character> charList = S.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList());
        int len = S.length();
        if (len == 0) {
            return new String[]{};
        }
        StringBuilder track = new StringBuilder();
        trackback(track, charList, len);
        String[] res = new String[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public void trackback(StringBuilder track, List<Character> chars, int len) {
        if (track.length() == len) {
            // 出口
            resList.add(track.toString());
            return;
        }

        for (int i = 0; i < chars.size(); i++) {
            if (i > 0 && chars.get(i) == chars.get(i - 1)) {
                // 重复
                continue;
            }
            char c = chars.get(i);
            track.append(c);
            chars.remove(i);
            trackback(track, chars, len);
            chars.add(i, c);
            track.deleteCharAt(track.length() - 1);
        }
    }
}
