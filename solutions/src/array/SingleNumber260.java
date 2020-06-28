package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenpengfei
 * @date 2020/6/25 4:11 下午
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * 做法: 将元素进行分组，假如数组中有两个数字不同A,B，那么必定存在一位A[i]和B[i]其中一个是1一个0，
 * 所以A^B的结果中必定有一位是1，记为S[i]，找到i的位置，然后根据其他元素a[i]是否为1进行分组，此时A和B就可以分到两个组中，
 * 对每一个数组进行^操作可以得到A和B
 */
public class SingleNumber260 {
    public int[] singleNumber(int[] nums) {
        return singleNumber1(nums);
    }

    // O(N)空间复杂度
    public int[] singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i: nums) {
            if (!set.contains(i)) {
                set.add(i);
            }
            else {
                set.remove(i);
            }
        }
        return set.stream().mapToInt(Integer::valueOf).toArray();
    }

    // O(1)空间复杂度
    public int[] singleNumber2(int[] nums) {
        int [] res = new int [2];
        if (nums == null || nums.length < 2) {
            return res;
        }
        int xorRes = 0;
        for (int x : nums) {
            xorRes ^= x;
        }
        int temp = 1; // 用来标志第几位是 1
        while (true) {
            if ((xorRes & 1) == 1) {
                break;
            }
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
