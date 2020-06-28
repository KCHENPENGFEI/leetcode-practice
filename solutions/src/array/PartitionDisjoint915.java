package array;

/**
 * @author chenpengfei
 * @date 2020/6/25 5:39 下午
 *
 * 915. 分割数组
 * 要求: 使得左半边所有数值小于等于右半边，并且左半边长度尽可能短
 */
public class PartitionDisjoint915 {
    public int partitionDisjoint(int[] A) {
        int start = 1;
        int max = A[0];
        int min = findMin(start, A);
        if (max <= min) {
            return start;
        }
        while (start < A.length) {
            int num = A[start];
            if (num > max) {
                max = num;
            }
            if (num == min) {
                min = findMin(start + 1, A);
            }
            if (max <= min) {
                return start + 1;
            }
            start++;
        }
        return 0;
    }

    public int findMin(int start, int[] nums) {
        int min = nums[start];
        for (int i = start; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }
}
