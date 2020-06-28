package trackback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 思路: 使用回溯算法, 其中track为已经都是回文的子串，choose为剩下的字符串，
 * 每次从剩下的字符串中截取一个left，如果left是回文则添加进入track中，否则left向右延伸一位继续判断
 * 做法和第93题一样，算法优化的方案，修改isValid函数，可以利用一个dp数组来判断一个字符串是否为回文
 * */
public class Partition131 {
    static List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        String s = "aabb";
        Partition131 partition131 = new Partition131();
        System.out.println(partition131.partition(s));
    }
    public List<List<String>> partition(String s) {
        LinkedList<String> track = new LinkedList<>();
        trackback(0, track, s);
        return result;
    }

    public void trackback(int start, LinkedList<String> track, String s) {
        if (start == s.length()) {
            result.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String left = s.substring(start, i + 1);
            if (isValid(left)) {
                track.add(left);
                trackback(i + 1, track, s);
                track.removeLast();
            }
        }
    }

    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (s.equals(sb.reverse().toString())) {
            return true;
        }
        else {
            return false;
        }
    }
}
