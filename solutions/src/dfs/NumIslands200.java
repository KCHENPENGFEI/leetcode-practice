package dfs;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 *
 * 做法1: dfs递归，遍历数组，找到为1的坐标，依次遍历上下左右，遇到越界或者为0时候返回，
 * 递归时候要将已经遍历的位置变成0防止栈溢出
 * */
public class NumIslands200 {
    int cnt = 0;
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) { return 0; }
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void dfs(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            // 找到边界
            return;
        }
        grid[i][j] = '0';
        // 上
        dfs(i - 1, j, grid);
        // 下
        dfs(i + 1, j, grid);
        // 左
        dfs(i, j - 1, grid);
        // 右
        dfs(i, j + 1, grid);
    }
}
