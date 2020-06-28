package dp;

/**
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 *
 * 做法: allSum[i][j]为第i行前j个数的和
 * */
public class NumMatrix304 {
    private int[][] allSum;

    public NumMatrix304(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        this.allSum = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length + 1; j++) {
                if (j == 0) {
                    this.allSum[i][j] = 0;
                }
                else {
                    this.allSum[i][j] = matrix[i][j - 1] + this.allSum[i][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += (this.allSum[i][col2 + 1] - this.allSum[i][col1]);
        }
        return sum;
    }
}
