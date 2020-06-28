package binarySearch;

/**
 * 搜索二维矩阵中是否存在某一个数值
 * 思路: 使用了3次二分法
 * 第一次二分法搜索第一列，找到第一个大于target的数字，作为搜索行的下界
 * 第二次二分法搜索最后一列，找到第一个大于或者等于target的数字，作为搜索行的下界
 * 第三次二分法搜索范围中的每一列，找到target
 **/
public class SearchMatrix240 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4}, {2,3,4,5}, {3,4,5,6}};
        int target = 5;
        SearchMatrix240 searchMatrix240 = new SearchMatrix240();
        System.out.println(searchMatrix240.searchMatrix(matrix, target));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;
        if (cols == 0) {
            return false;
        }
        int[] range = findRows(matrix, target, rows, cols);
        // 特殊情况如果下界等于0说明matrix[0][0] > target，那么肯定找不到target，直接返回false
        if (range[0] == 0) {
            return false;
        }
        int[] newRange = new int[2];
        newRange[0] = range[1];
        newRange[1] = range[0];
        // System.out.println(newRange[0]);
        // System.out.println(newRange[1]);
        boolean found = false;
        for (int row = newRange[0]; row < newRange[1]; row++) {
            found = findTarget(matrix[row], target);
            if (found) {
                return true;
            }
        }
        return false;
    }

    public int[] findRows(int[][] matrix, int target, int rows, int cols) {
        int rl = 0;
        int rr = rows;
        int rll = 0;
        int rrr = rows;
        int[] result = new int[2];
        // 这里需要找到的是第一个严格大于target的数，因为返回的是搜索的下界(并且是开区间)
        while (rl < rr) {
            int rmid = rl + (rr - rl) / 2;
            if (matrix[rmid][0] <= target) {
                rl = rmid + 1;
            }
            else {
                rr = rmid;
            }
        }
        // 这里需要找到的是第一个大于或者等于target的数，因为返回的是搜索的上界(是闭区间)
        while (rll < rrr) {
            int rrmid = rll + (rrr - rll) / 2;
            if (matrix[rrmid][cols - 1] < target) {
                rll = rrmid + 1;
            }
            else {
                rrr = rrmid;
            }
        }
        result[0] = rl;
        result[1] = rll;
        return result;
    }

    public boolean findTarget(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        if (l == nums.length) {
            return false;
        }
        if (nums[l] == target) {
            return true;
        }
        else {
            return false;
        }
    }
}
