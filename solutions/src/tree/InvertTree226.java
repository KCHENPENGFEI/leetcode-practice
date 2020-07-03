package tree;

/**
 * @author chenpengfei
 * @date 2020/7/3 8:31 下午
 * 翻转一棵二叉树。
 * 递归地让左右子树互换位置，返回root
 */
public class InvertTree226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
