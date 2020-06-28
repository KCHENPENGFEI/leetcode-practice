package dp;

/**
 * 求最长升序子串
 * 法一: 使用dp算法，时间复杂度为O(N^2)
 * dp算法注意的是不能改变已经完成的值, 每次修改的都是dp[i]
 * 法二: dp+二分法，时间复杂度为O(N*logN)
 * */
public class LengthOfLIS300 {
    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,3,5,6,3,18};
        LengthOfLIS300 lengthOfLIS300 = new LengthOfLIS300();
        System.out.println(lengthOfLIS300.lengthOfLIS1(nums));
    }
    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS1(nums);
    }

    // 动态规划
    public int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        int result = 1;
        for (int i = 0; i < len; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            result = Math.max(result, max);
        }
        return result;
    }
}
