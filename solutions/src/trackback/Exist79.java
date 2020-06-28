package trackback;

/**
 * 使用回溯法，需要注意的是已经走过的路需要用'#'代替，并且使用了dir来标记方向（其实可以不用）
 * */
public class Exist79 {
    boolean found = false;

    public static void main(String[] args) {
        char[][] board = new char[][]{{'a', 'b'}, {'c', 'd'}};
        Exist79 exist79 = new Exist79();
        System.out.println(exist79.exist(board, "cdba"));
    }
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (found) {
                    return true;
                }
                if (word.charAt(0) == board[i][j]) {
                    StringBuilder sb = new StringBuilder();
                    char[][] copy = copyBoard(board);
                    dfs(i, j, copy, sb, word, 0);
                }
            }
        }
        return found;
    }

    private void dfs(int i, int j, char[][] board, StringBuilder track, String word, int dir) {
        if (track.toString().equals(word)) {
            // 找到了
            found = true;
            return;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (!word.startsWith(track.toString())) {
            return;
        }
        if (found) {
            return;
        }
        char c = board[i][j];
        track.append(c);
        board[i][j] = '#';
        if (dir != 1) {
            dfs(i + 1, j, board, track, word, 2);
        }
        if (dir != 2) {
            dfs(i - 1, j, board, track, word, 1);
        }
        if (dir != 3) {
            dfs(i, j + 1, board, track, word, 4);
        }
        if (dir != 4) {
            dfs(i, j - 1, board, track, word, 3);
        }
        track.deleteCharAt(track.length() - 1);
        board[i][j] = c;
    }

    private char[][] copyBoard(char[][] board) {
        char[][] newBoard = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, board[0].length);
        }
        return newBoard;
    }

    public boolean exist1(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (found) {
                    return true;
                }
                if (board[i][j] == word.charAt(0)) {
                    char[][] copy = copyArr(board);
                    dfs(copy, i, j, word, 0);
                }
            }
        }
        return found;
    }

    private void dfs(char[][] board, int i, int j, String word, int index) {
        int len = word.length();
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (board[i][j] != word.charAt(index)) {
            return;
        }
        if (board[i][j] == word.charAt(index) && index == len - 1) {
            found = true;
            return;
        }
        if (found) {
            return;
        }
        char c = board[i][j];
        board[i][j] = '#';
        dfs(board, i - 1, j, word, index + 1);
        dfs(board, i + 1, j, word, index + 1);
        dfs(board, i, j - 1, word, index + 1);
        dfs(board, i, j + 1, word, index + 1);
        board[i][j] = c;
    }

    private char[][] copyArr(char[][] board) {
        if (board.length == 0) {
            return new char[][]{};
        }
        if (board[0].length == 0) {
            return new char[][]{{}};
        }

        char[][] copy = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }
}
