package array;

/**
 * @author chenpengfei
 * @date 2020/7/7 12:46 上午
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 做法: 当前数的乘积=左边所有数的乘积*右边所有数的乘积，一次正向循环求出左边所有数的乘积，一次反向循环求出右边所有数的乘积
 * 然后相乘即可
 *
 */
public class ProductExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int k = 1;
        for (int i = 1; i < len; i++) {
            ans[i - 1] = k;
            k = k * nums[i - 1];
        }
        ans[len - 1] = k;
        k = 1;
        for (int i = len - 2; i >= 0; i--) {
            ans[i + 1] = ans[i + 1] * k;
            k = k * nums[i + 1];
        }
        ans[0] = k;
        return ans;
    }
}
