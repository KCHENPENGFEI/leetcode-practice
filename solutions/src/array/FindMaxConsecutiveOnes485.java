package array;

/**
 * @author chenpengfei
 * @date 2020/7/5 2:16 下午
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 */
public class FindMaxConsecutiveOnes485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = -1;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 && start == -1) {
                start = i;
            }
            else if (nums[i] == 0 && start != -1) {
                maxLen = Math.max(maxLen, i - start);
                start = -1;
            }
            if (i == nums.length - 1 && nums[i] == 1) {
                maxLen = Math.max(maxLen, i - start + 1);
            }
        }
        return maxLen;
    }

    public int findMaxConsecutiveOnes1(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int tmp = nums[0];
        int cnt = tmp == 1? 1: 0;
        int max = 0;
        for (int i = 1; i < len; i++) {
            if ((tmp = nums[i] & tmp) == 1) {
                cnt++;
            }
            else {
                if (nums[i] == 0) {
                    max = Math.max(max, cnt);
                    cnt = 0;
                }
                else {
                    max = Math.max(max, 1);
                    cnt = 1;
                }
            }
        }
        max = Math.max(max, cnt);
        return max;
    }
}
