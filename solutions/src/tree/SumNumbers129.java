package tree;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 * */
public class SumNumbers129 {
    int allSum = 0;
    public int sumNumbers(TreeNode root) {
        trackback(0, root);
        return allSum;
    }

    private void trackback(int sum, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            // 叶子节点
            allSum += sum * 10 + root.val;
            // 因为没有把sum增加所以不需要删除
            return;
        }
        sum = sum * 10 + root.val;
        trackback(sum, root.left);
        trackback(sum, root.right);
        sum -= root.val;
        sum /= 10;
    }
}
