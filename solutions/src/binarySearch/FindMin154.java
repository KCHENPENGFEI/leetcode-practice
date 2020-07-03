package binarySearch;

/**
 * @author chenpengfei
 * @date 2020/7/3 4:41 下午
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 注意数组中可能存在重复的元素。
 *
 * 做好细致的分类，首先mid和r比较，有三种情况；然后如果相等，mid再和l比较，理论上也有三种情况，但是两种合并了
 */
public class FindMin154 {
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int l = 0;
        int r = len - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                // 在右边
                l = mid + 1;
            }
            else if (nums[mid] < nums[r]) {
                // 在左边
                r = mid;
            }
            else {
                if (nums[mid] != nums[l]) {
                    // 在左边
                    r = mid;
                }
                else {
                    r--;
                }
            }
        }
        return nums[l];
    }
}
