package unknown;

import java.util.LinkedList;

/**
 * @author chenpengfei
 * @date 2020/7/4 2:48 下午
 */
public class MinStack155 {
    private final LinkedList<Integer> stack;
    private final LinkedList<Integer> minStack;
    public MinStack155() {
        this.stack = new LinkedList<>();
        this.minStack = new LinkedList<>();
    }

    public void push(int i) {
        stack.push(i);
        if (minStack.isEmpty() || i <= minStack.peek()) {
            minStack.push(i);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return 0;
        }
        return minStack.peek();
    }

}
