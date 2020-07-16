package tree;

/**
 * 二叉树的最小深度
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * */
public class MinDepth111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
//        int dl, dr;
//        return Math.min((dl = minDepth(root.left)) == 0? Integer.MAX_VALUE: dl, (dr = minDepth(root.right)) == 0? Integer.MAX_VALUE: dr) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
