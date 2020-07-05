package array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author chenpengfei
 * @date 2020/7/5 12:54 下午
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 * 做法一: 使用i,j,index三指针分别指向窗口的头部、尾部和最大值的位置，依次i++, j++，如果index不在i, j之间那重新找一次最大值
 * 做法二: 使用一个递减队列来保存在窗口内，最大值永远都是队列头部元素，如果递减队列超出K需要对头部进行删除
 */
public class MaxSlidingWindow239 {
     public int[] maxSlidingWindow1(int[] nums, int k) {
         ArrayList<Integer> res = new ArrayList<>();
         int i = 0;
         int j = i + k - 1;
         int index = -1;
         int max = Integer.MIN_VALUE;
         while (i < nums.length && j < nums.length) {
             if (index < i) {
                 max = Integer.MIN_VALUE;
                 // 最大值不在窗口里面，求最大值
                 for (int m = i; m <= j; m++) {
                     if (nums[m] > max) {
                         index = m;
                         max = nums[m];
                     }
                 }
             }
             else {
                 // 最大值在窗口里面，只进行对比
                 if (nums[j] > max) {
                     index = j;
                     max = nums[j];
                 }
             }
             res.add(max);
             i++;
             j++;
         }
         return res.stream().mapToInt(Integer::valueOf).toArray();
     }

    public int[] maxSlidingWindo2(int[] nums, int k) {
        Deque<Integer> max = new ArrayDeque<>();
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int[] result = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                if (max.peekFirst() == nums[i - k]) {
                    max.removeFirst();
                }
            }
            while (!max.isEmpty() && nums[i] > max.peekLast()) {
                max.removeLast();
            }

            max.addLast(nums[i]);
            if (i >= k - 1) {
                result[index++] = max.peekFirst();
            }
        }
        return result;
    }
}
