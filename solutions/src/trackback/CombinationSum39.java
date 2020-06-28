package trackback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 * 做法: 回溯法，先对数组进行排序，计算sum = sum + num[i]，如果此时已经超过target直接剪枝
 * */
public class CombinationSum39 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> track = new LinkedList<>();
        trackback(0, track, candidates, target, 0, candidates.length);
        return result;
    }

    public void trackback(int start, LinkedList<Integer>track, int[] choose, int target, int sum, int n) {
        if (target == sum) {
            // 出口
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i < n; ++i) {
            int num = choose[i];
            if (sum + num > target) {
                // 直接剪枝
                break;
            }
            track.addLast(num);
            sum += num;
            trackback(i, track, choose, target, sum, n);
            sum -= num;
            track.removeLast();
        }
    }
}
