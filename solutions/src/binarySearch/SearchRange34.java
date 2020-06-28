package binarySearch;

import java.util.Arrays;

/**
 * 本题就是求解上下界限问题
 *
 * 更推荐使用lowBound1()和upBound1()来进行定位，需要注意的是如果想让l逐渐往r靠近，那么mid要向下取整
 * 如果想让r往l靠近，那么mid要向上取整
 **/
public class SearchRange34 {
    public static void main(String[] args) {
        SearchRange34 searchRange34 = new SearchRange34();
        int[] nums = new int[]{1,1,2,2,3,3};
        int target = 2;
        System.out.println(Arrays.toString(searchRange34.searchRange(nums, target)));
    }
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        // 先求下界
        int low = lowBound1(nums, target);
        if (low == -1) {
            return new int[] {-1, -1};
        }
        int up = upBound1(nums, target);
        return new int[] {low, up};

    }

    public int lowBound1(int[] nums, int target) {
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
        return nums[l] == target?l: -1;
    }

    public int upBound1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            }
            else {
                l = mid;
            }
        }
        return nums[l] == target?l: -1;
    }

    public int lowBound(int[] nums, int target) {
        // 左闭右开区间
        int l = 0;
        int r = nums.length;
        while (l < r) {
            // 向下取整
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            }
            else {
                // 保证是开区间
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

    public int upBound(int[] nums, int target) {
        // 左开右闭
        int l = -1;
        int r = nums.length - 1;
        while (l < r) {
            // 向上取整
            int mid = l + (r - l + 1) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            }
            else {
                l = mid;
            }
        }
        if (r == -1) {
            return -1;
        }
        if (nums[r] != target) {
            return -1;
        }
        return r;
    }
}
