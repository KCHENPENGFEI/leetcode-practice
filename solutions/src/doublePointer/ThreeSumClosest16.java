package doublePointer;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * */
public class ThreeSumClosest16 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,1,55};
        int target = 3;
        ThreeSumClosest16 threeSumClosest16 = new ThreeSumClosest16();
        System.out.println(threeSumClosest16.threeSumClosest(nums, target));
    }
    public int threeSumClosest(int[] nums, int target) {
        // if (nums.length < 3) {
        //     return 0;
        // }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = target - sum;
                if (Math.abs(diff) < min) {
                    min = Math.abs(diff);
                    result = sum;
                }
                if (diff < 0){
                    k--;
                }
                else if (diff > 0) {
                    j++;
                }
                else {
                    return target;
                }
            }
        }
        return result;
    }
}
