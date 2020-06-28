package array;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 * 做法: 从外到内依次旋转，首先递归外圈，定义(start, start)和(end, end)为左上角和右下角
 * 然后利用变量s和e循环遍历外圈，外圈遍历结束后，start++, end--循环遍历内圈
 * */
public class Rotate48 {
    public void rotate(int[][] matrix) {
        for (int start = 0, end = matrix[0].length - 1; start < end; start++, end--) {
            for (int s = start, e = end; s < end; s++, e--) {
                int tmp = matrix[s][start];
                matrix[s][start] = matrix[end][s];
                matrix[end][s] = matrix[e][end];
                matrix[e][end] = matrix[start][e];
                matrix[start][e] = tmp;
            }
        }
    }
}
