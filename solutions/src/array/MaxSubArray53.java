package array;

/**
 * @author chenpengfei
 * @date 2020/7/2 12:16 上午
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 动态规划的思想，current_max其实就是指的是取了当前nums[i]能够形成的最大和
 */
public class MaxSubArray53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int current_max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 如果之前的最大和+目前值>目前值，那么取目前值+之前的最大值就是当下最大值（当下最大必须要取到目前值）
            if (current_max + nums[i] > nums[i]) {
                current_max = current_max + nums[i];
            }
            else {
                // 否则何必还需要之前的值呢？直接取目前值就好了
                current_max = nums[i];
            }
            if (current_max > max) {
                max = current_max;
            }
        }
        return max;
    }
}
