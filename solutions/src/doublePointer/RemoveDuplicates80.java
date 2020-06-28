package doublePointer;

public class RemoveDuplicates80 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        RemoveDuplicates80 removeDuplicates80 = new RemoveDuplicates80();
        System.out.println(removeDuplicates80.removeDuplicates(nums));
    }
    public int removeDuplicates(int[] nums) {
        int first = 0;
        int last = 0;
        int length = nums.length;
        while (last < length) {
            int len = last - first + 1;
            if (last == length - 1) {
                if (len > 2) {
                    int deleteLen = len - 2;
                    length -= deleteLen;
                }
                last++;
            }
            else {
                if (nums[first] != nums[last + 1]) {
                    if (len > 2) {
                        // 开始删除
                        int deleteLen = len - 2;
                        System.arraycopy(nums, last + 1, nums, first + 2, length - last - 1);
                        // 缩短长度
                        length -= deleteLen;
                        last -= deleteLen;
                    }
                    first = last + 1;
                    last++;
                }
                else {
                    last++;
                }
            }
        }
        // 处理最后一段重复数字
//        int len = last - first;
//        if (len > 2) {
//            int deleteLen = len - 2;
//            length -= deleteLen;
//        }
        return length;
    }
}
