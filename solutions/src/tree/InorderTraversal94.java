package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * */
public class InorderTraversal94 {
    public List<Integer> inorderTraversal(TreeNode root) {
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
            ans.add(root.val);
            if (root.right != null) {
                helper(root.right, ans);
            }
        }
    }

    // 使用栈迭代，这里使用LinkedList，使用Deque速度更慢
    public void inorder(LinkedList<TreeNode> stack, TreeNode root, List<Integer> result) {
        TreeNode pointer = root;
        while (pointer != null || !stack.isEmpty()) {
            while (pointer != null) {
                // 入栈
                stack.push(pointer);
                pointer = pointer.left;
            }
            // pointer为空时候出栈
            pointer = stack.pop();
            result.add(pointer.val);
            // 指向右子节点
            pointer = pointer.right;
        }
    }
}
