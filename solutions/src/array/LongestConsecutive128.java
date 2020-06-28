package array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chenpengfei
 * @date 2020/6/25 10:51 上午
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 * 做法: 1. 首先使用HashSet对数组进行去重
 *       2. 遍历数组每一个元素i，如果HashSet中存在i-1这个数字，说明元素i肯定不是构成最长序列的第一个元素，直接跳过
 *       3. 如果元素i是第一个元素，那么考察i+1、i+2、...是否在HashSet中，然后统计长度即可
 */
public class LongestConsecutive128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int maxLen = 0;
        for (int num: nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int curLen = 1;
            while (set.contains(num + 1)) {
                curLen++;
                num++;
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }
}
