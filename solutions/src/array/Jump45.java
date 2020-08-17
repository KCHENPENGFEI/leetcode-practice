package array;

/**
 * @author chenpengfei
 * @date 2020/7/3 7:39 下午
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 方法二比较好理解
 * 方法一使用end标记能跳到最远的地方，如果现在遍历到了这个位置那么step++
 *
 */
public class Jump45 {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if(i == end) {
                //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public int jump2(int[] nums) {
        // 从后往前依次找到能跳到指定位置的最左边的点
        // 最终目的地
        int pos = nums.length - 1;
        int step = 0;
        // 一直往前找
        while (pos != 0) {
            for (int i = 0; i < pos; i++) {
                if (nums[i] + i >= pos) {
                    // 最左能跳到【因为是左往右遍历】
                    pos = i;
                    step++;
                }
            }
        }
        return step;
    }
}
