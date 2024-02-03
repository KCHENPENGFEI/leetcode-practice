package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenpengfei
 * @date 2020/8/27 11:22 上午
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 做法：排序之后使用贪心算法，不断更新当前最右边界即可
 */
public class EraseOverlapIntervals435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;
        if (intervals.length == 0 || intervals[0].length == 0) {
            return ans;
        }
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[1])));
        int end = intervals[0][1];
        for (int[] interval: intervals) {
            if (interval[0] < end) {
                ans++;
            }
            else {
                end = interval[1];
            }
        }
        return ans - 1;
    }
}
