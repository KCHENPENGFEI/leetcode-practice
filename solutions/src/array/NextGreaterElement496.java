package array;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author chenpengfei
 * @date 2020/8/20 7:27 下午
 * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * 单调栈经典问题
 */
public class NextGreaterElement496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> pos = new HashMap<>();
        int[] res = new int[nums2.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            pos.put(nums2[i], i);
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.poll();
            }
            res[i] = stack.isEmpty()? -1: stack.peek();
            stack.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = res[pos.get(nums1[i])];
        }
        return ans;
    }
}
