package binarySearch;

/**
 * 寻找峰值
 * 解题思路: 当mid为第一个值或者最后一个值时候，判断单边的单调情况给出结果
 * 当mid在中间时候，判断双边的单调性，如果是峰值就是直接返回，如果单调递增，则l变成mid+1，
 * 如果单调递减则r变成mid-1
 * 解题二: 在数组左右添加一个最小数字
 * */
public class FindPeakElement162 {
    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,4,2,3};
        FindPeakElement162 findPeakElement162 = new FindPeakElement162();
        System.out.println(findPeakElement162.findPeakElement(num));
    }
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            // 当mid为0时候，左值不存在，额外进行判断
            if (mid == 0) {
                if (nums[mid + 1] < nums[mid]) {
                    return 0;
                }
                else {
                    l = mid + 1;
                }
            }
            // 当mid为num.length - 1时候，右值不存在，额外进行判断
            else if (mid == nums.length - 1) {
                if (nums[mid - 1] < nums[mid]) {
                    return nums.length - 1;
                }
                else {
                    r = mid - 1;
                }
            }
            else {
                /* 找到峰值 */
                if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) {
                    return mid;
                }
                /* 处于递增区间 */
                else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                    l = mid + 1;
                }
                /* 处于递减区间或者处于波谷 */
                else {
                    r = mid - 1;
                }
            }
        }
        return l;
    }
//    public int findPeakElement1(int[] nums) {
//        if (nums.length == 0) {
//            return -1;
//        }
//        if (nums.length == 1) {
//            return 0;
//        }
//        int l = 0;
//        int r = nums.length - 1;
//        while (l < r) {
//            int mid = l + (r - l) / 2;
//            if (mid == 0) {
//                if (nums[mid] > nums[mid + 1]) {
//                    return mid;
//                }
//                else {
//                    l = mid + 1;
//                }
//            }
//            else if (mid == nums.length - 1) {
//                if (nums[mid] > nums[mid - 1]) {
//                    return mid;
//                }
//                else {
//                    r = mid - 1;
//                }
//            }
//            else {
//                if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
//                    l = mid + 1;
//                }
//                else if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]) {
//                    r = mid - 1;
//                }
//                else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
//                    return mid;
//                }
//                else {
//                    /* 处于波谷，l或者r任一变换一个 */
//                    l = mid + 1;
//                }
//            }
//        }
//        return l;
//    }
}
