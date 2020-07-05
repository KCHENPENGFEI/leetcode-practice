package dp;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * 做法: allSum[i]为以i为结尾的所有数的和
 * */
public class NumArray303 {
    private final int[] allSum;

    public NumArray303(int[] nums) {
        this.allSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                this.allSum[i] = nums[i];
            }
            else {
                this.allSum[i] = this.allSum[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return this.allSum[j];
        }
        return this.allSum[j] - this.allSum[i - 1];
    }
}
