package trackback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 *
 * 做法: 回溯循环中退出循环的判断是i < index + 3 && i < n, 因为sub最长就是3，并且遍历不能超过s的最后一位
 * 利用index和i来获取sub子串，如果sub子串满足ip的要求，那么压入队列中
 *
 * */
public class RestoreIpAddresses93 {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        int len = s.length();
        LinkedList<String> track = new LinkedList<>();
        trackback(0, track, s, len);
        return result;
    }

    private void trackback(int index, LinkedList<String> track, String s, int n) {
        if (track.size() >= 4) {
            if (index == n) {
                // 找到一个
                String ans = transform(track);
                result.add(ans);
            }
            return;
        }
        for (int i = index; i < index + 3 && i < n; i++) {
            if (track.size() == 4) {
                // 此时已经不可能出现符合提题意的答案，直接剪枝会使递归的层数少很多
                // 剪枝
                break;
            }
            String sub = s.substring(index, i + 1);
            if (sub.length() > 1 && sub.startsWith("0")) {
                // 如果出现"00", "010"这种无效的数字也直接剪枝
                // 剪枝
                break;
            }
            if (Integer.parseInt(sub) > 255) {
                // 数字已经大于255直接剪枝
                // 剪枝
                break;
            }
            track.addLast(sub);
            trackback(i + 1, track, s, n);
            track.removeLast();
        }
    }

    private String transform(LinkedList<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s: list) {
            sb.append('.');
            sb.append(s);
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }
}
