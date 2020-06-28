package binarySearch;

/**
 * 寻找重复的数字
 * 二分法思路: 利用抽屉原理(10个苹果放在9个抽屉中，必然有一个抽屉的苹果数量大于1)，
 * 在一个数字区间内计算中位数，统计nums中小于等于这个数字的个数，如果不存在重复的数字，那么这个个数肯定等于mid，
 * 如果超过了，那就说明重复的数就在[left, mid]之间，然后继续缩小范围
 * */
public class FindDuplicate287 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,4,5};
        FindDuplicate287 findDuplicate287 = new FindDuplicate287();
        System.out.println(findDuplicate287.findDuplicate1(nums));
    }
    public int findDuplicate(int[] nums) {
        if (nums.length == 2) {
            return nums[1];
        }
        // 暴力法
         for (int i = 0; i < nums.length; i++) {
             for (int j = i + 1; j < nums.length; j++) {
                 if (nums[j] == nums[i]) {
                     // 找到
                     return nums[j];
                 }
             }
         }
         return 0;
    }

    public int findDuplicate1(int[] nums) {
        // 二分法
        int l = 1;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (cnt(nums, mid) <= mid) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }

    public int cnt(int[] nums, int target) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                result++;
            }
        }
        return result;
    }
}
