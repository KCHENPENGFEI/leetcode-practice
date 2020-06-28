package unknown;

import java.util.LinkedList;

/**
 * @author chenpengfei
 * @date 2020/6/26 3:06 下午
 *
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 *
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * 逆波兰表达式主要有以下两个优点：
 *
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
 *
 */
public class EvalRPN150 {
    public int evalRPN(String[] tokens) {
        LinkedList<String> stack = new LinkedList<>();
        for (String token: tokens) {
            if (!isOperator(token)) {
                stack.push(token);
            }
            else {
                int b = Integer.valueOf(stack.poll());
                int a = Integer.valueOf(stack.poll());
                int res;
                if ("+".equals(token)) {
                    res = a + b;
                }
                else if ("-".equals(token)) {
                    res = a - b;
                }
                else if ("*".equals(token)) {
                    res = a * b;
                }
                else {
                    res = a / b;
                }
                stack.push(String.valueOf(res));
            }
        }
        return Integer.valueOf(stack.poll());
    }

    public boolean isOperator(String s) {
        return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
    }
}
