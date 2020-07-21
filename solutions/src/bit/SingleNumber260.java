package bit;

/**
 * @author chenpengfei
 * @date 2020/7/19 5:21 下午
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * 做法：把所有数字进行亦或就得到了A^B的结果
 * 然后找到这个结果中最低位等于1的位置i，说明第i位A和B不相同，
 * 然后根据这一位去将A和B划分到两个数组中
 */
public class SingleNumber260 {
    public int[] singleNumber(int[] nums) {
        int [] res = new int [2];
        if (nums == null || nums.length < 2) {
            return res;
        }
        int xorRes = 0;
        for (int x : nums) {
            xorRes ^= x;
        }
        int temp = 1; // 用来标记第几位是不同的，如temp为0001000那么就意味着第四位不同，一个是0，一个是1
        while ((xorRes & 1) != 1) {
            temp = temp << 1;
            xorRes = xorRes >> 1; // 右移，从低到高
        }

        for (int y : nums) {
            if ((y & temp) == 0) { // 对应位是 0
                res[0] ^= y;
            } else {
                res[1] ^= y;
            }
        }
        return res;
    }
}
