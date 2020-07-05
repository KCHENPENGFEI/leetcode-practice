package array;

import java.util.Arrays;

/**
 * @author chenpengfei
 * @date 2020/7/5 2:38 下午
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j),
 * 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
 *
 */
public class FindPairs532 {
    public int findPairs(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = k + nums[i];
            if (target > nums[nums.length - 1]) {
                break;
            }
            if (findTarget(nums, target, i + 1) != -1) {
                ans++;
            }
        }
        return ans;
    }

    public int findTarget(int[] nums, int target, int start) {
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            else if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
