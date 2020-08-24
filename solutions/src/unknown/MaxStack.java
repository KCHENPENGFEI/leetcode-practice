package unknown;

import java.util.LinkedList;

/**
 * @author chenpengfei
 * @date 2020/7/18 8:29 下午
 * 设计一个最大栈，支持 push、pop、top、peekMax 和 popMax 操作。
 * 构造两个栈，其中一个栈保存push进去的元素，另一个栈的大小需要和第一个栈保持一致【用于popMax操作】
 * 如: 插入数据为[5, 1, 1]，那么第一个栈的元素为(栈顶)[1, 1, 5](栈底)，第二个栈元素为[5, 5, 5]
 * 所以push为如果x大于最大栈栈顶元素，那么push栈顶元素进入最大栈
 * popMax操作为：确定最大值为max，然后依次弹出stack和maxStack的数值，如果相等那么循环终止，
 * 然后将刚才pop出来的数据再次push回去
 */
class MaxStack {
    private LinkedList<Integer> stack;
    private LinkedList<Integer> maxStack;

    /** initialize your data structure here. */
    public MaxStack() {
        this.stack = new LinkedList<>();
        this.maxStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        }
        else {
            maxStack.push(maxStack.peek());
        }
    }

    public int pop() {
        int x = stack.pop();
        maxStack.pop();
        return x;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }


    public int popMax() {
        LinkedList<Integer> tmp = new LinkedList<>();
        int max = maxStack.peek();
        int x = pop();
        while (x != max) {
            tmp.push(x);
            x = pop();
        }
        while (!tmp.isEmpty()) {
            push(tmp.pop());
        }
        return max;
    }
}