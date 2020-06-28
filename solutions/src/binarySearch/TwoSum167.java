package binarySearch;

/**
 * 两数之和 II - 输入有序数组
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * */
public class TwoSum167 {
    public int[] twoSum(int[] numbers, int target) {
        // 二分法
        // for (int i = 0; i < numbers.length; i++) {
        //     int diff = target - numbers[i];
        //     if (diff < numbers[i]) {
        //         break;
        //     }
        //     int index = fun(i + 1, numbers, diff);
        //     if (index != -1) {
        //         return new int[] {i + 1, index + 1};
        //     }
        // }
        // return new int[] {};
        // 双指针法（更快）
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum < target) {
                l++;
            }
            else if (sum > target) {
                r--;
            }
            else {
                return new int[]{l + 1, r + 1};
            }
        }
        return new int[]{};
    }

    int fun(int start, int[] numbers, int target) {
        int len = numbers.length;
        int end = len - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (numbers[mid] < target) {
                start = mid + 1;
            }
            else if (numbers[mid] > target) {
                end = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
