package tree;

import java.util.Arrays;

/**
 * @author chenpengfei
 * @date 2020/7/4 12:34 上午
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
