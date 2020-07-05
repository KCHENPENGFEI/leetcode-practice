package array;

/**
 * @author chenpengfei
 * @date 2020/7/5 10:47 上午
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 做法: 一次遍历数组，首先找到第一个0的位置，记为firstZeroId，
 * 之后遇到非0元素就和第一个0元素互换位置，然后firstZeroId++
 */
public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        int firstZeroId = -1;
        for (int i = 0; i< nums.length; i++) {
            if (firstZeroId == -1 && nums[i] == 0) {
                firstZeroId = i;
            }

            if (nums[i] != 0 && firstZeroId != -1) {
                nums[firstZeroId] = nums[i];
                nums[i] = 0;
                firstZeroId++;
            }
        }
    }
}
