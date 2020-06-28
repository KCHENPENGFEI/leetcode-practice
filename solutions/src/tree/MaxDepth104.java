package tree;

/**
 * 求二叉树的最大深度
 * */
public class MaxDepth104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int dLeft = maxDepth(root.left);
        int dRight = maxDepth(root.right);
        return Math.max(dLeft, dRight) + 1;
    }
}
