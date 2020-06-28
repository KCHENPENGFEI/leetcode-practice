package doublePointer;

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
