package string;

/**
 * @author chenpengfei
 * @date 2020/7/4 11:27 下午
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 做法一: 每一位循环相乘然后结果相加，耗时难写
 * 做法二: 优化版竖式，num1[i] * num[j]的结果为tmp，要么是"0x"格式要么是"xy"格式，其第一位在res[i + j], 第二位在res[i + j + 1]
 */
public class Multiply43 {

    public String multiply2(String num1, String num2) {
        if ("0".equals(num1) || "".equals(num2)) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int ji = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = res[i + j + 1] + ji;
                res[i + j] += sum / 10;
                res[i + j + 1] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == '0' && i == 0) {
                continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }

    public String multiply1(String num1, String num2) {
        String result = "0";
        if ("0".equals(num1) || "".equals(num2)) {
            return "0";
        }
        char[] num2Arr = num2.toCharArray();
        for (int i = 0; i < num2Arr.length; i++) {
            char item = num2Arr[num2Arr.length - 1 - i];
            String tmp = multiplySingle(num1, item, i);
            // System.out.println(tmp);
            result = add(result, tmp);
        }
        return result;
    }

    public String add(String a, String b) {
        int carry = 0;
        int lenA = a.length();
        int lenB = b.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(lenA, lenB); i++) {
            int item1 = (i >= lenA)? 0: a.charAt(lenA - i - 1) - '0';
            int item2 = (i >= lenB)? 0: b.charAt(lenB - i - 1) - '0';
            int he = item1 + item2 + carry;
            int sum = he % 10;
            carry = he / 10;
            sb.append(sum);
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public String multiplySingle(String a, char b, int cnt) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        if (b == '0') {
            return "0";
        }
        for (int i = 0; i < a.length(); i++) {
            int item = a.charAt(a.length() - i - 1) - '0';
            int ji = item * (b - '0') + carry;
            int res = ji % 10;
            carry = ji / 10;
            sb.append(res);
        }
        if (carry != 0) {
            sb.append(carry);
        }
        sb.reverse();
        while (cnt > 0) {
            sb.append(0);
            cnt--;
        }
        return sb.toString();
    }
}
