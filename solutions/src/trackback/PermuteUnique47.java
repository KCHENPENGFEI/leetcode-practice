package trackback;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 做法1: 不断更新choose
 * 做法2: 不更新choose，但是需要一个set来记录已经遍历的数字的位置，另外为了不出现重复的情况，使用record来记录
 * */
public class PermuteUnique47 {

    List<List<Integer>> result = new LinkedList<>();

    public static void main(String[] args) {
        PermuteUnique47 permuteUnique47 = new PermuteUnique47();
        int[] nums = new int[]{1,1,2,2,3,3};
        System.out.println(permuteUnique47.permuteUnique(nums));
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        LinkedList<Integer> track = new LinkedList<>();
        trackback(track, numsList, nums.length);
        return result;
    }

    public void trackback(LinkedList<Integer> track, List<Integer> choose, int n) {
        Set<Integer> record = new HashSet<>();
        if (track.size() == n) {
            result.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < choose.size(); i++) {
            if (record.contains(choose.get(i))) {
                continue;
            }
            else {
                record.add(choose.get(i));
            }
            track.add(choose.get(i));
            // 更新choose
            int r = choose.remove(i);
            trackback(track, choose, n);
            choose.add(i, r);
            track.removeLast();
        }
    }

    public List<List<Integer>> permuteUnique1(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        trackback1(track, nums, nums.length, set);
        return result;
    }

    private void trackback1(LinkedList<Integer> track, int[] choose, int n, Set<Integer> set) {
        if (track.size() == n) {
            result.add(new LinkedList<>(track));
            return;
        }
        // record用来记录是否出现重复的数字
        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (record.contains(choose[i])) {
                continue;
            }
            // set用来记录已经遍历过的位置
            if (set.contains(i)) {
                continue;
            }
            // record不需要移除，因为重复出现的数字就是不需要再次搜索了
            record.add(choose[i]);
            set.add(i);
            track.addLast(choose[i]);
            trackback1(track, choose, n, set);
            track.removeLast();
            // set需要移除，因为就算是遍历过的位置还是需要重复遍历的
            set.remove(i);
        }
    }
}
