package doublePointer;

/**
 * 求能盛最多水的面积
 * 双指针一前一后，每次移动的规则是: 哪根木板短就向内部移动一格，两根指针重叠返回结果
 **/
public class MaxArea11 {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            // 求面积
            max = Math.max(max, vol(i, j, height));
            if (height[i] < height[j]) {
                i++;
            }
            else {
                j--;
            }
        }
        return max;
    }

    public int vol(int index1, int index2, int[] height) {
        if (index1 > index2) {
            return 0;
        }
        int a = index2 - index1;
        int b = Math.min(height[index1], height[index2]);
        // System.out.println(a * b);
        return a * b;
    }
}
