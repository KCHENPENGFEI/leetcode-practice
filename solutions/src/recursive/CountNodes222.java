package recursive;

/**
 * 计算完全二叉树的节点数量
 * 使用递归，如果节点不为空的话，结果就加一，然后递归左树和右树
 * */
public class CountNodes222 {
    int result = 0;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        result += 1;
        countNodes(root.left);
        countNodes(root.right);
        return result;
    }
}

