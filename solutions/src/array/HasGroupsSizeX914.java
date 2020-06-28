package array;

/**
 * @author chenpengfei
 * @date 2020/6/25 9:44 上午
 *
 * 卡牌分组
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 */
public class HasGroupsSizeX914 {
    public boolean hasGroupsSizeX(int[] deck) {
        int len = deck.length;
        if (len < 2) {
            return false;
        }

        // 计数数组，10000 是根据题目给出的数值范围定的
        int[] cnt = new int[10000];
        for (int num : deck) {
            cnt[num]++;
        }

        // 先得到第 1 个数的个数，以避免在循环中赋值
        int x = cnt[deck[0]];

        for (int i = 0; i < 10000; i++) {
            if (cnt[i] == 1) {
                return false;
            }

            if (cnt[i] > 1) {
                x = gcd(x, cnt[i]);

                // 这里做判断可以提前终止运行，也可以等到最后再做，各有优劣，任选其一
                if (x == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // 求解最大公约数，辗转相除法
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
