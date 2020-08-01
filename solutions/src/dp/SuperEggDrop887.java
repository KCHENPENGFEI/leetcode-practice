package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenpengfei
 * @date 2020/7/31 4:42 下午
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 *
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 *
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 *
 * 你的目标是确切地知道 F 的值是多少。
 *
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 * 做法：使用动态规划，在第i层扔K个鸡蛋，如果鸡蛋碎了，那么继续从第i + 1层扔，此时鸡蛋个数为K - 1个
 * 如果鸡蛋没碎，那么从i - 1层扔，此时鸡蛋个数仍为K个，做法一种使用该种方式超时...[应该使用二分法进行查找]
 *
 */
public class SuperEggDrop887 {
    public int superEggDrop(int K, int N) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dp(memo, K, N);
    }

    public int dp(Map<Integer, Integer> map, int K, int N) {
        if (N == 0) {
            return 0;
        }
        if (K == 1) {
            return N;
        }
        // N * 100 + k用来代表K, N这个数字对
        if (map.containsKey(N * 100 + K)) {
            return map.get(N * 100 + K);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            // 从第一层开始遍历
            ans = Math.min(ans, Math.max(dp(map, K - 1, i - 1), dp(map, K, N - i)) + 1);
        }
        map.put(N * 100 + K, ans);
        return ans;
    }
}
