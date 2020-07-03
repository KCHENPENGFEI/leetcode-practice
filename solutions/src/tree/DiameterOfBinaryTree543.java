package tree;

/**
 * @author chenpengfei
 * @date 2020/7/3 8:44 下午
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 *
 * 做法: 在求取树的深度的时候同时更新ans，看似是求树的深度，实际上最终答案也在递归的过程中求解了
 *
 */
public class DiameterOfBinaryTree543 {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int depthl = depth(node.left);
        int depthr = depth(node.right);
        ans = Math.max(ans, depthl + depthr);
        return Math.max(depthr, depthl) + 1;
    }
}
