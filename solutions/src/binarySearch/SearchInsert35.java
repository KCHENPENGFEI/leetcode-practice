package binarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 做法1: 使用集合，然后进行sort
 * 做法2: 二分法，注意最后结果nums[l]和target之间的大小关系
 * */
public class SearchInsert35 {
    public int searchInsert(int[] nums, int target) {
        return searchInsert2(nums, target);
    }
    public int searchInsert1(int[] nums, int target) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int index = list.indexOf(target);
        if (index == -1) {
            list.add(target);
            Collections.sort(list);
            index = list.indexOf(target);
        }
        return index;
    }

    public int searchInsert2(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        if (nums[l] == target) {
            return l;
        }
        else if (nums[l] < target){
            return l + 1;
        }
        else {
            return l;
        }
    }
}
