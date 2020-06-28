package dfs;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 变成
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 做法1: 使用dfs递归，先将边界为'O'的位置变成'*'，然后依次遍历数组，将'*'变成'O', 将'O'变成'X'
 * */
public class Solve130 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}};
        Solve130 solve130 = new Solve130();
        solve130.solve(board);
    }
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 判断是否为边界
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(i, j, board);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '*') {
                    // 还原成'O'
                    board[i][j] ='O';
                }
                else if (board[i][j] == 'O') {
                    // 变成'X'
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '*') {
            return;
        }
        board[i][j] = '*';
        // 上
        dfs(i - 1, j, board);
        // 下
        dfs(i + 1, j, board);
        // 左
        dfs(i, j - 1, board);
        // 右
        dfs(i, j + 1, board);
    }
}
