package dfs;

/**
 * @author chenpengfei
 * @date 2020/7/5 2:25 下午
 */
public class IslandPerimeter463 {
     public int islandPerimeter1(int[][] grid) {
         int res = 0;
         int m = grid.length;
         int n = grid[0].length;
         for (int i = 0; i < m; i++) {
             for (int j = 0; j < n; j++) {
                 if (grid[i][j] == 1) {
                     res += (4 - oneRound(i, j, m, n, grid));
                 }
             }
         }
         return res;
     }

     public int oneRound(int row, int col, int m, int n, int[][] grid) {
         int cnt = 0;
         if (row != 0 && row != m - 1) {
             if (grid[row - 1][col] == 1) {
                 cnt++;
             }
             if (grid[row + 1][col] == 1) {
                 cnt++;
             }
         }
         if (row == 0) {
             if (m != 1) {
                 if (grid[row + 1][col] == 1) {
                     cnt++;
                 }
             }
         }
         if (row == m - 1) {
             if (m != 1) {
                 if (grid[row - 1][col] == 1) {
                     cnt++;
                 }
             }
         }
         if (col != 0 && col != n - 1) {
             if (grid[row][col - 1] == 1) {
                 cnt++;
             }
             if (grid[row][col + 1] == 1) {
                 cnt++;
             }
         }
         if (col == 0) {
             if (n != 1) {
                 if (grid[row][col + 1] == 1) {
                     cnt++;
                 }
             }
         }
         if (col == n - 1) {
             if (n != 1) {
                 if (grid[row][col - 1] == 1) {
                     cnt++;
                 }
             }
         }
         return cnt;
     }
    public int islandPerimeter2(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    // 题目限制只有一个岛屿，计算一个即可
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    int dfs(int[][] grid, int r, int c) {
        // 从一个岛屿方格走向网格边界，周长加 1
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
            return 1;
        }
        // 从一个岛屿方格走向水域方格，周长加 1
        if (grid[r][c] == 0) {
            return 1;
        }
        // 重复路径
        if (grid[r][c] == 2) {
            return 0;
        }
        grid[r][c] = 2;
        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }
}
