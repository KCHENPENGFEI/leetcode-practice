package bit;

/**
 * @author chenpengfei
 * @date 2020/7/19 5:19 下午
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * 从m开始按位进行与操作，如果i=Integer.MAX_VALUE，需要直接返回结果，因为此时循环应该结束，如果继续执行i++那么就溢出了
 */
public class RangeBitwiseAnd201 {
    public int rangeBitwiseAnd(int m, int n) {
        //m 要赋值给 i，所以提前判断一下
        if(m == Integer.MAX_VALUE){
            return m;
        }
        int res = m;
        for (int i = m + 1; i <= n; i++) {
            res &= i;
            // 如果i溢出了那么循环无法结束
            if(res == 0 || i == Integer.MAX_VALUE){
                break;
            }
        }
        return res;
    }
}
