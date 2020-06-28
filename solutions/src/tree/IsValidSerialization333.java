package tree;

import java.util.LinkedList;

/**
 * @author chenpengfei
 * @date 2020/6/24 11:17 下午
 *
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，
 * 我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 *
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 *
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 *
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 *
 * 做法: 当遇到4,#,#这样结尾时，删除这三个元素，然后插入一个"#"，继续循环判断，如果最后stack只有一个"#"说明可以形成一棵树
 */
public class IsValidSerialization333 {
    public boolean isValidSerialization(String preorder) {
        LinkedList<String> stack = new LinkedList<>();
        String[] strings = preorder.split(",");
        for (String s: strings) {
            stack.addLast(s);
            while (stack.size() >= 3 && "#".equals(stack.getLast()) && "#".equals(stack.get(stack.size() - 2)) && !"#".equals(stack.get(stack.size() - 3))) {
                // 执行删除
                stack.removeLast();
                stack.removeLast();
                stack.removeLast();
                stack.addLast("#");
            }
        }
        if (stack.size() == 1 && "#".equals(stack.getLast())) {
            return true;
        }
        return false;
    }
}
