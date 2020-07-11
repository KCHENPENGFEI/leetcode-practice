package array;

/**
 * @author chenpengfei
 * @date 2020/7/9 1:03 上午
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
//    public boolean find132pattern1(int[] nums) {
//        if (nums.length < 3) {
//            return false;
//        }
//        int[] right = new int[nums.length];
//        int[] left = new int[nums.length];
//        for (int i = nums.length - 1; i >= 0; i--) {
//
//        }
//    }
}
