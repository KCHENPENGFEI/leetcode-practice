package unknown;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenpengfei
 * @date 2020/7/5 2:00 下午
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 做法: 统计字符个数，如果是偶数必然可以构成回文，如果是奇数那么减一成为偶数，然后最后加一（因为一个奇数可以放在最中间）
 */
public class LongestPalindrome409 {
    public int longestPalindrome(String s) {
        boolean all = true;
        int res = 0;
        // 用数组会更节省空间
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            }
            else {
                map.replace(c, map.get(c) + 1);
            }
        }
        for (char c: map.keySet()) {
            if (map.get(c) % 2 != 0) {
                all = false;
                res += map.get(c) - 1;
            }
            else {
                res += map.get(c);
            }
        }
        return all? res: res + 1;
    }

    public int longestPalindrome1(String s) {
        int[] cnt = new int[58];
        for (char c : s.toCharArray()) {
            cnt[c - 'A'] += 1;
        }

        int ans = 0;
        for (int x: cnt) {
            // 字符出现的次数最多用偶数次。
            ans += x - (x & 1);
        }
        // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
        return ans < s.length() ? ans + 1 : ans;
    }
}
