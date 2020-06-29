package trie;

import java.util.*;

/**
 * @author chenpengfei
 * @date 2020/6/29 8:10 下午
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。
 *
 * 做法一: 暴力法，利用set进行搜索
 * 做法二: 使用字典树 // TODO
 *
 */
public class LongestWord720 {
    public String longestWord(String[] words) {
        List<String> ans = new ArrayList<>();
        int maxLen = 0;
        if (words.length == 0) {
            return "";
        }
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word: set) {
            if (helper(word, set)) {
                if (word.length() > maxLen) {
                    ans = new ArrayList<>();
                    ans.add(word);
                    maxLen = word.length();
                }
                else if (word.length() == maxLen) {
                    ans.add(word);
                }
            }
        }
        Collections.sort(ans);
        if (ans.size() == 0) {
            return "";
        }
        return ans.get(0);
    }

    public boolean helper(String word, Set<String> set) {
        if (word.length() == 1 && set.contains(word)) {
            return true;
        }
        if (!set.contains(word)) {
            return false;
        }
        return helper(word.substring(0, word.length() - 1), set);
    }
}
