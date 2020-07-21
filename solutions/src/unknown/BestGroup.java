package unknown;

import java.util.Arrays;

/**
 * @author chenpengfei
 * @date 2020/7/19 10:04 上午
 * 给出一个长度为 n 的数组和一个数字 k ，你需要在数组中选出一些数字，这些数字两两之间的差值不能超过k。
 * 你需要判断最多能够挑出的数字个数。（n在[1, 100000]之间，k和数组中的数字在[1，1000000000]之间）
 * 输入数组长度n；选出的两数字最大差值k；和一个长度为n的数组。
 * 输出最多能够选出的数字个数
 */
public class BestGroup {
    public int solution(int n, int k, int[] nums) {
        if (n == 1) {
            return 0;
        }
        Arrays.sort(nums);
        // 双指针法，i指向头元素，j指向满足条件的元素
        int i = 0, j = 1;
        int maxCnt = 0;
        int partMaxCnt = 1;
        while (i < n && n - i > maxCnt) {
            while (j < n && nums[j] - nums[i] <= k) {
                partMaxCnt++;
                j++;
            }
            maxCnt = Math.max(maxCnt, partMaxCnt);
            i++;
            if (i == j) {
                j++;
            }
            else if (i < j) {
                partMaxCnt--;
            }
        }
        return maxCnt == 1? 0: maxCnt;
    }
}
