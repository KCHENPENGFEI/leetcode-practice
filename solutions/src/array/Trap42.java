package array;

/**
 * @author chenpengfei
 * @date 2020/7/3 7:04 下午
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 做法一: 按照每一列来求取该列能够存储多少水量，然后累加
 *
 */
public class Trap42 {
    public int trap(int[] height) {
        return trap1(height);
    }

    // 按照列的顺序来求解
    public int trap1(int[] height) {
        int ans = 0;
        // 最左和最右的墙上面肯定不会有水
        for (int i = 1; i < height.length - 1; i++) {
            int curHeight = height[i];
            int leftMaxHeight = 0;
            int maxRightHeight = 0;
            for (int l = 0; l < i; l++) {
                leftMaxHeight = Math.max(leftMaxHeight, height[l]);
            }
            for (int r = i + 1; r < height.length; r++) {
                maxRightHeight = Math.max(maxRightHeight, height[r]);
            }
            // 只有左边、右边最矮的墙的高度大于当前的墙，该列才会有水
            int minHeight = Math.min(leftMaxHeight, maxRightHeight);
            if (minHeight > curHeight) {
                ans += minHeight - curHeight;
            }
        }
        return ans;
    }

    // 使用动态规划降低时间复杂度
    public int trap2(int[] height) {
        int ans = 0;
        int[] leftMaxHeight = new int[height.length];
        int[] rightMaxHeight = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            leftMaxHeight[i] = Math.max(leftMaxHeight[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightMaxHeight[i] = Math.max(rightMaxHeight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int minHeight = Math.min(leftMaxHeight[i], rightMaxHeight[i]);
            if (minHeight > height[i]) {
                ans += minHeight - height[i];
            }
        }
        return ans;
    }
}
