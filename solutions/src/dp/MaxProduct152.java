package dp;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 做法: 动态规划
 * */
public class MaxProduct152 {
    public int maxProduct(int[] nums) {
        return maxProduct1(nums);
    }

    public int maxProduct1(int[] nums) {
        // 暴力求解
        if (nums.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = 1;
            for (int j = i; j < nums.length; j++) {
                x = x * nums[j];
                if (x > result) {
                    result = x;
                }
            }
        }
        return result;
    }

    public int maxProduct2(int[] nums) {
        // 动态规划
        // 定义imax[i]为以nums[i]为结尾的子串的乘积最大值
        // 定义imin[i]为以nums[i]为结尾的子串的乘积最小值
        if (nums.length == 0) {
            return 0;
        }
        int[] imax = new int[nums.length];
        int[] imin = new int[nums.length];
        imax[0] = nums[0];
        imin[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                // 由于负的nums[i]会使得越大的数字乘积之后变得越小，所以计算时候需要将imax和imin换位
                imax[i] = Math.max(imin[i - 1] * nums[i], nums[i]);
                imin[i] = Math.min(imax[i - 1] * nums[i], nums[i]);
            }
            else {
                // 大于等于0不用换位
                imax[i] = Math.max(imax[i - 1] * nums[i], nums[i]);
                imin[i] = Math.min(imin[i - 1] * nums[i], nums[i]);
            }
            if (imax[i] > max) {
                max = imax[i];
            }
        }
        return max;
    }
}
