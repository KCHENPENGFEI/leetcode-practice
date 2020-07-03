package doublePointer;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的子数组，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 * 双指针法: 当左指针和右指针之前的和小于s时，右指针不断右移增大sum，和超过sum时候左指针不断右移减小sum
 * */
public class MinSubArrayLen209 {
    public static void main(String[] args) {
        int s = 7;
        int[] nums = new int[]{2,3,1,2,4,3};
        MinSubArrayLen209 minSubArrayLen209 = new MinSubArrayLen209();
        System.out.println(minSubArrayLen209.minSubArrayLen1(s, nums));
        System.out.println(minSubArrayLen209.minSubArrayLen2(s, nums));
    }
    public int minSubArrayLen1(int s, int[] nums) {
        // 暴力法
        int result = Integer.MAX_VALUE;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (j > i) {
                    sum += nums[j];
                }
                if (sum >= s) {
                    // 找到
                    result = Math.min(result, j - i + 1);
                    flag = true;
                    break;
                }
            }
        }
        return flag? result: 0;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        // 双指针
//        int l = 0;
//        int r = 0;
//        int sum = 0;
//        int result = Integer.MAX_VALUE;
//        boolean flag = false;
//        while (r < nums.length) {
//            sum += nums[r];
//            while (sum >= s) {
//                result = Math.min(result, r - l + 1);
//                flag = true;
//                sum -= nums[l];
//                l++;
//            }
//            r++;
//        }
//        return flag? result: 0;
        int l = 0, r = 0, sum = nums[0];
        int minLen = Integer.MAX_VALUE;
        while (r < nums.length) {
            if (sum >= s) {
                minLen = Math.min(minLen, r - l + 1);
                sum -= nums[l];
                // 左指针右移
                l++;
            }
            else {
                r++;
                // 因为这里r++了所以要加一层判断是否越界
                if (r < nums.length) {
                    sum += nums[r];
                }
            }
        }
        return l == 0? 0: minLen;
    }
}
