package array;

/**
 * @author chenpengfei
 * @date 2020/7/5 3:15 下午
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 */
public class FindMaxAverage643 {
    public double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        // 初始化
        for (int j = 0; j < k; j++) {
            sum += nums[j];
            max = sum;
        }
        for (int i = 1; i < nums.length - k + 1; i++) {
            // 减去移出的元素
            sum -= nums[i - 1];
            // 加上新增的元素
            sum += nums[i + k - 1];
            max = Math.max(max, sum);
        }
        return ((double) max) / ((double) k);
    }
}
