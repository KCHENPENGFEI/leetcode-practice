package trackback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 寻找组合数，使得组合数之和等于target
 * */
public class CombinationSum240 {
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        CombinationSum240 combinationSum240 = new CombinationSum240();
        System.out.println(combinationSum240.combinationSum2(candidates, target));

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int index = -1;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                index = i;
            }
            else {
                break;
            }
        }
        if (index == -1) {
            return result;
        }
        LinkedList<Integer> track = new LinkedList<>();
        trackback(0, track, candidates, target, index, 0);
        return result;
    }

    public void trackback(int start, LinkedList<Integer> track, int[] candidates, int target, int index, int sum) {
        if (sum == target) {
            // 出口
            result.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i <= index; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                // 重复跳过
                continue;
            }
            sum += candidates[i];
            if (sum > target) {
                // 超过时候进行剪枝，直接返回或者break
                return;
            }
            track.add(candidates[i]);
            trackback(i + 1, track, candidates, target, index, sum);
            track.removeLast();
            sum -= candidates[i];
        }
    }
}
