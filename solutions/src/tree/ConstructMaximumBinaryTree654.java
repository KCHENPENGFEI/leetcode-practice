package tree;

import java.util.Arrays;

/**
 * @author chenpengfei
 * @date 2020/7/4 12:34 上午
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 */
public class ConstructMaximumBinaryTree654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int id = findMax(nums);
        TreeNode root = new TreeNode(nums[id]);
        int[] leftArr = Arrays.copyOfRange(nums, 0, id);
        int[] rightArr = Arrays.copyOfRange(nums, id + 1, nums.length);
        TreeNode left = constructMaximumBinaryTree(leftArr);
        TreeNode right = constructMaximumBinaryTree(rightArr);
        root.left = left;
        root.right = right;
        return root;
    }

    public int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                res = i;
            }
        }
        return res;
    }
}
