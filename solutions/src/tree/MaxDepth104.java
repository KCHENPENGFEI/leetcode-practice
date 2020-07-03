package tree;

/**
 * 求二叉树的最大深度
 * 递归地找到左子树和右子树的高度，然后返回Max+1
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
