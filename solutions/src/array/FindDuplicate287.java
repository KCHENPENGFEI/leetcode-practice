package array;

/**
 * @author chenpengfei
 * @date 2020/7/11 7:42 下午
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 方法一和方法二都是O(N)复杂度，方法三是O(NlogN)复杂度
 */
public class FindDuplicate287 {
    public int findDuplicate(int[] nums) {
        // 替换法
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
            if (i != nums[i] - 1) {
                return nums[i];
            }
        }
        return 0;
    }
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    public int findDuplicate1(int[] nums) {
        // 负数法
        for (int i = 0; i < nums.length; i++) {
            int curNum = Math.abs(nums[i]);
            if (nums[curNum - 1] < 0) {
                return curNum;
            }
            nums[curNum - 1] = -nums[curNum - 1];
        }
        return 0;
    }
    public int findDuplicate2(int[] nums) {
        if (nums.length == 2) {
            return nums[1];
        }
        // 暴力法
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[j] == nums[i]) {
        //             // 找到
        //             return nums[j];
        //         }
        //     }
        // }
        // return 0;
        // 二分法
        int len = nums.length;
        int r = len - 1;
        int l = 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (cnt(nums, mid) > mid) {
                r = mid;
            }
            else {
                l = mid + 1;
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
