package unknown;

/**
 * @author chenpengfei
 * @date 2020/7/18 5:31 下午
 */
public class BobBuyFlower {
    public static void main(String[] args) {
        int value = 999999;
        int[] a = new int[]{2, 3, 2, 2, 3, 2, 2, 3, 3};
        System.out.println(solution(value, a));
    }

    public static String solution(int value, int[] a) {
        int min = a[0];
        for (int item : a) {
            if (item <= min) {
                min = item;
            }
        }
        int maxLen = value / min;
        if (maxLen == 0) {
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < maxLen; j++) {
            for (int i = a.length - 1; i >= 0; i--) {
                int left = value - a[i];
                if (left / min == maxLen - 1) {
                    // 满足要求
                    sb.append(i + 1);
                    value = left;
                    maxLen--;
                    break;
                }
            }
        }
        return sb.length() == 0 ? "-1" : sb.toString();
    }
}