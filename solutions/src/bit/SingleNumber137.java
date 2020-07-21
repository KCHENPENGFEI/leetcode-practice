package bit;

/**
 * @author chenpengfei
 * @date 2020/7/19 5:38 下午
 */
public class SingleNumber137 {
    public int singleNumber(int[] nums) {
        int[] cnt = new int[32];
        for (int num: nums) {
            for (int i = 0; i < 32; i++) {
                cnt[31 - i] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= cnt[i] % m;
        }
        return res;
    }
}
