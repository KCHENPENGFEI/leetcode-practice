package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一棵树是否为二叉搜索树
 * 1、利用二叉搜索树特性，可以直接中序遍历该树，如果结果是顺序的那么说明是二叉搜索树
 * 2、直接判断，利用了最大值和最小值对左子树和右子树进行了限制
 * */
public class IsValidBST98 {
    public boolean isValidBST(TreeNode root) {
        // return helper(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1);
        List<Integer> result = new ArrayList<>();
        inoder(result, root);
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i) >= result.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean helper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        // 递归左树
        boolean isLeft = helper(root.left, min, (long) root.val);
        // System.out.println(isLeft);
        boolean isRight = helper(root.right, (long) root.val, max);
        // System.out.println(isRight);
        return isLeft&&isRight;
    }

    public void inoder(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        inoder(result, root.left);
        result.add(root.val);
        inoder(result, root.right);
    }
}
