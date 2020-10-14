package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenpengfei
 * @date 2020/8/27 11:22 上午
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
