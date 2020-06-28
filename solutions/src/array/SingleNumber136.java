package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenpengfei
 * @date 2020/6/27 10:36 上午
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 要求使用O(N)时间复杂度，O(1)空间复杂度
 */
public class SingleNumber136 {
    // 位运算
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    // 使用了哈希表进行存储
    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i: nums) {
            if (cnt.keySet().contains(i)) {
                cnt.put(i, cnt.get(i) + 1);
            }
            else {
                cnt.put(i, 1);
            }
        }

        for (int key: cnt.keySet()) {
            if (cnt.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }
}
