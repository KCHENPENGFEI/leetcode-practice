package hashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 为了不出现溢出的情况，使用long代替int
 *
 * */
public class FractionToDecimal166 {
    public static void main(String[] args) {
        int a = -1;
        int b = -2147483648;
        FractionToDecimal166 fractionToDecimal166 = new FractionToDecimal166();
        System.out.println(fractionToDecimal166.fractionToDecimal(a, b));
    }
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return "";
        }
        if (numerator == 0) {
            return "0";
        }
        boolean positive;
        positive = (numerator > 0 && denominator > 0) || (numerator < 0 && denominator < 0);
        long numeratorL = (long) numerator;
        long denominatorL = (long) denominator;
        numeratorL = Math.abs(numeratorL);
        denominatorL = Math.abs(denominatorL);
        // 先求整数部分
        long IntegerPart = numeratorL / denominatorL;
        long left = numeratorL - IntegerPart * denominatorL;
        if (left == 0) {
            if (!positive) {
                return "-" + IntegerPart;
            }
            return String.valueOf(IntegerPart);
        }
        // 求取小数部分
        StringBuilder all = new StringBuilder(String.valueOf(IntegerPart));
        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        while (left != 0 && !map.containsKey(left)) {
            int size = map.keySet().size();
            map.put(left, size);
            long tmp = left * 10;
            long shang = tmp / denominatorL;
            sb.append(shang);
            left = tmp - shang * denominatorL;
        }
        if (left == 0) {
            // 不是无限循环小数
            all.append('.').append(sb);
        }
        else {
            // 是无限循环小数
            int index = map.get(left);
            sb.insert(index, '(');
            sb.append(')');
            all.append('.').append(sb);
        }
        if (!positive) {
            all.insert(0, '-');
        }
        return all.toString();
    }
}
