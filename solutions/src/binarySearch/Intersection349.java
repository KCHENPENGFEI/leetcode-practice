package binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 两个数组的交集
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * */
public class Intersection349 {
    public static void main(String[] args) {
        Intersection349 intersection349 = new Intersection349();
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8 ,4};
        System.out.println(Arrays.toString(intersection349.intersection(nums1, nums2)));
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int nums1Min = nums1[0];
        int nums1Max = nums1[nums1.length - 1];
        int nums2Min = nums2[0];
        int nums2Max = nums2[nums2.length - 1];
        // 特殊情况判断
        if (nums1Min > nums2Max || nums2Min > nums1Max) {
            // 不存在交集
            return new int[]{};
        }

        Set<Integer> set = new HashSet<>();

        if (nums1Min >= nums2Min && nums1Max <= nums2Max) {
            // 交集在[nums1Min, nums1Max]中
            for (int i = 0; i < nums1.length; i++) {
                if (i > 0 && nums1[i] == nums1[i - 1]) {
                    continue;
                }
                int index = Arrays.binarySearch(nums2, nums1[i]);
                if (index >= 0) {
                    set.add(nums1[i]);
                    System.out.println(nums1[i]);
                }
            }
            return set.stream().mapToInt(Integer::valueOf).toArray();
        }

        if (nums2Min >= nums1Min && nums2Max <= nums1Max) {
            // 交集在[nums2Min, nums2Max]中
            for (int i = 0; i < nums2.length; i++) {
                if (i > 0 && nums2[i] == nums2[i - 1]) {
                    continue;
                }
                int index = Arrays.binarySearch(nums1, nums2[i]);
                if (index >= 0) {
                    set.add(nums2[i]);
                }
            }
            return set.stream().mapToInt(Integer::valueOf).toArray();
        }

        if (nums1Min <= nums2Min && nums1Max <= nums2Max) {
            // 交集在[nums2Min, nums1Max]中
            for (int i = 0; i < nums2.length; i++) {
                if (nums2[i] > nums1Max) {
                    break;
                }
                if (i > 0 && nums2[i] == nums2[i - 1]) {
                    continue;
                }
                int index = Arrays.binarySearch(nums1, nums2[i]);
                if (index >= 0) {
                    set.add(nums2[i]);
                }
            }
            return set.stream().mapToInt(Integer::valueOf).toArray();
        }

        if (nums2Min <= nums1Min && nums2Max <= nums1Max) {
            // 交集在[nums1Min, nums2Max]中
            for (int i = 0; i < nums1.length; i++) {
                if (nums1[i] > nums2Max) {
                    break;
                }
                if (i > 0 && nums1[i] == nums1[i - 1]) {
                    continue;
                }
                int index = Arrays.binarySearch(nums2, nums1[i]);
                if (index >= 0) {
                    set.add(nums1[i]);
                }
            }
            return set.stream().mapToInt(Integer::valueOf).toArray();
        }
        return new int[]{};
    }


    /**
     * 方法二: 直接利用set
     * */
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> set3 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        set2.removeAll(set1);
        set3.removeAll(set2);
        return set3.stream().mapToInt(Integer::valueOf).toArray();
    }
}
