package trackback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 做法: 回溯法，先对数组进行排序，计算sum = sum + num[i]，如果此时已经超过target直接剪枝
 * */
public class CombinationSum40 {
    public static void main(String[] args) {
        CombinationSum40 combinationSum40 = new CombinationSum40();
        int[] arr = new int[]{1,1,2,5,6,7,10};
        int target = 8;
        System.out.println(combinationSum40.combinationSum2(arr, target));
    }
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> track = new LinkedList<>();
        trackback(0, track, candidates, target, 0, candidates.length);
        return result;
    }

    private void trackback(int start, LinkedList<Integer>track, int[] choose, int target, int sum, int n) {
        if (target == sum) {
            // 出口
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i < n; ++i) {
            // 重复情况，跳过该分支
            if (i > start && choose[i] == choose[i - 1]) {
                continue;
            }
            int num = choose[i];
            if (sum + num > target) {
                // 直接剪枝
                break;
            }
            track.addLast(num);
            sum += num;
            // 数组中数字只能使用一次，所以i + 1
            trackback(i + 1, track, choose, target, sum, n);
            sum -= num;
            track.removeLast();
        }
    }
}
