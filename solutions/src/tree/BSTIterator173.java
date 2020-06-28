package tree;

import java.util.LinkedList;

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
