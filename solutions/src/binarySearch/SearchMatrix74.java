package binarySearch;

/**
 * 在矩阵中寻找目标值
 * 解题思路: 使用两次二分法，第一次找到第一个大于target的所在行，那么target必定在上一行
 * 然后使用第二次二分法在指定行找到target
 * */
public class SearchMatrix74 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1}};
        int target = 2;
        SearchMatrix74 searchMatrix74 = new SearchMatrix74();
        System.out.println(searchMatrix74.searchMatrix(matrix, target));
    }

    // 找到第一个大于target的行数
    public int findRow(int[][] matrix, int target) {
        int rows = matrix.length;
        int rl = 0;
        int rr = rows;
        while (rl < rr) {
            int rmid = rl + (rr - rl) / 2;
            if (matrix[rmid][0] <= target) {
                rl = rmid + 1;
            }
            else {
                rr = rmid;
            }
        }
        // 返回的是第一个大于target的行数
        return rl;
    }

    public boolean findTarget(int[] row, int target) {
        int l = 0;
        int r = row.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (row[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        if (l == row.length) {
            return false;
        }
        if (row[l] != target) {
            return false;
        }
        return true;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        // System.out.println(rows);
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;
        if (cols == 0) {
            return false;
        }
        int row = findRow(matrix, target) - 1;
        if (row == -1) {
            return false;
        }
        boolean result = findTarget(matrix[row], target);
        return result;
    }
}
