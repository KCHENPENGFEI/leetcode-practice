package binarySearch;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 做法1: 首先找到旋转点在哪，然后根据target确定搜索左半边还是右半边
 * 做法2(推荐): 直接求mid，然后根据nums[mid]、nums[l]、target关系来确定左半边还是右半边
 * */
public class Search33 {
    public int search(int[] nums, int target) {
        return search2(nums, target);
    }
    public int search1(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int lv = nums[0];
        int rv = nums[nums.length - 1];
        int l, r;
        int point = findPoint(nums, lv, rv);
        if (point == 0) {
            // 未旋转
            l = 0;
            r = nums.length;
        }
        else {
            if (target > rv) {
                // 在左边
                l = 0;
                r = point;
            }
            else {
                // 在右边
                l = point;
                r = nums.length;
            }
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        if (l == nums.length) {
            return -1;
        }
        if (nums[l] != target) {
            return -1;
        }
        return l;
    }

    public int findPoint(int[] nums, int lv, int rv) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > rv) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }

    public int search2(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[l]) {
                if (nums[mid] >= target && target >= nums[l]) {
                    // 在左半边
                    r = mid;
                }
                else {
                    // 在右半边
                    l = mid + 1;
                }
            }
            else if (nums[mid] < nums[l]) {
                if (nums[mid] < target && target < nums[l]) {
                    // 在右半边
                    l = mid + 1;
                }
                else {
                    // 在左半边
                    r = mid;
                }
            }
            else {
                if (nums[mid] != target) {
                    l++;
                }
                else {
                    return mid;
                }
            }
        }
        return nums[l] == target? l: -1;
    }
}
