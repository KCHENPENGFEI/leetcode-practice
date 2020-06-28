package tree;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 做法: 二叉搜索树中序遍历是一个递增数列，其实可以优化一下代码，增加一个标志位，如果找到了就不需要继续遍历下去了
 * */
public class KthSmallest230 {
    int cnt = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return result;
    }

    private void helper(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        helper(root.left, k);
        cnt++;
        if (cnt == k) {
            // 找到
            result = root.val;
            return;
        }
        helper(root.right, k);
    }
}
