package array;

import java.util.Arrays;

/**
 * @author chenpengfei
 * @date 2020/6/24 9:52 下午
 */
public class FindLHS594 {
    public int findLHS(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int i = 0, j = 0;
        int maxLen = 0;
        while (j < nums.length) {
            if (i == j) {
                j++;
                continue;
            }
            if (nums[j] - nums[i] == 1) {
                j++;
                maxLen = Math.max(maxLen, j - i);
            }
            else if (nums[j] - nums[i] > 1){
                i++;
            }
            else {
                j++;
            }
        }
        return maxLen;
    }
}
