package array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenpengfei
 * @date 2020/8/20 7:30 下午
 */
public class NextGreaterElements503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{};
        }
        int[] tmp = new int[2 * len];
        // 重新生成一个数组
        int[] newNums = new int[2 * len];
        Deque<Integer> stack = new LinkedList<>();
        System.arraycopy(nums, 0, newNums, 0, len);
        System.arraycopy(nums, 0, newNums, len, len);
        for (int i = 2 * len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= newNums[i]) {
                stack.poll();
            }
            tmp[i] = stack.isEmpty()? -1: stack.peek();
            stack.push(newNums[i]);
        }
        return Arrays.copyOf(tmp, len);
    }
}
