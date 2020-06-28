package array;

/**
 * @author chenpengfei
 * @date 2020/6/26 4:15 下午
 *
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 做法: 双指针
 */
public class RemoveDuplicates26 {
    public int removeDuplicates1(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) {
            return len;
        }
        int cnt = 1;
        int i = 0, j = 1;
        while (cnt < len && j < len) {
            if (nums[j] == nums[i]) {
                j++;
            }
            else {
                System.arraycopy(nums, j, nums, i + 1, len - j);
                i++;
                j = i + 1;
            }
            cnt++;
        }
        return i + 1;
    }

    // 避免使用了数组拷贝速度更快
    public int removeDuplicates2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }

}
