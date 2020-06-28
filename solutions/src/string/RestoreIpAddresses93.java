package string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 解题思路: 使用回溯算法，先将s.length分割成1，2，3的因子，然后利用isValid去判断分割出来的是否有效
 * 参看回溯里面的做法(更优)
 */
public class RestoreIpAddresses93 {
    List<List<Integer>> mid = new ArrayList<>();
    int[] nums = new int[]{1, 2, 3};

    public static void main(String[] args) {
        String s = "2552551133";
        RestoreIpAddresses93 restoreIpAddresses93 = new RestoreIpAddresses93();
        System.out.println(restoreIpAddresses93.restoreIpAddresses(s));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        int len = s.length();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(track, len);
        for (int i = 0; i < mid.size(); i++) {
            if (!isValid(mid.get(i), s)) {
                continue;
            }
            String res = transform(mid.get(i), s);
            result.add(res);
        }
        return result;
    }

    public void backtrack(LinkedList<Integer> track, int len) {
        if (track.size() == 4) {
            // 判断是否等于目标值
            if (track.get(0) + track.get(1) + track.get(2) + track.get(3) == len) {
                mid.add(new LinkedList<>(track));
            }
            return;
        }
        for (int i = 1; i < 4; i++) {
            track.add(i);
            backtrack(track, len);
            track.removeLast();
        }
    }

    public boolean isValid(List<Integer> list, String s) {
        int start = 0;
        for (int i = 0; i < list.size(); i++) {
            String sub = s.substring(start, start + list.get(i));
            if (list.get(i) == 3) {
                int value = Integer.valueOf(sub);
                if (value > 255) {
                    return false;
                }
            }
            if (sub.startsWith("0") && sub.length() != 1) {
                return false;
            }
            start += list.get(i);
        }
        return true;
    }

    public String transform(List<Integer> list, String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < list.size(); i++) {
            sb.append(s.substring(start, start + list.get(i)));
            sb.append('.');
            start += list.get(i);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
