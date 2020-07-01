package array;

import java.util.Arrays;

public class FirstMissingPositive41 {
    public static void main(String[] args) {
        int[] nums = new int[]{10,1,9,-3,-4,24,6};
        FirstMissingPositive41 firstMissingPositive41 = new FirstMissingPositive41();
        System.out.println(firstMissingPositive41.firstMissingPositive(nums));
    }
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        Arrays.sort(nums);
        // 从1开始升序做判断
        int i = 1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > 0) {
                // 和升序的i不匹配，则要判断是否存在重复元素
                if (nums[k] != i) {
                    // 如果第一个数字就不匹配直接返回1
                    if (k == 0) {
                        return i;
                    }
                    else {
                        // 如果是重复数字，记入下一个循环
                        if (nums[k] == nums[k - 1]) {
                            continue;
                        }
                        // 不匹配并且也不是重复数字直接返回
                        return i;
                    }
                }
                // i升序
                i++;
            }
        }
        // 所有数字都匹配(1,2,3,4,5,...)，那就返回下一个整数
        return i;
    }
}
