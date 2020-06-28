package array;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * */
public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        // 从尾部遍历
        int len = nums.length;
        if (len == 0 || len == 1) {
            return;
        }
        int i;
        for (i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                // 出现降序，调用helper函数生成下一个排列，直接退出循环完成
                helper(nums, i);
                break;
            }
        }
        if (i < 0) {
            // 没有出现降序，说明整个序列已经是最大的，直接排序数组
            Arrays.sort(nums);
        }
    }

    /* 找到一个不是最大的子串，index为其在nums中的位置，helper函数返回下一个排列 */
    private void helper(int[] nums, int index) {
        int len = nums.length;
        // 找到比nums[index]大的数字中的最小值，交换位置
        int id = index + 1;
        int min = nums[index + 1];
        for (int i = index + 1; i < len; i++) {
            if (nums[i] > nums[index] && nums[i] < min) {
                // 更新id和min
                id = i;
                min = nums[i];
            }
        }
        // 交换nums[index]和nums[id]
        int tmp = nums[index];
        nums[index] = nums[id];
        nums[id] = tmp;
        // 排序index + 1之后的队列
        Arrays.sort(nums, index + 1, len);
    }
}
