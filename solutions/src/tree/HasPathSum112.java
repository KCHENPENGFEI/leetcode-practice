package tree;

/**
 * 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 本题有一个点要注意的是如果只有root=sum，且有一个子树为空，这时候要返回false，因为不存在叶子节点
 * */
public class HasPathSum112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return helper(root, sum);
    }

    public boolean helper(TreeNode root, int sum) {
        if (root == null) {
            return sum == 0;
        }
        if (root.left == null) {
            return helper(root.right, sum - root.val);
        }
        if (root.right == null) {
            return helper(root.left, sum - root.val);
        }
        return helper(root.left, sum - root.val) || helper(root.right, sum - root.val);
    }
}
