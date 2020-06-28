package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码
 * 思路: 倒序然后加上2 ^ (n - 1)使用动态规划的思想
 * 本题写法使用的是for循环，也可以使用递归的写法
 * */
public class GrayCode89 {
    public static void main(String[] args) {
        GrayCode89 grayCode89 = new GrayCode89();
        System.out.println(grayCode89.grayCode(3));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> gray = new ArrayList<>();
        gray.add(0);
        for (int i = 0; i < n; i++) {
            int add = 1 << i;
            for (int j = gray.size() - 1; j >= 0; j--) {
                gray.add(gray.get(j) + add);
            }
        }
        return gray;
    }
}
