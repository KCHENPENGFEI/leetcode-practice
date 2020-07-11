package unknown;

/**
 * @author chenpengfei
 * @date 2020/7/8 7:45 下午
 */
public class PreimageSizeFZF793 {
    public static void main(String[] args) {
        PreimageSizeFZF793 preimageSizeFZF793 = new PreimageSizeFZF793();
        System.out.println(preimageSizeFZF793.zeta(201));
    }

    public int preimageSizeFZF(int K) {
        long l = 4L * K;
        long r = 5L * K;
        while (l < r) {
            long mid = l + (r - l) / 2;
            if (zeroNums(mid) == K) {
                return 5;
            } else if (zeroNums(mid) < K) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return zeroNums(l) == K ? 5 : 0;
    }

    public int zeroNums(long K) {
        int count = 0;
        long flag;
        while (K > 0) {
            flag = K / 5;
            count += flag;
            K /= 5;
        }
        return count;
    }

    public long zeta(long x) {
        if (x == 0) return 0;
        return x / 5 + zeta(x / 5);
    }

}
