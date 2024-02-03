package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenpengfei
 * @date 2020/7/5 3:08 下午
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，
 * 并且 i 和 j 的差的 绝对值 至多为 k。
 * 做法: 使用哈希表建立元素和下标的关系
 */
public class ContainsNearbyDuplicate219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
            else {
                // 遇到相同的元素判断距离是否<=k
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
                else {
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }
}
