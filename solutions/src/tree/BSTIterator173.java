package tree;

import java.util.LinkedList;

/**
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 * 二叉搜索树的中序遍历可以返回一个递增的数组
 **/
public class BSTIterator173 {
    private LinkedList<Integer> list = new LinkedList<>();

    public BSTIterator173(TreeNode root) {
        helper(root);
    }

    /** @return the next smallest number */
    public int next() {
        if (!hasNext()) {
            return -1;
        }
        return this.list.pop();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !this.list.isEmpty();
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        this.list.addLast(root.val);
        helper(root.right);
    }
}
