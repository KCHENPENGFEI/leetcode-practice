package trackback;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 对于组合不重复的结果时，先对数组进行排序，然后利用start进行遍历
 * start起始于i，对于i之前的数字，由于结果要求不能重复，所以没有必要进行重复遍历，这样可以大大节省时间
 * 1. 保存已经遍历的数字，对于后续再次遇到相同的数字时候可以使用continue跳过，不能使用return返回
 * 2. 如果不使用set进行存储，可以通过if (i > start && nums[i] == nums[i - 1])来判断是否重复，前提是数组是有序的
 * */
public class SubsetsWithDup90 {
    static List<List<Integer>> result = new LinkedList<>();

    public static void main(String[] args) {
        SubsetsWithDup90 subsetsWithDup90 = new SubsetsWithDup90();
        int[] nums = new int[]{4,4,4,1,4};
        subsetsWithDup90.subsetsWithDup(nums);
        System.out.println(result);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> track = new LinkedList<>();
        trackback(0, track, nums, nums.length);
        return result;
    }

    public void trackback(int start, LinkedList<Integer> track, int[] nums, int n) {
        result.add(new ArrayList<>(track));
        for (int i = start; i < n; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.addLast(nums[i]);
            trackback(i + 1, track, nums, n);
            track.removeLast();
        }
    }
}
