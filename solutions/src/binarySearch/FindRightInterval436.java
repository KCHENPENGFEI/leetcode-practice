package binarySearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 寻找右区间
 * 给定一组区间，对于每一个区间 i，检查是否存在一个区间 j，它的起始点大于或等于区间 i 的终点，这可以称为 j 在 i 的“右侧”。
 *
 * 对于任何区间，你需要存储的满足条件的区间 j 的最小索引，这意味着区间 j 有最小的起始点可以使其成为“右侧”区间。如果区间 j 不存在，则将区间 i 存储为 -1。最后，你需要输出一个值为存储的区间值的数组。
 * 思路: 按照intervals[i][0]进行排序，然后使用二分搜索即可
 * */
public class FindRightInterval436 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2}, {2,3}, {1,3}, {4,5}};
        FindRightInterval436 findRightInterval436 = new FindRightInterval436();
        System.out.println(Arrays.toString(findRightInterval436.findRightInterval(intervals)));
    }
    public int[] findRightInterval(int[][] intervals) {
        int[] ans = new int[intervals.length];
        Map<String, Integer> pos = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            String transfer = intervals[i][0] + "+" + intervals[i][1];
            pos.put(transfer, i);
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int[] interval : intervals) {
            String transfer = interval[0] + "+" + interval[1];
            int position = pos.get(transfer);
            int end = interval[1];
            // 使用二分法进行搜索
            int search = helper(end, intervals);
            if (search == -1) {
                ans[position] = -1;
            } else {
                String s = intervals[search][0] + "+" + intervals[search][1];
                ans[position] = pos.get(s);
            }
        }
        return ans;
    }

    public int helper(int end, int[][] intervals) {
        int l = 0;
        int r = intervals.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (intervals[mid][0] < end) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        if (intervals[l][0] >= end) {
            return l;
        }
        else {
            return -1;
        }
    }
}
