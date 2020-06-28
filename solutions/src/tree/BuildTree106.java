package tree;

import java.util.Arrays;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * */
public class BuildTree106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length || inorder.length == 0) {
            return null;
        }
        int len = inorder.length;
        // root节点
        TreeNode root = new TreeNode(postorder[len - 1]);
        for (int i = 0; i < len; i++) {
            if (postorder[len - 1] == inorder[i]) {
                int[] postorderRight = Arrays.copyOfRange(postorder, i, len - 1);
                int[] postorderLeft = Arrays.copyOfRange(postorder, 0, i);
                int[] inorderRight = Arrays.copyOfRange(inorder, i + 1, len);
                int[] inorderLeft = Arrays.copyOfRange(inorder, 0, i);
                root.right = buildTree(inorderRight, postorderRight);
                root.left = buildTree(inorderLeft, postorderLeft);
                break;
            }
        }
        return root;
    }
}
