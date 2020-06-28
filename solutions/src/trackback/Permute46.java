package trackback;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 全排列经典例题
 *
 * */
public class Permute46 {
    List<List<Integer>> result = new LinkedList<>();

    public static void main(String[] args) {
        Permute46 permute46 = new Permute46();
        int[] nums = new int[]{1,2,3};
        System.out.println(permute46.permute(nums));
    }
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        trackback(track, nums, nums.length);
        return result;
    }

    private void trackback(LinkedList<Integer> track, int[] choose, int n) {
        if (track.size() == n) {
            result.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (track.contains(choose[i])) {
                continue;
            }
            track.addLast(choose[i]);
            trackback(track, choose, n);
            track.removeLast();
        }
    }
}
