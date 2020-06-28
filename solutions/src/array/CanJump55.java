package array;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 * */
public class CanJump55 {
    public boolean canJump(int[] nums) {
        // 1.从第一个数字开始遍历
        // 2.计算每一个点能跳到的最远距离max
        // 3.如果遍历出现i > max说明节点i已经不能够跳到
        // 4.根据情况返回结果
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
