package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest215 {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest2(nums, k);
    }

    public int findKthLargest1(int[] nums, int k) {
        // 使用优先队列
        if (nums.length == 0) {
            return -1;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i: nums) {
            priorityQueue.offer(i);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = priorityQueue.poll();
        }
        return res;
    }

    public int findKthLargest2(int[] nums, int k) {
        // 直接处理数组
        if (nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int index = nums.length - k;
        return nums[index];
    }
}
