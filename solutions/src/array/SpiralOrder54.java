package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * */
public class SpiralOrder54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        // 从外圈到内圈依次添加
        int r1 = 0;
        int r2 = matrix.length - 1;
        int c1 = 0;
        int c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            helper(matrix, r1, c1, r2, c2, result);
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return result;
    }

    private void helper(int[][] matrix, int r1, int c1, int r2, int c2, List<Integer> result) {
        // 特判
        // 矩阵长度为1
        if (c1 == c2) {
            for (int i = r1; i <= r2; i++) {
                result.add(matrix[i][c1]);
            }
        }
        // 矩阵宽度为1
        else if (r1 == r2) {
            for (int i = c1; i <= c2; i++) {
                result.add(matrix[r1][i]);
            }
        }
        else {
            // 添加上面那行
            for (int i = c1; i <= c2; i++) {
                result.add(matrix[r1][i]);
            }
            // 添加右边那行
            for (int i = r1 + 1; i <= r2; i++) {
                result.add(matrix[i][c2]);
            }
            // 添加下面那行
            for (int i = c2 - 1; i >= c1; i--) {
                result.add(matrix[r2][i]);
            }
            // 添加左边那行
            for (int i = r2 - 1; i > r1; i--) {
                result.add(matrix[i][c1]);
            }
        }
    }
}
