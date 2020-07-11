package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * */
public class SpiralOrder54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int r1 = 0, r2 = rows - 1, c1 = 0, c2 = cols - 1;
        while (r1 <= r2 && c1 <= c2) {
            read(r1, r2, c1, c2, ans, matrix);
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }

    public void read(int r1, int r2, int c1, int c2, List<Integer> ans, int[][] matrix) {
        if (r1 == r2) {
            for (int i = c1; i <= c2; i++) {
                ans.add(matrix[r1][i]);
            }
            return;
        }
        if (c1 == c2) {
            for (int i = r1; i <= r2; i++) {
                ans.add(matrix[i][c1]);
            }
            return;
        }
        for (int i = c1; i < c2; i++) {
            ans.add(matrix[r1][i]);
        }
        for (int i = r1; i < r2; i++) {
            ans.add(matrix[i][c2]);
        }
        for (int i = c2; i > c1; i--) {
            ans.add(matrix[r2][i]);
        }
        for (int i = r2; i > r1; i--) {
            ans.add(matrix[i][c1]);
        }
    }
}
