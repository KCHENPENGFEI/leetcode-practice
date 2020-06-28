package recursive;

import java.util.ArrayList;
import java.util.List;

public class GrayCode89 {
    public static void main(String[] args) {
        dp.GrayCode89 grayCode89 = new dp.GrayCode89();
        System.out.println(grayCode89.grayCode(3));
    }

    private List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            // 出口
            result.add(0);
            return result;
        }
        result = grayCode(n - 1);
        int add = 1 << (n - 1);
        for (int j = result.size() - 1; j >= 0; j--) {
            result.add(result.get(j) + add);
        }
        return result;
    }
}
