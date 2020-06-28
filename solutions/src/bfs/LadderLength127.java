package bfs;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 *
 * 做法1: 标准bfs做法
 * */
public class LadderLength127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return bfs(beginWord, endWord, wordList);
    }

    private int bfs(String beginWord, String endWord, List<String> wordList) {
        Queue<String> stack = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        boolean success = false;
        int step = 0;
        // 将beginWord压入栈中
        stack.offer(beginWord);
        visited.add(beginWord);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                String pollWord = stack.poll();
                // 判断是否为endWord
                if (pollWord.equals(endWord)) {
                    // 结束
                    success = true;
                    return ++step;
                }
                for (String word: wordList) {
                    if (canTransform(pollWord, word) && !visited.contains(word)) {
                        // 入栈
                        stack.offer(word);
                        visited.add(word);
                    }
                }
            }
            step++;
        }
        if (!success) {
            return 0;
        }
        return step;
    }

    private boolean canTransform(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}
