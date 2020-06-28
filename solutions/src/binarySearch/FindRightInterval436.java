package binarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 寻找右区间
 * 给定一组区间，对于每一个区间 i，检查是否存在一个区间 j，它的起始点大于或等于区间 i 的终点，这可以称为 j 在 i 的“右侧”。
 *
 * 对于任何区间，你需要存储的满足条件的区间 j 的最小索引，这意味着区间 j 有最小的起始点可以使其成为“右侧”区间。如果区间 j 不存在，则将区间 i 存储为 -1。最后，你需要输出一个值为存储的区间值的数组。
 * 思路1: 暴力求解
 * 思路2: 使用哈希表记录下[a, b]的答案，当下次遇到[c, b]的时候，直接从哈希表中返回
 * */
public class FindRightInterval436 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2}, {2,3}, {1,3}, {4,5}};
        FindRightInterval436 findRightInterval436 = new FindRightInterval436();
        System.out.println(Arrays.toString(findRightInterval436.findRightInterval(intervals)));
    }
    public int[] findRightInterval(int[][] intervals) {
        if (intervals.length == 1) {
            return new int[]{-1};
        }
        int[] result = new int[intervals.length];
        // 暴力法
         for (int i = 0; i < intervals.length; i++) {
             boolean found = false;
             int min = Integer.MAX_VALUE;
             for ( int j = 0 ; j < intervals.length; j++) {
                 if (i != j) {
                     if (intervals[j][0] >= intervals[i][1] && intervals[j][0] < min) {
                         min = intervals[j][0];
                         result[i] = j;
                         found = true;
                         // break;
                     }
                 }
             }
             if (!found) {
                 result[i] = -1;
             }
         }
         return result;
    }

    public int[] findRightInterval1(int[][] intervals) {
        if (intervals.length == 1) {
            return new int[]{-1};
        }
        int[] result = new int[intervals.length];
        // 哈希表保存[a, b]的答案A，下次遇到[c, b]时候直接返回A即可
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            int right = intervals[i][1];
            if (map.containsKey(right)) {
                result[i] = map.get(right);
            }
            else {
                boolean found = false;
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < intervals.length; j++) {
                    if (i != j) {
                        if (intervals[j][0] >= intervals[i][1] && intervals[j][0] < min) {
                            min = intervals[j][0];
                            result[i] = j;
                            map.put(right, j);
                            found = true;
                        }
                    }
                }
                if (!found) {
                    result[i] = -1;
                    map.put(right, -1);
                }
            }
        }
        return result;
    }
}
