package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenpengfei
 * @date 2020/6/26 7:22 下午
 *
 * // TODO 如何不用List<Integer[]>这种奇怪的数据结构
 */
public class Merge56 {
    public int[][] merge(int[][] intervals) {
        List<Integer[]> list = new ArrayList<>();
        if (intervals.length == 0) {
            return new int[][]{};
        }
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] < o2[0]?-1: o1[0] == o2[0]?0: 1;
        });
        for (int i = 0; i < intervals.length; i++) {
            Integer[] numsI = Arrays.stream(intervals[i]).boxed().toArray(Integer[]::new);
            if (i == 0) {
                list.add(numsI);
            }
            else {
                int size = list.size();
                Integer[] competitor = list.get(size - 1);
                if (intervals[i][0] > competitor[1]) {
                    // 不重叠
                    list.add(numsI);
                }
                else {
                    Integer[] newWindow = new Integer[2];
                    newWindow[0] = competitor[0];
                    newWindow[1] = Math.max(intervals[i][1], competitor[1]);
                    list.remove(size - 1);
                    list.add(newWindow);
                }
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = Arrays.stream(list.get(i)).mapToInt(Integer::valueOf).toArray();
        }
        return res;
    }
}
