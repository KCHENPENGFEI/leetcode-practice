package array;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenpengfei
 * @date 2020/10/11 7:27 下午
 */
public class NumMagicSquaresInside840 {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        int cnt = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagic(grid, i, j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public boolean isMagic(int[][] grid, int i, int j) {
        Set<Integer> set = new HashSet<>();
        for (int m = i; m < i + 3; m++) {
            for (int n = j; n < j + 3; n++) {
                set.add(grid[m][n]);
            }
        }
        for (int k = 1; k < 10; k++) {
            if (!set.contains(k)) {
                return false;
            }
        }
        int sumRow = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
        if (sumRow != grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2]) {
            return false;
        }
        if (sumRow != grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2]) {
            return false;
        }
        int sumCol = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
        if (sumCol != sumRow) {
            return false;
        }
        if (sumCol != grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1]) {
            return false;
        }
        if (sumCol != grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2]) {
            return false;
        }
        int sum = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
        if (sum != sumRow) {
            return false;
        }
        return sum == grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2];
    }
}
