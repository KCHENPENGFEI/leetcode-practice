package doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum15 {
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        ThreeSum15 threeSum15 = new ThreeSum15();
        System.out.println(threeSum15.threeSum2(nums));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return result;
        }
        // return threeSum1(nums);
        return threeSum2(nums);
    }

    // 回溯法
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> track = new LinkedList<Integer>();
        trackback(0, track, nums, 0);
        return result;
    }

    // 双指针法
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                }
                else if (sum < 0) {
                    j++;
                }
                else {
                    k--;
                }
            }
            i++;
        }
        return result;
    }

    public void trackback(int start, LinkedList<Integer> track, int[] nums, int sum) {
        if (track.size() == 3) {
            if (sum == 0) {
                result.add(new LinkedList<>(track));
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // 做剪枝
            if (track.size() == 0 && nums[i] > 0) {
                continue;
            }
            if (track.size() == 2 && nums[i] < 0) {
                continue;
            }
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            sum += nums[i];
            trackback(i + 1, track, nums, sum);
            sum -= nums[i];
            track.removeLast();
        }
    }
}
