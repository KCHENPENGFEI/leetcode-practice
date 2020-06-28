package trackback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 节约时间的地方在于cal函数，计算了start开始的值，避免了所有情况都从1开始计数
 * */
public class CombinationSum3216 {
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int k = 3; int n = 10;
        CombinationSum3216 combinationSum3216 = new CombinationSum3216();
        System.out.println(combinationSum3216.combinationSum3(k, n));
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        LinkedList<Integer> track = new LinkedList<>();
        trackback(track, cal(k, n), n, k);
        return result;
    }

    int cal(int k , int n) {
        int res = 0;
        for (int i = 1; i < k; i++) {
            n = n - (10 - i);
        }
        return (n > 0)? n: 1;
    }

    public void trackback(LinkedList<Integer> track, int start, int n, int k) {
        if (track.size() == k) {
            // 出口
            LinkedList<Integer> trackBak = new LinkedList<>(track);
            if (sum(trackBak) == n) {
                result.add(trackBak);
            }
            return;
        }
        for (int i = start; i <= n - k + 1 && i <= 9; i++) {
            track.add(i);
            trackback(track, i + 1, n, k);
            track.removeLast();
        }
    }

    public int sum(LinkedList<Integer> track) {
        int res = 0;
        for (Integer i: track) {
            res += i;
        }
        return res;
    }
}
