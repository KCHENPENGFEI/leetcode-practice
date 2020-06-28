package binarySearch;

/**
 * 寻找旋转排序数组中的最小值
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * */
public class FindMin153 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,8,9,0,1,2,3};
        FindMin153 findMin153 = new FindMin153();
        System.out.println(findMin153.findMin(nums));
    }
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int lv = nums[0];
        int rv = nums[nums.length - 1];
        int point = findPoint(nums, lv, rv);
        return nums[point];
    }
    /**
     * 这里使用最右边的值进行判断大小的原因是，如果对于没有翻转的序列，右边值将会是最大的，
     * 那么r就会不断左移，然后返回index为0，不用额外判断数组越界。如果使用lv，那么l就会不断右移，
     * 最终会返回num.length，如果不额外判断就会造成数组越界
     * */
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
}
