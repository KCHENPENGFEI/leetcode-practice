package array;

/**
 * @author chenpengfei
 * @date 2020/7/9 1:03 上午
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。
 * 设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 * 做法一：暴力法求解
 */
public class Find132pattern456 {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            int rightMax = Integer.MIN_VALUE;
            boolean found1 = false;
            for (int k = i + 1; k < nums.length; k++) {
                if (nums[k] < nums[i]) {
                    rightMax = Math.max(rightMax, nums[k]);
                    found1 = true;
                }
            }
            if (!found1) {
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (nums[j] < rightMax) {
                    return true;
                }
            }
        }
        return false;
    }
}
