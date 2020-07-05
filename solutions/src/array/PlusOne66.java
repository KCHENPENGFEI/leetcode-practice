package array;

/**
 * @author chenpengfei
 * @date 2020/7/5 10:14 上午
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 */
public class PlusOne66 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] ans = new int[len + 1];
        int carry = 1;
        for (int i = len - 1; i > -1; i--) {
            int sum = carry + digits[i];
            int mod = sum % 10;
            carry = sum / 10;
            ans[i + 1] = mod;
        }
        if (carry == 1) {
            ans[0] = 1;
            return ans;
        }
        else {
            ans[0] = 0;
            int[] realAns = new int[len];
            System.arraycopy(ans, 1, realAns, 0, len);
            return realAns;
        }
    }
}
