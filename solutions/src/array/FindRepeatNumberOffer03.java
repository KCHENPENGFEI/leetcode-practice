package array;

/**
 * @author chenpengfei
 * @date 2020/7/11 7:32 下午
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 做法一: 负数法
 * 做法二: 将元素nums[i]和下标为nums[i]的数字交换位置
 */
public class FindRepeatNumberOffer03 {
    public int findRepeatNumber(int[] nums) {
        return findRepeatNumber2(nums);
    }
    public int findRepeatNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num] < 0) {
                return num;
            }
            nums[num] = -nums[num];
        }
        return 0;
    }

    public int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i]] != nums[i]) {
                swap(nums, nums[i], i);
            }
            if (i != nums[i]) {
                return nums[i];
            }
        }
        return 0;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
