package union.find;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author chenpengfei
 * @date 2020/6/25 11:25 上午
 */
public class CalcEquation399 {
    // parents为一个节点到达跟节点的路径，我们定义a / b为b是a的父节点
    private HashMap<String, String> parents = new HashMap<>();
    // quotients保存节点到根节点差得倍数 a / root = quotient
    private HashMap<String, Double> quotients = new HashMap<>();

    public String find(String a) {
        while (!a.equals(parents.get(a))) {
            a = parents.get(a);
        }
        return a;
    }

    public void init(String s) {
        if (!parents.containsKey(s)) {
            parents.put(s, s);
            quotients.put(s, 1.0);
        }
    }

    public void union(String a, String b, double value) {
        init(a);
        init(b);
        String pa = find(a);
        String pb = find(b);
        if (!pa.equals(pb)) {
            parents.put(pa, pb);
            // TODO 还需要理解为什么是cal(b) / cal(a)
            quotients.put(pa, value * (cal(b) / cal(a)));
        }
    }

    public double cal(String s) {
        double res = quotients.get(s);
        while (!s.equals(parents.get(s))) {
            s = parents.get(s);
            res *= quotients.get(s);
        }
        return res;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int len = values.length;
        for (int i = 0; i < len; i++) {
            union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        int ansLen = queries.size();
        double[] ans = new double[ansLen];
        for (int i = 0; i < ansLen; i++) {
            List<String> query = queries.get(i);
            if (!parents.containsKey(query.get(0)) || !parents.containsKey(query.get(1))) {
                ans[i] = -1.0;
                continue;
            }
            if (query.get(0).equals(query.get(1))) {
                ans[i] = 1.0;
                continue;
            }
            if (!find(query.get(0)).equals(find(query.get(1)))) {
                ans[i] = -1.0;
            }
            else {
                ans[i] = cal(query.get(0)) / cal(query.get(1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CalcEquation399 calcEquation399 = new CalcEquation399();
        String[][] arr = new String[][]{{"a", "b"}, {"e", "f"}, {"b", "e"}};
        List<List<String>> equations = Array2List.transform(arr);
        double[] values = new double[]{3.4D, 1.4D, 2.3D};
        String[][] arr1 = new String[][]{{"b","a"},{"a","f"},{"f","f"},{"e","e"},{"c","c"},{"a","c"},{"f","e"}};
        List<List<String>> queries = Array2List.transform(arr1);
        double[] ans = calcEquation399.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(ans));
    }

}
