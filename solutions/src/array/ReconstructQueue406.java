package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenpengfei
 * @date 2020/7/11 5:21 下午
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
 * 编写一个算法来重建这个队列。
 *
 */
public class ReconstructQueue406 {
    /**
     * 解题思路：先排序再插入
     * 1.排序规则：按照先H高度降序，K个数升序排序
     * 2.遍历排序后的数组，根据K插入到K的位置上
     *
     * 核心思想：高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            return o1[0] > o2[0]? -1: o1[0] == o2[0]? (Integer.compare(o1[1], o2[1])) : 1;
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] i: people) {
            ans.add(i[1], i);
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
