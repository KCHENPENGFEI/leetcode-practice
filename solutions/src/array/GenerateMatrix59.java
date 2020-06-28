package array;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 做法: 都是从矩阵外圈不断向矩阵内圈循环，先填充外圈，然后start++, end--，然后再循环
 * */
public class GenerateMatrix59 {
    public int[][] generateMatrix(int n) {
        // 首先确定结果矩阵的大小
        int[][] result = new int[n][n];
        int begin = 1;
        int start = 0;
        int end = n - 1;
        while (n > 0) {
            // 调用函数填充矩阵外圈
            begin = insert(result, begin, start, end);
            ++start;
            --end;
            // 将矩阵缩小
            n -= 2;
        }
        return result;
    }

    /* 返回下一次insert的时候的起始数值begin */
    private int insert(int[][] matrix, int begin, int start, int end) {
        if (start == end) {
            // 就一个点，直接填充然后return -1表示填充结束
            matrix[start][end] = begin;
            return -1;
        }
        for (int i = start; i < end; i++) {
            // 填充上面一行
            matrix[start][i] = begin;
            ++begin;
        }
        for (int i = start; i < end; i++) {
            // 填充右边一行
            matrix[i][end] = begin;
            ++begin;
        }
        for (int i = end; i > start; i--) {
            // 填充下面一行
            matrix[end][i] = begin;
            ++begin;
        }
        for (int i = end; i > start; i--) {
            // 填充左边一行
            matrix[i][start] = begin;
            ++begin;
        }
        return begin;
    }
}
