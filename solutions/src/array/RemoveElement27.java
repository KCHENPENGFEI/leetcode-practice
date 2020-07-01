package array;

/**
 * @author chenpengfei
 * @date 2020/6/30 8:08 下午
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class RemoveElement27 {

    public void delete(int index, int[] nums, int len)  {
        if (index < 0 || index > len - 1) {
            return;
        }
        System.arraycopy(nums, index + 1, nums, index, len - index - 1);
    }

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int cnt = 0;
        int i = 0;
        while (cnt < len) {
            if (nums[i] == val) {
                delete(i, nums, len);
            }
            else {
                i++;
            }
            cnt++;
        }
        return i;
    }
}
