package doublePointer;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * */
public class ThreeSumClosest16 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,1,55};
        int target = 3;
        ThreeSumClosest16 threeSumClosest16 = new ThreeSumClosest16();
        System.out.println(threeSumClosest16.threeSumClosest(nums, target));
    }
    public int threeSumClosest(int[] nums, int target) {
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
                // 题目说只存在一个答案，所以不用判断重复的情况
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
