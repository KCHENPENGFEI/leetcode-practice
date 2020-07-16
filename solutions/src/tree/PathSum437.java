package tree;

/**
 * @author chenpengfei
 * @date 2020/6/24 1:03 上午
 *
 * * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *  *
 *  * 找出路径和等于给定数值的路径总数。
 *  *
 *  * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 解题：对于类似不需要从根节点出发的树的遍历的问题，首先解决根节点的问题，然后依次递归左子节点和右子节点
 * 解决根节点问题的方法可以是递归的也可以是不递归的。
 */

public class PathSum437 {
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        helper(root, 0, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res;
    }

    private void helper(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return;
        }
        if (sum + root.val == targetSum) {
            res++;
        }
        helper(root.left, sum + root.val, targetSum);
        helper(root.right, sum + root.val, targetSum);
    }
}
