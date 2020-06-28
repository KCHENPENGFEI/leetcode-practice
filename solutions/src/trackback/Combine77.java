package trackback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 这里注意的是比如[1,2]是有效的，但是[2,1]是无效的，所以可以直接利用start参数正向遍历即可
 * */
public class Combine77 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        trackback(1, k, track, n);
        return result;
    }

    public void trackback(int start, int k, LinkedList<Integer> track, int n) {
        if (track.size() == k) {
            // 出口
            result.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            trackback(i + 1, k, track, n);
            track.removeLast();
        }
    }
}
