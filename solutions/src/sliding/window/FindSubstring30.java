package sliding.window;

import java.util.*;

/**
 * @author chenpengfei
 * @date 2020/6/26 10:40 上午
 *
 * 串联所有单词的子串
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 * 做法1: 回溯+剪枝（超时）
 * 做法2: 使用一个滑动窗口，长度为words拼接后的长度，在s上进行滑动，将窗口的字符串分隔后放入map中，然后和words中的单词做数量对比
 */
public class FindSubstring30 {

    // 滑动窗口
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int len = words.length;
        if (len == 0) {
            return ans;
        }
        int perLen = words[0].length();
        int allLen = len * perLen;
        HashMap<String ,Integer> matchMap = new HashMap<>();
        for (String word: words) {
            matchMap.put(word, matchMap.getOrDefault(word, 0) + 1);
        }
        int start = 0;
        while (start + allLen < s.length() + 1) {
            int startCopy = start;
            int nextStart = start + 1;
            int end = start + allLen;
            HashMap<String, Integer> map = new HashMap<>();
            while (start < end) {
                String subStr = s.substring(start, start + perLen);
                // 子串中出现了words中不存在的word直接跳出循环
                if (!matchMap.containsKey(subStr)) {
                    break;
                }
                map.put(subStr, map.getOrDefault(subStr, 0) + 1);
                start += perLen;
            }
            if (isEqual(map, matchMap)) {
                ans.add(startCopy);
            }
            start = nextStart;
        }
        return ans;
    }

    public boolean isEqual(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }
        for (String s: map1.keySet()) {
            if (!map1.get(s).equals(map2.get(s))) {
                return false;
            }
        }
        return true;
    }


    List<Integer> ans = new ArrayList<>();
    // 回溯法
    public List<Integer> findSubstring1(String s, String[] words) {
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
