package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 * 做法1: 使用堆，时间复杂度为O(N*N*logD)，其中D是堆构成的二叉树的深度
 * 做法2: 二分法 // TODO
 * */
public class KthSmallest378 {
    public int kthSmallest(int[][] matrix, int k) {
        return kthSmallest1(matrix, k);
    }

    public int kthSmallest1(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        // 使用堆进行排序
        // 构建一个k长度的大顶堆
        // 如果堆没满直接添加数据
        // 如果堆满了，新来的数据如果大于堆顶直接跳过，如果小于堆顶，那么堆顶删除然后添加新数据
        // 最后返回堆顶元素即可
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0, cnt = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++, cnt++) {
                if (cnt < k) {
                    queue.offer(matrix[i][j]);
                }
                else {
                    if (matrix[i][j] < queue.peek()) {
                        queue.poll();
                        queue.offer(matrix[i][j]);
                    }
                }
            }
        }
        return queue.poll();
    }
}
