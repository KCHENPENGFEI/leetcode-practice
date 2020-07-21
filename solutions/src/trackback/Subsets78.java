package trackback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 求子集
 * */
public class Subsets78 {
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        Subsets78 subsets78 = new Subsets78();
        int[] nums = new int[]{1,2,3};
        System.out.println(subsets78.subsets(nums));
    }
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> track = new LinkedList<>();
        result.add(track);
        trackback(0, track, nums);
        return result;
    }

    public void trackback(int start, LinkedList<Integer> track, int[] nums) {
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            track.add(num);
            result.add(new LinkedList<>(track));
            trackback(i + 1, track, nums);
            track.removeLast();
        }
    }
}
