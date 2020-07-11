package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author chenpengfei
 * @date 2020/7/8 9:29 下午
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class FirstUniqChar387 {
    public int firstUniqChar(String s) {
        if ("".equals(s)) {
            return -1;
        }
        List<Character> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (char c: s.toCharArray()) {
            if (!set.contains(c)) {
                // 不存在则都加如
                list.add(c);
                set.add(c);
            }
            else {
                // 重复则删除
                list.remove(Character.valueOf(c));
            }
        }
        if (list.size() == 0) {
            return -1;
        }
        return s.indexOf(list.get(0));
    }
}
