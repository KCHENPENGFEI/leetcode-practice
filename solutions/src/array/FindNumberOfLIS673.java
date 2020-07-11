package array;

/**
 * @author chenpengfei
 * @date 2020/7/11 5:47 下午
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 * 动态规划：
 * 定义lengths[i]为以nums[i]为结尾最长上升子序列的长度
 * 定义counts[i]为以nums[i]为结尾最长上升子序列的数量
 */
public class FindNumberOfLIS673 {
    public static void main(String[] args) {
        FindNumberOfLIS673 findNumberOfLIS673 = new FindNumberOfLIS673();
        int[] num = new int[]{1,3,7,6,5,8};
        findNumberOfLIS673.findNumberOfLIS(num);
    }
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        if (N <= 1) {
            return N;
        }
        int maxLen = 1;
        int maxCnt = 1;
        int[] lengths = new int[N];
        int[] counts = new int[N];

        lengths[0] = 1;
        counts[0] = 1;
        for (int i = 1; i < N; ++i) {
            // 初始化都是1
            lengths[i] = 1;
            counts[i] = 1;
            for (int j = 0; j < i; ++j) {
                // 只有满足上升才进入更新
                if (nums[i] > nums[j]) {
                    // 此时说明最长的长度可以更新，于是最长长度加1，
                    // 并且此时最长长度的数量就是counts[j]
                    if (lengths[i] < lengths[j] + 1) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    }
                    // 此时说明最长长度不用更新，但是最长长度的数量需要加上counts[j]
                    else if (lengths[i] == lengths[j] + 1) {
                        counts[i] += counts[j];
                    }
                }
            }
            // 对于整个数组而言，判断是否需要更新maxLen和maxCnt
            if (lengths[i] > maxLen) {
                maxLen = lengths[i];
                maxCnt = counts[i];
            }
            else if (lengths[i] == maxLen) {
                maxCnt += counts[i];
            }
        }

        return maxCnt;
    }
}
