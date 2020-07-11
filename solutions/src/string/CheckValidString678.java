package string;

import java.util.LinkedList;

/**
 * @author chenpengfei
 * @date 2020/7/8 11:18 下午
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 做法: 遇到(和*则将下标入栈，遇到)则优先将(出栈，如果(没有了，那么就*出栈
 * 字符串访问结束后，如果(栈为空说明有效，否则判断(和*中下标的顺序，如果*在(的id之后数量多，那么说明可以匹配完
 */
public class CheckValidString678 {
    public boolean checkValidString(String s) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                stack1.push(i);
            }
            else if (c == '*') {
                stack2.push(i);
            }
            else {
                if (stack1.isEmpty() && stack2.isEmpty()) {
                    return false;
                }
                else {
                    if (!stack1.isEmpty()) {
                        stack1.poll();
                    }
                    else {
                        stack2.poll();
                    }
                }
            }
        }
        if (stack1.isEmpty()) {
            return true;
        }
        else {
            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                int id = stack1.poll();
                // 判断*是否在(之后
                if (stack2.peek() < id) {
                    return false;
                }
                stack2.poll();
            }
            return stack1.isEmpty();
        }
    }
}
