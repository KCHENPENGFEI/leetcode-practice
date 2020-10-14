package array;

/**
 * @author chenpengfei
 * @date 2020/10/11 7:21 下午
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 *
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 */
public class Transpose867 {
    public int[][] transpose(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return new int[][]{};
        }

        int rows = A.length;
        int cols = A[0].length;
        int[][] newMatrix = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newMatrix[j][i] = A[i][j];
            }
        }

        return newMatrix;
    }
}
