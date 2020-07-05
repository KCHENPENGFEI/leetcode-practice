package string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenpengfei
 * @date 2020/7/5 1:06 上午
 */
public class IsValid20 {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (Character c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                else {
                    if (c == ')' && stack.pop() != '(') {
                        return false;
                    }
                    else if (c == ']' && stack.pop() != '[') {
                        return false;
                    }
                    else if (c == '}' && stack.pop() != '{') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
