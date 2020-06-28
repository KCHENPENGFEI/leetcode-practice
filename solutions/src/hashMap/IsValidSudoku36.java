package hashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 做法: 使用HashMap存储每行、每列、每个格子的数字，这样只需要遍历一次数独就好了
 * */
public class IsValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) {
            return false;
        }
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> grids = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int gridId = getGrid(i, j);
                char num = board[i][j];
                if (num == '.') {
                    continue;
                }
                if (inMap(rows, i, num) || inMap(cols, j, num) || inMap(grids, gridId, num)) {
                    return false;
                }
            }
        }
        return true;
    }

    private int getGrid(int i, int j) {
        int a = i / 3;
        int b = j / 3;
        return a + b * 3;
    }

    private boolean inMap(Map<Integer, Set<Character>> map, int k, char v) {
        if (!map.containsKey(k)) {
            map.put(k, new HashSet<>());
            map.get(k).add(v);
            return false;
        }
        else {
            if (map.get(k).contains(v)) {
                return true;
            }
            else {
                map.get(k).add(v);
                return false;
            }
        }
    }
}
