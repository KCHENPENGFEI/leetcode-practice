package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chenpengfei
 * @date 2020/7/5 1:04 下午
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class Intersection349 {
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> set4 = new HashSet<>(set2);
        set4.addAll(set1);
        Set<Integer> set3 = new HashSet<>(set1);
        Set<Integer> set5 = new HashSet<>(set2);
        set3.removeAll(set2);
        set5.removeAll(set1);
        set4.removeAll(set3);
        set4.removeAll(set5);
        return set4.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (Integer n : nums1) {
            set1.add(n);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (Integer n : nums2) {
            set2.add(n);
        }

        set1.retainAll(set2);

        int [] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) {
            output[idx++] = s;
        }
        return output;
    }
}
