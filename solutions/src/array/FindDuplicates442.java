package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenpengfei
 * @date 2020/7/4 11:56 下午
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * 做法: 一次遍历数组，遍历到nums[i]时，将nums[nums[i] - 1]变成-nums[nums[i] - 1]，然后遇到重复的数字时
 * 就会发现nums[nums[i] - 1]是负数，那么这就是重复的数字
 */
public class FindDuplicates442 {
    public List<Integer> findDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num < 0) {
                num = -num;
            }
            int id = num - 1;
            if (nums[id] < 0) {
                ans.add(id + 1);
            }
            nums[id] = -nums[id];
        }
        return ans;
    }
}
