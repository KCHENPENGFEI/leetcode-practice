package dp;

import java.util.Map;

/**
 * @author chenpengfei
 * @date 2020/8/1 10:55 上午
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 做法一: 使用不带memo备忘录的递归，这样会导致大量的重复计算，浪费性能，但是本做法是最基础的做法
 * 做法二: 使用带memo的情况
 */
public class Rob337 {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 返回根节点偷与不偷的最大值
        return Math.max(dp(root, true), dp(root, false));
    }

    public int dp(TreeNode root, boolean ifRob) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        if (ifRob) {
            // 如果根节点要偷，那么ans += root.val，然后左右子节点都不能偷
            ans += root.val;
            ans += dp(root.left, false);
            ans += dp(root.right, false);
        }
        else {
            // 如果根节点不偷，那么左右子节点可以偷也可以不偷，返回这两种情况的最大值
            ans += Math.max(dp(root.left, true), dp(root.left, false));
            ans += Math.max(dp(root.right, true), dp(root.right, false));
        }
        return ans;
    }

    public int dpWithMemo(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) {
            return 0;
        }
        // 如果该节点已经在memo中那么可以直接返回结果
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        // 分两种情况，root偷与不偷
        // 如果偷，那么左右子节点就不能偷，只能去偷孙子节点
        int doRob = root.val + (root.left == null? 0: dpWithMemo(root.left.left, memo) + dpWithMemo(root.left.right, memo))
                + (root.right == null? 0: dpWithMemo(root.right.left, memo) + dpWithMemo(root.right.right, memo));
        int doNotRob = dpWithMemo(root.left, memo) + dpWithMemo(root.right, memo);
        // 写入memo
        int max = Math.max(doNotRob, doRob);
        memo.put(root, max);
        return  max;
    }
}
