package tree;

import java.util.Arrays;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 做法1: 根据前序遍历数组中第一个数必定为树的根节点R，然后在中序遍历数组中定位R，下标为i
 * 将中序数组以R为中心左右分开就得到了左子树的中序数组和右子树的中序数组，
 * 将前序数组中以[1, i]和[i + 1, length]为划分分成左右数组，分别就是左子树的前序数组和右子树的前序数组，然后递归
 * */
public class BuildTree105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        // 找到根节点
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                // 形成左子树和右子树的preorder和inorder
                int[] preorderLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] preorderRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                int[] inorderLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inorderRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                root.left = buildTree(preorderLeft, inorderLeft);
                root.right = buildTree(preorderRight, inorderRight);
                break;
            }
        }
        return root;
    }
}
