package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 判断镜像二叉树
 * 方法一: 利用镜像二叉树性质，递归判断左子树是否等于右子树，这里一定是递归判断，
 * 不能简单的仅仅判断左子树=右子树，必须要所有的左子树都等于右子树
 * 方法二: 将一棵树进行一次镜像翻转，然后对比和原来的数是否相同，原理上和一一样
 * */
public class IsSymmetric101 {
    public boolean isSymmetric(TreeNode root) {
        /*先对原始树做备份, 然后做一次翻转，再判断是否相同*/
        // TreeNode copy = copyTree(root);
        // TreeNode mirrorTree = mirror(root);
        // return isSameTree(copy, mirrorTree);
        /*直接判断是否为镜像树*/
        return isMirror(root, root);
    }

    public TreeNode mirror(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newLeft = mirror(root.left);
        TreeNode newRight = mirror(root.right);
        root.right = newLeft;
        root.left = newRight;
        return root;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p.val == q.val) {
            boolean left = isSameTree(p.left, q.left);
            boolean right = isSameTree(p.right, q.right);
            return left&&right;
        }
        return false;
    }

    public boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            boolean a = isMirror(p.left, q.right);
            boolean b = isMirror(p.right, q.left);
            return a&&b;
        }
        return false;
    }

    public TreeNode copyTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = copyTree(root.left);
        TreeNode right = copyTree(root.right);
        return new TreeNode(root.val, left, right);
    }
}
