package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenpengfei
 * @date 2020/7/5 2:09 下午
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 做法: 和442题十分类似，出现一次的数字会将该数字对应的位置变成负数，如果出现两次又会变成正数，
 * 但是题目不找出现两次的数字，那么我们可以用nums[newId] = - Math.abs(nums[newId])让其始终变成负数
 * 最后扫描一次数组，如果是正数那么说明这个位置的数字没有出现
 */
public class FindDisappearedNumbers448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            nums[num - 1] = nums[num - 1] > 0? -nums[num - 1]: nums[num - 1];
        }
        for (int j = 0; j < len; j++) {
            if (nums[j] > 0) {
                res.add(j + 1);
            }
        }
        return res;
    }
}
