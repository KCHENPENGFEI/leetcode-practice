package array;

/**
 * @author chenpengfei
 * @date 2020/6/25 7:02 下午
 *
 * 寻找两个正序数组的中位数
 * 做法: 双指针指向两个数组头部，然后依次比较指针元素的大小，较小的那个指针往后移一位
 */
public class FindMedianSortedArrays4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0) {
            if (len2 % 2 == 0) {
                return (double) (nums2[len2 / 2] + nums2[len2 / 2 - 1]) / 2;
            }
            else {
                return (double) nums2[len2 / 2];
            }
        }
        if (len2 == 0) {
            if (len1 % 2 == 0) {
                return (double) (nums1[len1 / 2] + nums1[len1 / 2 - 1]) / 2;
            }
            else {
                return (double) nums1[len1 / 2];
            }
        }
        int allLen = len1 + len2;
        int index = 0;
        int i = 0, j = 0;
        int cur = 0;
        int pre = 0;
//        while (index <= allLen / 2) {
//            // 如果allLen是偶数，那么中位数就是(pre + cur) / 2；是奇数那么就是cur
//            pre = allLen % 2 == 0? cur: 0;
//            // 如果j > len2说明数组2已经遍历结束，直接遍历数组1就好了
//            if ((i < len1 && j < len2 && nums1[i] < nums2[j]) || j >= len2) {
//                cur = nums1[i];
//                i++;
//            }
//            else if ((i < len1 && j < len2 && nums1[i] >= nums2[j]) || i >= len1) {
//                cur = nums2[j];
//                j++;
//            }
//            index++;
//        }
        // 换种清晰的写法
        while (index <= allLen / 2) {
            pre = allLen % 2 == 0? cur: 0;
            if (i < len1 && j < len2) {
                if (nums1[i] < nums2[j]) {
                    cur = nums1[i];
                    i++;
                }
                else {
                    cur = nums2[j];
                    j++;
                }
            }
            else if (i >= len1) {
                cur = nums2[j];
                j++;
            }
            else {
                cur = nums1[i];
                i++;
            }
            index++;
        }
        return allLen % 2 == 0? (double) (pre + cur) / 2: (double) cur;
    }
}
