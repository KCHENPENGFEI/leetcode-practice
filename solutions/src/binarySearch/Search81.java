package binarySearch;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * */
public class Search81 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,2,0,1,1};
        int target = 0;
        Search81 search81 = new Search81();
        System.out.println(search81.search(nums, target));
    }
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == nums[l]) {
                // 如果等于target直接返回true
                if (target == nums[l]) {
                    return true;
                }
                // 否则排除掉最左边的数字
                l++;
            }
            else if (nums[mid] < nums[l]) {
                if (nums[mid] < target && target <= nums[r]) {
                    // 在右半边
                    l = mid + 1;
                }
                else {
                    // 在左半边
                    r = mid;
                }
            }
            else {
                if (nums[mid] >= target && target >= nums[l]) {
                    // 在左半边
                    r = mid;
                }
                else {
                    l = mid + 1;
                }
            }
        }
        return nums[l] == target;
    }
}
