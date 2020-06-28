package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 和上一题的区别在于使用List保存，交集中可以存在存在重复的数字
 * */
public class Intersect350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
