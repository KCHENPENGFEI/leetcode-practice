package string;

/**
 * @author chenpengfei
 * @date 2020/7/5 2:34 下午
 */
public class AddStrings415 {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            int a = i < num1.length()? (num1.charAt(num1.length() - 1 - i) - '0'): 0;
            int b = i < num2.length()? (num2.charAt(num2.length() - 1 - i) - '0'): 0;
            int res = a + b + carry;
            int c = res % 10;
            carry = res / 10;
            result.insert(0, c);
        }
        if (carry == 1) {
            result.insert(0, 1);
        }
        return result.toString();
    }
}
