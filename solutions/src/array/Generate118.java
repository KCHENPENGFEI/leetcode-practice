package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenpengfei
 * @date 2020/7/3 3:11 下午
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class Generate118 {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> first = Collections.singletonList(1);
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) {
            return ans;
        }
        ans.add(first);
        for (int i = 0; i < numRows - 1; i++) {
            first = helper(first);
            ans.add(first);
        }
        return ans;
    }

    public List<Integer> helper(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 0; i < list.size() - 1; i++) {
            result.add(list.get(i) + list.get(i + 1));
        }
        result.add(1);
        return result;
    }
}
