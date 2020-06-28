package binarySearch;

/**
 * 使用二分法搜索旋转数组
 * 首先使用一次二分法找到旋转数组的转折点在哪（判断中点和左右端点的关系）
 * 如果找到的位置是0，那么说明数组并未进行旋转
 * 如果不是0，那么定义搜索范围要么在左边，要么在右边
 * */
public class Search30 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 8;
        Search30 search30 = new Search30();
        System.out.println(search30.search(nums, target));
    }
    public int search(int[] nums, int target) {
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
