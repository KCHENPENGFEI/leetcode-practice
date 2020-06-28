package tree;

import java.util.Arrays;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 做法1: 以数组中间的数作为root
 * */
public class SortedArrayToBST108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int i = nums.length / 2;
        TreeNode root = new TreeNode(nums[i]);
        int[] numsLeft = Arrays.copyOfRange(nums, 0, i);
        int[] numsRight = Arrays.copyOfRange(nums, i + 1, nums.length);
        root.left = sortedArrayToBST(numsLeft);
        root.right = sortedArrayToBST(numsRight);
        return root;
    }
}
