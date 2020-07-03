package array;

/**
 * @author chenpengfei
 * @date 2020/7/3 3:06 下午
 * 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 */
public class Merge88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        // 从后往前插的话可以避免大量的数组移动和下标移动
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[index] = nums1[m - 1];
                m--;
            }
            else {
                nums1[index] = nums2[n - 1];
                n--;
            }
            index--;
        }
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
    }
}
