package string;

/**
 * @author chenpengfei
 * @date 2020/7/5 1:23 下午
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。
 * 杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 */
public class CanConstruct383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] a = new int[26];
        int[] b = new int[26];
        for (char c: ransomNote.toCharArray()) {
            a[c - 'a']++;
        }
        for (char c: magazine.toCharArray()) {
            b[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (a[i] > b[i]) {
                return false;
            }
        }
        return true;
    }
}
