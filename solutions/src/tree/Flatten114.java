package tree;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 * 将所有元素以先序遍历的顺序全部保存到root.right
 * */
public class Flatten114 {
    public void flatten(TreeNode root) {
        helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        // 左子树递归
        TreeNode left = helper(root.left);
        // 右子树递归
        TreeNode right = helper(root.right);
        // 保存原来的右子树不能丢失
        TreeNode tmp = root.right;
        // 将右子树替换为左子树
        root.right = left;
        // 循环寻找替换后的最右边的节点
        TreeNode pointer = root;
        while (pointer.right != null) {
            pointer = pointer.right;
        }
        // 找到后将原先保存的右子树拼接上去
        pointer.right = tmp;
        // 让左子树指向空
        root.left = null;
        return root;
    }
}
