package hashMap;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 首先我们将引用次数降序排序，在排完序的数组 citations 中，
 * 如果 citations[i] > i，那么说明第 0 到 i 篇论文都有至少 i+1 次引用。
 * 因此我们只要找到最大的 i 满足 citations[i] > i，那么 h 指数即为 i+1。
 *
 * */
public class HIndex274 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int i;
        for (i = 1; i <= n; i++) {
            if (i > citations[n - i]) {
                break;
            }
        }
        LinkedList<Integer>[] lists = new LinkedList[26];
        lists['s'-'a'].addLast(1);
        return i - 1;
    }
}
