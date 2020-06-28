package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * */
public class PreorderTraversal144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 递归法
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    public void helper(TreeNode root, List<Integer> ans) {
        if (root != null) {
            ans.add(root.val);
            if (root.left != null) {
                helper(root.left, ans);
            }
            if (root.right != null) {
                helper(root.right, ans);
            }
        }
    }

    // 使用栈，每次入栈的时候将节点写入结果中
    public void preorder(LinkedList<TreeNode> stack, TreeNode root, List<Integer> result) {
        TreeNode pointer = root;
        while (pointer != null || !stack.isEmpty()) {
            while (pointer != null) {
                // 入栈
                stack.push(pointer);
                // 写结果
                result.add(pointer.val);
                // 向左遍历
                pointer = pointer.left;
            }
            // 如果节点为空了，将节点指向右兄弟节点
            pointer = stack.pop().right;
            // 如果右兄弟节点为空，向上继续寻找右兄弟节点
            while (pointer == null && !stack.isEmpty()) {
                pointer = stack.pop().right;
            }
        }
    }
}
