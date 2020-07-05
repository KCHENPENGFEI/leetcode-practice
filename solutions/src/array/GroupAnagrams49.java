package array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chenpengfei
 * @date 2020/6/26 4:21 下午
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams1(String[] strs) {
        ArrayList<String> strsList = new ArrayList<>(Arrays.asList(strs));
        List<List<String>> res = new ArrayList<>();
        while (strsList.size() != 0) {
            List<String> anaList = new ArrayList<>();
            String item = strsList.get(0);
            strsList.remove(0);
            anaList.add(item);
            int pointer = 0;
            while (pointer < strsList.size()) {
                if (isAnagram(item, strsList.get(pointer))) {
                    anaList.add(strsList.get(pointer));
                    strsList.remove(pointer);
                    continue;
                }
                pointer++;
            }
            res.add(anaList);
        }
        return res;
    }

    public boolean isAnagram(String t, String s) {
        if (t.length() != s.length()) {
            return false;
        }
        int[] ti = new int[26];
        int[] si = new int[26];
        for (int i = 0; i < t.length(); i++) {
            ti[t.charAt(i) - 'a']++;
            si[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < 26; j++) {
            if (ti[j] != si[j]) {
                return false;
            }
        }
        return true;
    }

    // 构造了一个int[len][26]的统计字符用的二维数组去判断单词是否异位
    public List<List<String>> groupAnagrams2(String[] strs) {
        int len = strs.length;
        int[][] match = new int[len][26];
        List<List<String>> res = new ArrayList<>();
        for (String word: strs) {
            helper(res, word, match);
        }
        return res;
    }

    public void helper(List<List<String>> res, String word, int[][] match) {
        int size = res.size();
        int[] trans = generate(word);
        for (int i = 0; i < size; i++) {
            if (matchArr(trans, match[i])) {
                res.get(i).add(word);
                return;
            }
        }
        match[size] = trans;
        List<String> newList = new ArrayList<>();
        newList.add(word);
        res.add(newList);
    }

    public boolean matchArr(int[] trans, int[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (trans[i] != chars[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] generate(String word) {
        int[] res = new int[26];
        for (char c: word.toCharArray()) {
            res[c - 'a']++;
        }
        return res;
    }

    // 利用一个Map，将异位的单词进行排序作为key，然后将他们放入Map中，速度较快
    public List<List<String>> groupAnagrams3(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs.length == 0) {
            return ans;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            List<String> a = map.getOrDefault(key, new ArrayList<>());
            a.add(s);
            map.put(key, a);
        }
        return new ArrayList<>(map.values());
    }
}
