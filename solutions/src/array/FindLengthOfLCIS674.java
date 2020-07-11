package array;

/**
 * @author chenpengfei
 * @date 2020/7/11 4:29 下午
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
 */
public class FindLengthOfLCIS674 {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int max = 1;
        int partMax = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                partMax++;
            }
            else {
                max = Math.max(max, partMax);
                partMax = 1;
            }
        }
        max = Math.max(max, partMax);
        return max;
    }
}
