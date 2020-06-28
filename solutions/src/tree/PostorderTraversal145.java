package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 后续遍历
 * */
public class PostorderTraversal145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        // 递归法
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    public void helper(TreeNode root, List<Integer> ans) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, ans);
            }
            if (root.right != null) {
                helper(root.right, ans);
            }
            ans.add(root.val);
        }
    }

    // 思路如下: 接下来我们思考一下前序遍历和后序遍历之间的关系：
    //
    //前序遍历顺序为：根 -> 左 -> 右
    //
    //后序遍历顺序为：左 -> 右 -> 根
    //
    //如果1： 我们将前序遍历中节点插入结果链表尾部的逻辑，修改为将节点插入结果链表的头部
    //
    //那么结果链表就变为了：右 -> 左 -> 根
    //
    //如果2： 我们将遍历的顺序由从左到右修改为从右到左，配合如果1
    //
    //那么结果链表就变为了：左 -> 右 -> 根
    //
    //这刚好是后序遍历的顺序
    // 使用了stack进行辅助只有向右侧迭代时候才会将父节点压入stack
    public void postorder(LinkedList<Integer> result, TreeNode root) {
        // 辅助栈用于定位结果中的元素
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pointer = root;
        while (pointer != null || !stack.isEmpty()) {
            while (pointer != null) {
                result.addFirst(pointer.val);
                stack.push(pointer);
                pointer = pointer.right;
            }
            if (!stack.isEmpty()) {
                pointer = stack.pop();
                pointer = pointer.left;
            }
        }
    }
}
